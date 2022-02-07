<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/includefile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
function pagemove(e,curpage){
	e.preventDefault();
	var findkey = frmBoardList.findkey.value;
	var findvalue = frmBoardList.findvalue.value;
	location.href="${path}/board/${board.b_id}?findkey="+findkey+"&findvalue="+findvalue+"&curpage="+curpage;
	
}

	$(function(){
		$('#btn_add').on('click',()=>{
			if('${sessionScope.authority}'>= '${board.write_level}'){
				location.href="${path}/board/add/${board.b_id}";
			}else{
				alert('로그인 후 이용가능합니다.');
			}
		});
		
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
</script>
<title></title>
</head>
<body>
	<%@include file="../header.jsp" %>
	<div id="content-wrapper">
	<%@ include file="../aside.jsp" %>
	<div class="container text-light">
	<div>
		<table class="table table-striped table-dark">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="article" items="${alist}">
				<tr>
					<td>${article.anum}</td>
					<td><a href="${path}/board/${article.b_id}/${article.anum}?cntplus=1">${article.subject}</a></td>
					<td>${article.nickname}</td>
					<td><fmt:formatDate value="${article.regidate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td>${article.readcnt}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<!-- 페이징 -->
	<nav>
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
				<a class="page-link" href="#" onclick="pagemove(event,${i})">${i}</a>
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
	
	<form name="frmBoardList" action="${path}/board/${board.b_id}" method="get">
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
</body>
</html>