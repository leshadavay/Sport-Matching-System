<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.LOGIN == 'SUCCESS' }">
			<script>location.href='Main.jsp';</script>
		</c:when>
		<c:otherwise>
			<script>alert('로그인에 실패했습니다.');</script>
			<script>location.href='Main.jsp'</script>
		</c:otherwise>
	</c:choose>
</body>
</html>