<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>마이페이지</title>
</head>

<body>



            <h1 class="text-center">마이페이지</h1>


			<div style="text-align:left;">
			<u><strong>이름</strong></u><br> ${dto.mb_name } <br><br>
			<u><strong>아이디</strong></u><br> ${dto.mb_id }  <br><br>
			<u><strong>이메일</strong></u><br> ${dto.mb_email }<br><br>
			<u><strong>가입날짜</strong></u><br> ${dto.mb_regDate }<br>
			<br>
		  </div>


			<form name="frm" id="update_frm" method="post" enctype="Multipart/form-data" action="mypageOk" onsubmit="return chkSubmit()">
				<input type="hidden" name="mb_uid" value="${dto.mb_uid }">

				이름　　　 　<input class="update_info" type="text" name="mb_name" placeholder="회원이름" value="${dto.mb_name }" required></span>
				아이디　　 　<input class="update_info" type="text" name="mb_id" placeholder="회원아이디" value="${dto.mb_id }" disabled></span>
				비밀번호　　 <input class="update_info" type="password" name="mb_pw" placeholder="회원비밀번호" value="" pattern="^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$" style="height: 50px;"></span>
				비밀번호확인 <input class="update_info" type="password" name="mb_pwOk" placeholder="비밀번호 변경시 재확인" id="mb_pwOk" style="height: 50px;"></span>
				이메일　　 　<input class="update_info" type="text" name="mb_email" placeholder="회원이메일" value="${dto.mb_email }" id="mb_email"></span>				

				<input id="reg_submit" class="find_btn btn btn-primary" style="width: 100px; margin-top: -40px; padding: 10px;" type="submit" value="수정하기">

			</form>
	
</body>
</html>