<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ include file="../include/includefile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 내용</title>

<script id="template_source" type="text/x-handlebars-template">
	{{#each .}}
		<hr>
		{{#relevelSpace relevel}}
		{{/relevelSpace}}
		<div id="reply{{rnum}}">
			<span hidden="hidden" id="reply{{rnum}}">{{rnum}}</span>
			<span hidden="hidden" id="restep{{rnum}}">{{restep}}</span>
			<span hidden="hidden" id="relevel{{rnum}}">{{relevel}}</span>
			닉네임:<span id="nickname{{rnum}}">{{nickname}}</span><br>
			내용:<span id="content{{rnum}}">{{content}}</span><br>
			<button class="btnReReplyAdd" value="{{rnum}}">댓글</button>
			<button class="btnReReplyModi" value="{{rnum}}">수정</button>
			<button class="btnReReplyRemove" value="{{rnum}}">삭제</button>
		</div>
	{{/each}}
	<div id="divReply">
		<div id="divReplyInput" style="display: none;">
			<input type="hidden" id="restep" size="3">
	   	 	<input type="hidden" id="relevel" size="3">
	    	<input type="hidden" id="nickname">
	    	<div class="card">
    			<div class="card-header">
      				<label for="comment">Comment:</label>
      			</div>
      			<div class="card-body">
      				<textarea class="form-control" rows="5" id="reContent"></textarea>
      				<button type="button" class="btn btn-primary" id="btnReplyAdd" style="margin-top:16px">작성</button>
      			</div>
   			</div>
		</div>
		<div id="divReplyModi" style="display: none;">
			<input type="hidden" id="rnum" size="3">
			<div class="card">
    			<div class="card-header">
      				<label for="comment">Comment:</label>
      			</div>
      			<div class="card-body">
	    			<textarea class="form-control" rows="5" id="reModiContent"></textarea>
					<button type="button" class="btn btn-primary" id="btnReplyModi" style="margin-top:16px">수정</button>
				</div>
			</div>
		</div>
	</div>
</script>

<script type="text/javascript">
	$(function(){
		Handlebars.registerHelper('relevelSpace',function(relevel){
			var result='';
			for(var i = 0; i < relevel; i++){
				result += '<i class="fab fa-replyd"></i>';
			}
			return result;
		});
		
		function selectReplies(){
			$('#divReply').hide();
			
			var anum=${article.anum};
			$.ajax({
				url:'${path}/reply/${anum}',
				type:'get',
				dataType:'json',
				success: function(data){
					console.log(data);
					var source = $('#template_source').html();
					var template = Handlebars.compile(source);
					$('#divReplyList').html(template(data));
					
					//댓글입력창 추가버튼 이벤트
					$('#btnReplyAdd').on('click',function(){
						var anum = ${article.anum};
						var nickname = '${sessionScope.nickname}';
						var content = $('#reContent').val();
						var restep = $('#restep').val();
						var relevel = $('#relevel').val();
						if(content === ''){
							alret('댓글 내용을 작성해주세요.');
							return
						}
						
						$.ajax({
							url:'${path}/reply',
							type:'post',
							data: JSON.stringify({anum,nickname,content,restep,relevel}),
							contentType:'application/json',
							dataType:'text',
							success:function(data){
								console.log(data);
								selectReplies();
							},
							error:function(e){
								console.log(e);
								alert("댓글작성 실패");
							}
						});
					});
					
					//댓글입력창 수정버튼 이벤트
					$('#btnReplyModi').on('click',function(){
						var rnum = $('#rnum').val();
						var content = $('#reModiContent').val();
						console.log(rnum);
						console.log(content);
						if(content === ''){
							alret('댓글 내용을 작성해주세요.');
							return
						}
						
						$.ajax({
							url:'${path}/reply',
							type:'put',
							data: JSON.stringify({rnum,content}),
							contentType:'application/json',
							dataType:'text',
							success:function(data){
								selectReplies();
							},
							error:function(e){
								console.log(e);
								alert("댓글작성 실패");
							}
						});
					});
				},
				error: function(e){
					console.log(e);
					alert('실패');
				}
			});
		}
		
		//원본글 댓글입력 클릭 시
		$('#btnReply').on('click',function() {
			$('#divReply').insertAfter('#frmDetail');
			$('#divReplyModi').hide();
			$('#divReplyInput').show();
			if($('#rnum').val() !== ''){
				var beforernum = $('#rnum').val();
				$('#reply'+beforernum).show();
				$('#rnum').val('');
			}
			$('#nickname').val('${sessionScope.nickname}');
			$('#restep').val('0');
			$('#relevel').val('0');
		});

		$('#divReplyList').on('click',function(e){
			var target = e.target;
			var rnum = target.getAttribute("value");
			var restep = $('#restep'+rnum).text();
			var relevel = $('#relevel'+rnum).text();
			//대댓글입력 클릭 시
			if(target.getAttribute("class") === "btnReReplyAdd"){
				$('#divReply').insertAfter('#reply'+rnum);
				$('#divReplyModi').hide();
				if($('#rnum').val() !== ''){
					var beforernum = $('#rnum').val();
					$('#reply'+beforernum).show();
					$('#rnum').val('');
				}
				$('#divReplyInput').show();
				$('#nickname').val('${sessionScope.nickname}');
				$('#restep').val(restep);
				$('#relevel').val(relevel);
			//대댓글수정 클릭 시
			}else if(target.getAttribute("class") === "btnReReplyModi"){
				$('#divReply').insertAfter('#reply'+rnum);
				if($('#rnum').val() !== ''){
					var beforernum = $('#rnum').val();
					$('#reply'+beforernum).show();
					$('#rnum').val('');
				}
				$('#divReplyInput').hide();
				$('#reply'+rnum).hide();
				$('#rnum').val(rnum);
				$('#reModiContent').val($('#content'+rnum).text());
				$('#divReplyModi').show();
			//대댓글삭제 클릭 시
			}else if(target.getAttribute("class") === "btnReReplyRemove"){
				if(confirm("삭제하시겠습니까?")){
					$.ajax({
						url:'${path}/reply/'+rnum,
						type:'delete',
						dataType:'text',
						success:function(){
							selectReplies();
						},
						error:function(e){
							console.log(e);
							alert("댓글삭제 실패");
						}
					});
				}
			}
		});
		
	
		function checkAuthority(){
			if('${sessionScope.nickname}' != '${article.nickname}'){
				return false;
			}else{
				return true;
			}
		}
		//원본글 수정
		$('#btn_modi').on('click',function(){
			if(checkAuthority()){
				$('#frmDetail').attr('action','${path}/board/modiform/${article.anum}')
						.attr('method','get')
						.attr('enctype','multipart/form-data')
						.submit();
			}else{
				alert("권한이 없습니다.");
			}
		});
		//원본글 삭제
		$('#btn_del').on('click',function(){
			if(checkAuthority()){
				$('#frmDetail').attr('action','${path}/board/${article.b_id}/${article.anum}')
				.attr('method','post')
				.submit();
			}else{
				alert("권한이 없습니다.");
			}
		});
		
		selectReplies();
	});
</script>
</head>

<body>
	<%@include file="../header.jsp" %>
	<div id="content-wrapper">
	<%@ include file="../aside.jsp" %>
	<div class="container text-light">
	<form id="frmDetail" class="form-horizontal">
		<div class="form-group">
		    <label class="col-sm-2 control-label">번호</label>
		    <div class="col-sm-10">
		      <p class="form-control-static">${article.anum}</p>
		    </div>
  		</div>
  		<div class="form-group">
		    <label class="col-sm-2 control-label">등록일자</label>
		    <div class="col-sm-10">
		      <p class="form-control-static"><fmt:formatDate value="${article.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
		    </div>
  		</div>
  		<div class="form-group">
		    <label class="col-sm-2 control-label">수정일자</label>
		    <div class="col-sm-10">
		      <p class="form-control-static"><fmt:formatDate value="${article.modidate}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
		    </div>
  		</div>
  		<div class="form-group">
		    <label class="col-sm-2 control-label">조회수</label>
		    <div class="col-sm-10">
		      <p class="form-control-static">${article.readcnt}</p>
		    </div>
  		</div>
  		<div class="form-group">
		    <label class="col-sm-2 control-label">작성자</label>
		    <div class="col-sm-10">
		      <p class="form-control-static">${article.nickname}</p>
		    </div>
  		</div>
  		<div class="form-group">
		    <label class="col-sm-2 control-label">제목</label>
		    <div class="col-sm-10">
		      <p class="form-control-static">${article.subject}</p>
		    </div>
  		</div>
  		<div class="form-group">
		    <label class="col-sm-2 control-label">내용</label>
		    <div class="col-sm-10">
		      <c:forEach var = "file" items="${files}">
					<img src="/filepath/${file.filename}">
			  </c:forEach>
		      <p class="form-control-static">${article.content}</p>
		    </div>
  		</div>
	</form>
	<button type="button" id="btn_modi">수정하기</button>
	<button type="button" id="btn_del">삭제하기</button>
	<button type="button" id="btnReply">댓글</button>
	<div id="divReplyList"></div>
	</div>
	</div>
</body>
</html>