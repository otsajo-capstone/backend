<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<c:choose>

	<c:when test="${mb_uid == 0 }">
		<script>
			alert("아이디가 없거나 비밀번호가 일치하지 않습니다.");
			history.back();
		</script>  
	</c:when>
	
	<c:otherwise>
		<script>
			alert("환영합니다.");
			location.href="${pageContext.request.contextPath}/member/main";
		</script>
	</c:otherwise>

</c:choose>