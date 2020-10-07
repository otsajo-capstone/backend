<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    

<c:choose>  
	<c:when test="${findPwOk == 0}">
		<script>
			alert("비밀번호 찾기 실패");
			history.back();
		</script>  
	</c:when>
	<c:when test="${findPwOk == 1}">
		<script>
			alert("비밀번호 찾기 성공");
		</script>
	</c:when>
</c:choose>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>비밀번호 찾기 성공</title>

</head>
<body>
	
            <h1 class="text-center">비밀번호 찾기</h1>

			<div class="findOk_content">고객님의 이메일로<br>비밀번호가 발송되었습니다.</div><br><br>
			<button class="login_btn btn btn-primary" onclick="location.href='login'">로그인</button>

</body>
</html>