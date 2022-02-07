<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="./include/includefile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" href="${path}/resources/css/signin.css">
<script type="text/javascript">
	function loginCheck(){
		var id = frmLogin.userid.value;
		var passwd = frmLogin.passwd.value;
		
		if(id == ""){
			alert("아이디를 입력해주세요");
			frmLogin.userid.focus();
		}else if(passwd == ""){
			alert("비밀번호를 입력해주세요");
			frmLogin.passwd.focus();
		}else{
			frmLogin.submit();
		}
	}
</script>
</head>
<body class="text-center">
<main class="form-signin">
	<form name="frmLogin" action="${path}/login" method="post">
	<h1 class="h3 mb-3 fw-normal">로그인</h1>
		<div class="form-floating">
      		<input type="email" class="form-control" name="userid" id="floatingInput" placeholder="ID" value="${cookie.id.value}">
      		<label class="form-control-label" for="floatingInput" style="display: none;">ID</label>
    	</div>
    	<div class="form-floating">
      		<input type="password" class="form-control" name="passwd" id="floatingPassword" placeholder="Password">
     		<label class="form-control-label" for="floatingPassword" style="display: none;">Password</label>
    	</div>
		<div class="checkbox mb-3">
      		<label>
      			<c:choose>
	      			<c:when test="${not empty cookie.id.value}">
	       				<input type="checkbox" name="idsave" value="remember-me" checked> Remember me
	       			</c:when>
	       			<c:otherwise>
	       				<input type="checkbox" name="idsave" value="remember-me"> Remember me
	       			</c:otherwise>
      			</c:choose>
      		</label>
    	</div>
    	<button type="button" class="w-100 btn btn-lg btn-primary" onclick="loginCheck()">로그인 하기</button>
		<a href="${path}/member/regi">회원가입</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="">아이디 찾기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="">비밀번호 찾기</a>	
	</form>
</main>
</body>
</html>