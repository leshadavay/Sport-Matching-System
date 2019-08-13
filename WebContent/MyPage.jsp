<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width = device-width"   initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/calendar.css">
<script type="text/javascript" src="js/makeCalendar.js"></script>

<title>마이 페이지 테스트</title>
</head>
<body style="background-color: black">
	<!-- 상단 메뉴바 -->
	<jsp:include page="header.jsp" />

	<div class="container" style="margin-bottom: 500px;">
		<div class="row">
			<!-- 타임테이블 오는 자리 -->
			<div class="col-6">
				<jsp:include page="Calendar.jsp" />
			</div>

			<div class="col-6">
				<!-- 쪽지 오는 자리 -->
				<div style="overflow: scroll; height: 250px">
					<c:choose>
						<c:when test="${MESSAGE.listSize <1}">
							<div class="list-group" style="background-color: red">
								<a href="#" class="list-group-item list-group-item-action">쪽지가
									없습니다.</a>
							</div>
						</c:when>
						<c:otherwise>
							<c:forEach var="cnt" begin="0" end="${MESSAGE.listSize -1}">
								<div class="list-group" style="background-color: red">
									<a href="#" class="list-group-item list-group-item-action">${MESSAGE.messageList[cnt] }</a>
								</div>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>

				<!-- 방 목록 오는 자리. -->
				<div class="card text-white bg-secondary">
					<c:choose>
						<c:when test="${USER_LIST.listSize<1 }">
                     참가중인 방이 없습니다.
                  </c:when>
						<c:otherwise>
							<div class="card-header">방 번호 : ${USER_LIST.boardId}</div>
							<div class="card-body">
								<form class="form-group" action="CheckMatch">
									<input type="hidden" name="boardCount"
										value="${USER_LIST.boardId}">
									<c:choose>
										<c:when test="${USER_LIST.isWriter == 1 }">
											<div>
												<input type="checkbox" name="user"
													value="${USER_LIST.userList[0] }" disabled="true" checked>
												${USER_LIST.userList[0] }<br>
												<c:forEach var="cnt" begin="1"
													end="${USER_LIST.listSize-1 }">
													<input type="checkbox" name="user"
														value="${USER_LIST.userList[cnt] }"> ${USER_LIST.userList[cnt] }&nbsp; &nbsp; ${USER_LIST.kakaoList[cnt]}<br>
												</c:forEach>
											</div>
										</c:when>
										<c:otherwise>
											<div>
												<c:forEach var="cnt" begin="0"
													end="${USER_LIST.listSize-1 }">
													<input type="checkbox" name="user"
														value="${USER_LIST.userList[cnt] }" disabled="true"> ${USER_LIST.userList[cnt] } &nbsp; &nbsp; ${USER_LIST.kakaoList[cnt]}<br>
												</c:forEach>
											</div>
										</c:otherwise>
									</c:choose>
									<br>
									<c:choose>

										<c:when test="${USER_LIST.isWriter == '1' }">
											<div style="text-align: center">
												<input type="hidden" name="state" value="1">
												<button class="btn btn-primary">결정</button>

											</div>
										</c:when>
										<c:when test="${USER_LIST.isWriter=='0' }">
											<div style="text-align: center">
												<input type="hidden" name="state" value="2">
												<button class="btn btn-primary">참가 취소</button>
											</div>
										</c:when>


									</c:choose>
								</form>

								<div class="card-footer">

									<ul class="pagination">
										<c:choose>
											<c:when
												test="${USER_LIST.pageSeq == '0' && USER_LIST.isLast==1}">
											</c:when>

											<c:when test="${USER_LIST.pageSeq == '0'}">
												<li class="page-item""><a class="page-link"
													href="MyPage?PAGE_SEQ=${USER_LIST.pageSeq+1 }">&raquo;</a>
												</li>

											</c:when>

											<c:when
												test="${USER_LIST.pageSeq > 0 && USER_LIST.isLast==0 }">
												<li class="page-item""><a class="page-link"
													href="MyPage?PAGE_SEQ=${USER_LIST.pageSeq-1 }">&laquo;</a>

												</li>
												<li class="page-item""><a class="page-link"
													href="MyPage?PAGE_SEQ=${USER_LIST.pageSeq+1 }">&raquo;</a>
												</li>
											</c:when>

											<c:when test="${USER_LIST.isLast ==1 && USER_LIST.pageSeq>0}">
												<li class="page-item""><a class="page-link"
													href="MyPage?PAGE_SEQ=${USER_LIST.pageSeq-1 }">&laquo;</a>
												</li>
											</c:when>
										</c:choose>
									</ul>

								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
		<div class="row" style="height: 100px;"></div>
	</div>
	<jsp:include page="footer.jsp" />
	<script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>