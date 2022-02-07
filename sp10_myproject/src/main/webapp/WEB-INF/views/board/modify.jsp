<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includefile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript">
	$(function(){
		$('.btnFileAdd').on('click',function(){
			var li = `<li><input type="file" name="files">
				<button type="button" class="btnFileDel">제거</button></li>`;
			$('#file_list').append(li);	
		});
		
		$('#file_list').on('click','.btnFileDel',function(){
			$(this).parent().remove();
		});
		
		$('#btn_modi').on('click',()=>{
			if(confirm("수정하시겠습니까?")){
				frmModiBoard.submit();
			}
		})
	});
	</script>
</head>
<body>
	<%@include file="../header.jsp" %>
	<div id="content-wrapper">
	<%@ include file="../aside.jsp" %>
	<div class="container text-light">
	<form class="form-horizontal" name="frmModiBoard" action="${path}/board/modify" method="post" enctype="multipart/form-data">
		<div class="form-group">
		    <label for="inputSubject">번호</label>
		    <input type="text" class="form-control" name="anum" value="${result.article.anum}" readonly>
		  </div>
		  <div class="form-group">
		    <label for="inputSubject">제목</label>
		    <input type="text" class="form-control" id="inputSubject" name="subject" value="${result.article.subject}">
		  </div>
		  <div class="form-group">
		    <label for="inputContent">내용</label>
		    <textarea class="form-control" id="inputContent" name="content" rows="25" cols="25">${result.article.content}</textarea>
		  </div>
		  <div class="form-group">
		  <label for="inputFile">파일</label>
		  	<c:forEach var="file" items="${result.files}">
				${file.filename}
				<input type="checkbox" name="removeFile" value="${file.fnum}">삭제
			</c:forEach>
		  </div>
		  <div class="form-group">
		    <label for="inputFile">파일 업로드</label>
		    <button type="button" id="inputFile" class="btnFileAdd">추가</button>
				<ol id="file_list">
					<li>
						<input type="file" name="files">
						<button type="button" class="btnFileDel">제거</button>
					</li>
				</ol>	
		  </div>
	  	<button class="btn btn-primary">수정 완료</button>
	  	<input type="hidden" name="nickname" value = "${sessionScope.nickname}">
		<input type="hidden" name="b_id" value = "${result.article.b_id}">
	</form>
	</div>
	</div>
</body>
</html>