<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="./include/includefile.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보</title>
<script type="text/javascript">
	window.onload = function(){
		$('#goPopup').hide();
	}
	function goPopup(){
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		var pop = window.open("juso","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
		
		// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
	    //var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	}


	function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
			// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.;
			frmRegi.addr.value = roadAddrPart1;
			frmRegi.addrdetail.value = addrDetail;
			frmRegi.zipcode.value = zipNo;		
	}
	
	function transform(){
		frmMyinfo.nickname.readOnly = false;
		frmMyinfo.email.readOnly = false;
		frmMyinfo.zipcode.readOnly = false;
		frmMyinfo.addr.readOnly = false;
		frmMyinfo.addrdetail.readOnly = false;
		$('#goPopup').show();
		$('#btn_modi').value="수정 완료";
		$('#btn_modi').on('click',()=>{
			
		})
	}
</script>
</head>
<body>
	<%@include file="./header.jsp" %>
	<form name="frmMyinfo" action="${path}/member/modi" method="post">
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="userid" value="${member.userid}" readonly></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="nickname" value="${member.nickname}" readonly></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="email" name="email" value="${member.email}" readonly></td>
		</tr>
		<tr>
			<th>주소</th>
			<td> 
				<input type="text" name="zipcode" size="5" value="${member.zipcode}" readonly>
				<button id="goPopup" type="button" onclick="goPopup()">찾기</button> 
				<hr>
				<input type="text" name="addr" size="30" value="${member.addr}" readonly> <br>
				<input type="text" name="addrdetail" size="30" value="${member.addrdetail}" readonly>
			</td>
		</tr>			
		<tr>
			<td colspan="2" align="center"><button id="btn_modi" type="button" onclick="transform()">내 정보 수정하기</button></td>
		</tr>
	</table>
</form>
</body>
</html>