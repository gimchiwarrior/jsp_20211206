<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<aside>
		<div class="d-flex flex-column flex-shrink-0 p-3">
		    <ul class="nav nav-pills flex-column mb-auto">
		      <li class="nav-item">
		        <a href="${path}/board/notice" class="nav-link link-light" aria-current="page">
		          <svg class="bi me-2" width="16" height="16"><use xlink:href="#home"/></svg>
		          공지사항
		        </a>
		      </li>
		      <li>
		        <a href="${path}/board/free" class="nav-link link-dark">
		        	<svg class="bi me-2" width="16" height="16"><use xlink:href="#grid"/></svg>
		          자유게시판
		        </a>
		      </li>
		      <li>
		        <a href="${path}/board/gallery" class="nav-link link-dark">
		        <svg class="bi me-2" width="16" height="16"><use xlink:href="#grid"/></svg>
		          갤러리
		        </a>
		      </li>
		      <li>
		        <a href="${path}/board/qna" class="nav-link link-dark">
		          <svg class="bi me-2" width="16" height="16"><use xlink:href="#grid"/></svg>
		          QnA
		        </a>
		      </li>
		      <li>
		        <a href="${path}/chat" class="nav-link link-dark">
		          <svg class="bi me-2" width="16" height="16"><use xlink:href="#people-circle"/></svg>
		          대화방
		        </a>
		      </li>
		    </ul>
		    <hr>
		    <div class="dropdown">
		      <a href="#" class="d-flex align-items-center link-light text-decoration-none dropdown-toggle" id="dropdownUser2" data-bs-toggle="dropdown" aria-expanded="false">
		        <strong>${sessionScope.nickname}</strong>
		      </a>
		      <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser2">
		        <li><a class="dropdown-item" href="#">New project...</a></li>
		        <li><a class="dropdown-item" href="#">Settings</a></li>
		        <li><a class="dropdown-item" href="#">Profile</a></li>
		        <li><hr class="dropdown-divider"></li>
		        <li><a class="dropdown-item" href="#">Sign out</a></li>
		      </ul>
		    </div>
		  </div>
	</aside>
</body>
</html>