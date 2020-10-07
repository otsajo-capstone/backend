<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>회원가입</title>

<body>
	
	<form action="loginOk">


			<input type="text" name="mb_id" placeholder="아이디를 입력하세요">		
		
			<input type="password" name="mb_pw" placeholder="비밀번호를 입력하세요">		

				
			<button type="submit">로그인</button>
			
	</form>
				<div>
					<div class="findIdPw">
						<button type="button" onclick="location.href='${pageContext.request.contextPath}/member/findIdPw'">ID | PW 찾기</button>
						<button type="button" onclick="location.href='${pageContext.request.contextPath}/member/signUp'">회원가입</button>
					</div>
				</div>	


</body>
</html>