<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
<link rel="stylesheet" href="../css/bootstrap.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row" style="height: 50px;">
			<div class="col-sm-6" style="background-color: black">
				<!-- sm-sport -->
				<h2 style="color: white">
					Sport Matching <small class="text-muted">with Player</small>
				</h2>
			</div>
			<div class="col-sm-6" style="background-color: black; color: white;"
				align="right">
				<c:choose>
					<c:when test="${sessionScope.ID == null}">
					</c:when>
					<c:otherwise>
                  ${sessionScope.ID }님 반갑습니다.
               </c:otherwise>
				</c:choose>
				<!-- ì  ë ¨ ì  ë¦¼í   -->
				<button type="button" class="btn btn-warning"
					onclick="location.href='Main.jsp'">Home</button>


				<!--  <button type="button" class="btn btn-warning" onclick="location.href='matching.jsp'">Matching</button> -->


				<c:choose>
					<c:when test="${sessionScope.ID == null}">

						<button type="button" class="btn btn-danger"
							onclick="showHideLoginBox()">Login</button>
					</c:when>
					<c:otherwise>
						<a type="button" class="btn btn-warning" href="showboard">Matching</a>
						<button type="button" class="btn btn-warning"
							onclick="location.href='MyPage'">My Page</button>
						<button type="button" class="btn btn-danger"
							onclick="location.href='Logout'">LogOut</button>
					</c:otherwise>
				</c:choose>
				<jsp:include page="login.jsp" />
			</div>
		</div>
	</div>
	<script>
		function showHideLoginBox() {
			var loginBox = document.getElementById("login-container");
			if (loginBox.style.display != "none") {
				loginBox.style.display = "none";
			} else {
				loginBox.style.display = "block";
			}
		}
	</script>
</body>
</html>