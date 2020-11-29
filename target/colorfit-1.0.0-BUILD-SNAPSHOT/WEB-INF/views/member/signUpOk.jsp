<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    

<c:choose>  
	<c:when test="${result == 0}">
		<script>
			alert("다시 정보를 입력해주세요.");
			history.back();
		</script>  
	</c:when>
	<c:when test="${result == 1}">
		<script>
			alert("가입이 완료되었습니다. 환영합니다 :)");
			location.href="main";
		</script>
	</c:when>
</c:choose>