<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.RESULT == 'TOO_MANY'}">
			<script>
				alert("인원이 너무 많습니다.");
				location.href = "MyPage";
			</script>
		</c:when>
		<c:when test="${param.RESULT == 'NO_PEO' }">
			<script>
				alert("선택한 인원이 없습니다.");
				location.href = "MyPage";
			</script>
		</c:when>
		<c:otherwise>

		</c:otherwise>
	</c:choose>
</body>
</html>