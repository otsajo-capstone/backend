<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>아이디 비밀번호 찾기</title>
</head>
<script>
// form 검증
function chkSubmit1(){
	frm1 = document.forms["frm1"];
	
	var mb_id = frm1["mb_id"].value.trim();
	var mb_pw = frm1["mb_pw"].value.trim();
	var mb_name = frm1["mb_name"].value.trim();
	var mb_email = frm1["mb_email"].value.trim();
	
	if(mb_name == ""){
		alert("이름을 입력해주세요.");
		frm1["mb_name"].focus();
		return false;
	}
	if(mb_email == ""){
		alert("이메일을 입력해주세요.");
		frm1["mb_email"].focus();
		return false;
	}
	
	return true;
}

function chkSubmit2(){
	frm2 = document.forms["frm2"];
	
	var mb_id = frm2["mb_id"].value.trim();
	var mb_name = frm2["mb_name"].value.trim();
	var mb_email = frm2["mb_email"].value.trim();
	
	if(mb_id == ""){
		alert("아이디를 입력해주세요.");
		frm2["mb_id"].focus();
		return false;
	}
	if(mb_name == ""){
		alert("이름을 입력해주세요.");
		frm2["mb_name"].focus();
		return false;
	}
	if(mb_email == ""){
		alert("이메일을 입력해주세요.");
		frm2["mb_email"].focus();
		return false;
	}
	
	return true;
}
</script>
<body>

                  <h1 class="text-center">아이디 비밀번호 찾기</h1>
                  

		       	<h2>아이디 찾기</h2><br>
				<form name="frm1" id="find_id_frm" method="post" action="findIdOk" onsubmit="return chkSubmit1()">
			       		<input name="mb_name" class="find_info form-control" type="text" placeholder="이름" required="required">
			       		<input name="mb_email" class="find_info form-control" type="text" placeholder="ex)  *****@example.com" required="required">
			       		<button type="submit" class="find_btn btn btn-primary">아이디 찾기</button>
				</form>

			
				<h2>비밀번호 찾기</h2><br>
				<form name="frm2" id="find_pw_frm" method="get" action="findPwOk" onsubmit="return chkSubmit2()" >
						<input name="mb_id" class="find_info form-control" type="text" placeholder="아이디" required="required">
						<input name="mb_name" class="find_info form-control" type="text" placeholder="이름" required="required">
						<input name="mb_email" class="find_info form-control" type="text" placeholder="ex)  *****@example.com" required="required">
						<button type="submit" class="find_btn btn btn-primary">비밀번호 찾기</button>
				</form>
	
	<br><br><br><br>

</body>
</html>