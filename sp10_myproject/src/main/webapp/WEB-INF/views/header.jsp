<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/includefile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	if('${msg}'!='')
		alert("${msg}");
</script>
<link rel="stylesheet" href="${path}/resources/css/header.css">
</head>
<body>
	<%-- <header class="header">
		<c:if test="${empty sessionScope.userid}">
			<a href="${path}/login">로그인</a>
			<a href="${path}/member/regi">회원가입</a>
		</c:if>
		<c:if test="${not empty sessionScope.userid}">
			<a href="${path}/member/myInfo">${sessionScope.userid}</a>
			<a href="${path}/logout">로그아웃</a>
		</c:if>
		<a href="${path}/board">게시판</a>
	</header> --%>

    <header class="d-flex flex-wrap align-items-center justify-content-center justify-content-md-between py-3 border-bottom">
      <a href="/" class="d-flex align-items-center col-md-3 mb-2 mb-md-0 text-white text-decoration-none">
        <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap"><use xlink:href="#bootstrap"/></svg>
      </a>

      <ul class="nav col-12 col-md-auto mb-2 justify-content-center mb-md-0">
        <li><a href="${path}/home" class="nav-link px-2 link-white">Home</a></li>
      </ul>
		
	<c:choose>
	<c:when test="${empty sessionScope.nickname}">
      <div class="col-md-3 text-end">
        <button type="button" class="btn btn-outline-primary me-2" onclick='location.href="${path}/login"'>Login</button>
        <button type="button" class="btn btn-primary" onclick='location.href="${path}/member/regi"'>Sign-up</button>
      </div>
    </c:when>
    <c:otherwise>
    	<div class="col-md-3 text-end">
        <button type="button" class="btn btn-outline-primary me-2" onclick='location.href="${path}/logout"'>LogOut</button>
      </div>
    </c:otherwise>
    </c:choose>
    </header>
</body>
</html>