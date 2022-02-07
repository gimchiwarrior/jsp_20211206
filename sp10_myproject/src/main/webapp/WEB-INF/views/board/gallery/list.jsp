<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../include/includefile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>갤러리</title>
<script type="text/javascript">
$(function(){
	$('#btn_add').on('click',()=>{
		if('${sessionScope.authority}'>= '${board.write_level}'){
			location.href="${path}/board/add/${board.b_id}";
		}else{
			alert('로그인 후 이용가능합니다.');
		}
	});
	
	$('.btn_view').on('click',function(e){
		var anum = e.target.id;
		if('${sessionScope.authority}'>= '${board.read_level}'){
			location.href="${path}/board/gallery/"+anum+"?cntplus=1";
		}else{
			alert('로그인 후 이용가능합니다.');
		}
	})
	
	function makeTitle(){
		var title;
		if('${board.b_id}' == "notice"){
			title = "공지사항";
		}else if('${board.b_id}' == "free"){
			title = "자유게시판";
		}else if('${board.b_id}' == "qna"){
			title = "QnA";
		}else if('${board.b_id}' == "gallery"){
			title = "갤러리";
		}else if('${board.b_id}' == "chat"){
			title = "대화방";
		}
		document.title=title;
	}
	
	makeTitle();
});
function pagemove(e,curpage){
	e.preventDefault();
	var findkey = frmBoardList.findkey.value;
	var findvalue = frmBoardList.findvalue.value;
	location.href="${path}/board/gallery?findkey="+findkey+"&findvalue="+findvalue+"&curpage="+curpage;
	
}
</script>
</head>
<body>
	<%@include file="../../header.jsp" %>
	<div id="content-wrapper">
		<%@ include file="../../aside.jsp" %>
		<div class="album py-5">
		<div class="container">
			<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
			<c:forEach var="article" items="${alist}" varStatus="status">
				<div class="col" style="width:245px;">
		          <div class="card shadow-sm">
		            <img src="/filepath/${tlist[status.index].filename}">
		            <div class="card-body">
		              <p class="card-text">${article.subject}</p>
		              <div class="d-flex justify-content-between align-items-center">
		                <div class="btn-group">
		                  <button type="button" id="${article.anum}" class="btn btn-sm btn-outline-secondary btn_view">View</button>
		                </div>
		              </div>
		            </div>
		          </div>
		        </div>
		    </c:forEach>
			</div>
			
			<!-- 페이징 -->
			
			<nav style="margin-top: 16px;">
			  <ul class="pagination">
			  <c:choose>
			    <c:when test="${page.startpage != 1}">
			    	<li class="page-item">
			    </c:when>
			    <c:otherwise>
			    	<li class="page-item disabled">
			    </c:otherwise>
			   </c:choose>
			      	<a class="page-link" href="" onclick="pagemove(event,${page.startpage-1})" aria-label="Previous">
			        <span aria-hidden="true">&laquo;</span>
			      </a>
			    </li>
			    <c:forEach var="i" begin="${page.startpage}" end="${page.endpage}">
			    	<c:choose>
				    	<c:when test="${page.curpage == i}">
							<li class="page-item active">
						</c:when>
						<c:otherwise>
							<li class="page-item">
						</c:otherwise>
					</c:choose>
						<a class="page-link" href="" onclick="pagemove(event,${i})">${i}</a>
					</li>
				</c:forEach>
			    <c:choose>
			    <c:when test="${page.endpage < page.totpage}">
			    	<li class="page-item">
			    </c:when>
			    <c:otherwise>
			    	<li class="page-item disabled">
			    </c:otherwise>
			   </c:choose>
			      	<a class="page-link" href="" onclick="pagemove(event,${page.endpage+1})" aria-label="Next">
			        <span aria-hidden="true">&raquo;</span>
			      </a>
			    </li>
			  </ul>
			</nav>
			
			<form name="frmBoardList" action="${path}/board/gallery" method="get" style="
    margin-top: 16px;">
		<button type="button" id="btn_add">글쓰기</button>
		<select name="findkey">
			<option value="nickname">닉네임</option>
			<option value="subject">제목</option>
			<option value="content">내용</option>
			<option value="subcon">제목 + 내용</option>
		</select>
		<input type="text" name="findvalue">
		<button>검색</button>
	</form>
		</div>
	</div>
	</div>
	
</body>
</html>