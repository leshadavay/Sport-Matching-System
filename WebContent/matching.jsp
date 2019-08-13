<%@page contentType="text/html; charset=UTF-8" errorPage="DBError.jsp"%>
<%@ page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="BoarderModel.BoarderVo"%>

<%--     <%@include file="db.jsp" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/layout.css">
<link rel="stylesheet" type="text/css" href="css/modal.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>



</head>
<body>
	<%
		String option = request.getParameter("option");
		String sType = request.getParameter("sType");
		String sName = request.getParameter("sName");

		ArrayList<BoarderVo> vo = (ArrayList<BoarderVo>) request.getAttribute("vo");
	%>
	<div class="row">
		<div class="col-12">
			<%@include file="header.jsp"%>
		</div>
	</div>

	<div id="middle-menu-bar">
		<button id="button-create-category" class="btn-options"
			onclick="showCreatESPORTegoryModal()"
			style="position: absolute; left: 25%;">create</button>
		<ul style="display: inline-block">
			<li><button class="btn-options" id="ALL"
					onclick="sendOptionRequestParameter(this);">ALL</button></li>
			<li><button class="btn-options" id="TEAM"
					onclick="sendOptionRequestParameter(this);">팀</button></li>
			<li><button class="btn-options" id="SINGLE"
					onclick="sendOptionRequestParameter(this);">개인</button></li>

		</ul>
		<!--    <button class="btn-options" style="position: absolute;right: 22%;top: 18px;">my page </button> -->
	</div>
	<div id="left-menu-bar">

		<label class="left-category-title">Sports Category</label>
		<ul>

			<li class="left-ul-li"><label id="ALL"
				onclick="sendSPORTegoryRequestParameter(this);"> <img
					class="left-logo" src="resource/logo_all.png">
					<button class="left-bar-btn-category">ALL</button></label></li>
			<li class="left-ul-li"><label id="SOCCER"
				onclick="sendSPORTegoryRequestParameter(this);"> <img
					class="left-logo" src="resource/logo_soccer.png">
					<button class="left-bar-btn-category">Soccer</button></label></li>
			<li class="left-ul-li"><label id="BASEBALL"
				onclick="sendSPORTegoryRequestParameter(this);"> <img
					class="left-logo" src="resource/logo_baseball2.png">
					<button class="left-bar-btn-category">Baseball</button></label></li>
			<li class="left-ul-li"><label id="PINGPONG"
				onclick="sendSPORTegoryRequestParameter(this);"> <img
					class="left-logo" src="resource/logo_pingpong2.png">
					<button class="left-bar-btn-category">Ping pong</button></label></li>
			<li class="left-ul-li"><label id="BASKETBALL"
				onclick="sendSPORTegoryRequestParameter(this);"> <img
					class="left-logo" src="resource/logo_basketball.png">
					<button class="left-bar-btn-category">Basketball</button></label></li>
			<li class="left-ul-li"><label id="TENNIS"
				onclick="sendSPORTegoryRequestParameter(this);"> <img
					class="left-logo" src="resource/logo_tennis.png">
					<button class="left-bar-btn-category">Tennis</button></label></li>
			<li class="left-ul-li"><label id="ETC"
				onclick="sendSPORTegoryRequestParameter(this);"> <img
					class="left-logo" src="resource/logo_etc.png">
					<button class="left-bar-btn-category">...</button></label></li>
		</ul>

	</div>
	<div id="right-menu-bar">

		<label class="right-category-title">E-Sports Category</label>
		<ul>

			<li class="right-ul-li"><label id="ALL"
				onclick="sendESPORTegoryRequestParameter(this);">
					<button class="right-bar-btn-category">ALL</button> <img
					class="right-logo" src="resource/logo_all.png">
			</label></li>
			<li class="right-ul-li"><label id="BATTLEGROUND"
				onclick="sendESPORTegoryRequestParameter(this);">
					<button class="right-bar-btn-category">BattleGround</button> <img
					class="right-logo" src="resource/logo_battleground.png"></li>
			<li class="right-ul-li"><label id="OVERWATCH"
				onclick="sendESPORTegoryRequestParameter(this);">
					<button class="right-bar-btn-category">Overwatch</button> <img
					class="right-logo" src="resource/logo_overwatch.png"></li>
			<li class="right-ul-li"><label id="LOL"
				onclick="sendESPORTegoryRequestParameter(this);">
					<button class="right-bar-btn-category">LOL</button> <img
					class="right-logo" src="resource/logo_lol.png"></li>
			<li class="right-ul-li"><label id="ROCKET"
				onclick="sendESPORTegoryRequestParameter(this);">
					<button class="right-bar-btn-category">Rocket</button> <img
					class="right-logo" src="resource/logo_rocket.png"></li>
			<li class="right-ul-li"><label id="ETC"
				onclick="sendESPORTegoryRequestParameter(this);">
					<button class="right-bar-btn-category">...</button> <img
					class="right-logo" src="resource/logo_etc.png"></li>
		</ul>

	</div>

	<div id="main-page">

		<div id="categories">

			<!-- 게시판 item 출력 여기에  -->


			<table class="table table-hover table-dark" id="board-table">
				<thead>
					<tr>
						<th scope="col">번호</th>
						<th scope="col">글쓴이</th>
						<th scope="col">제목</th>
						<th scope="col">종목</th>
						<th scope="col">Sport/E-Sport</th>
						<th scope="col">개인/팀</th>
						<th scope="col">날짜</th>
						<th scope="col">현재 인원</th>
						<th scope="col">최대인원</th>
						<th scope="col">조회</th>
					</tr>
				</thead>
				<tbody id="board-table-body">

				</tbody>
			</table>
			<script>
			var delaytime=0.1;
   		var dataRow=[];
   		var dataAll=[];
    	function fetchDataFromDB(boardid,writer,title,gametype,sportstype,teamtype,uploadDate,nowPeo,maxPeo,views,content){
    		dataRow=[];
    		dataRow.push(boardid,writer,title,gametype,sportstype,teamtype,uploadDate,nowPeo,maxPeo,views,content);
    		dataAll.push(dataRow);
    		//console.log(dataRow);
    		printDataFromDB(dataRow);
    	}
    	
    	function printDataFromDB(dataRow){
    		//var main=document.getElementById("main-page");
    		var table=document.getElementById("board-table-body");
    		
    		var tr=createRow(dataRow);
    	 
    		table.appendChild(tr);
    		 
    		
    	}
   	   function createRow(row){
   			
              var tr=document.createElement("tr");
              tr.setAttribute("onclick","showDescriptionModal(this)");
              tr.setAttribute("class","board-table-row");
              for(var i=0;i<row.length;i++){
                  var td=document.createElement("td");
                   
                  
                  td.innerHTML=row[i];
                  if(i==row.length-1)
                	  td.style.display="none";
                  tr.appendChild(td);
                  
              }
              
              tr.style.opacity="0";
         	 
           
              tr.style.animation = "table-row-animation 0.5s";
              tr.style.animationFillMode = "forwards";
              tr.style.animationDelay=""+(delaytime+=0.1)+"s";
           		
              
              return tr;
          }
   	   
    </script>
		</div>
	</div>
	<%
		for (int i = 0; i < vo.size(); i++) {
			String description = vo.get(i).getContent().replaceAll("\\r?\\n", " ");
			out.println("<script>fetchDataFromDB('" + vo.get(i).getBoardid() + "','" + vo.get(i).getWriter() + "','"
					+ vo.get(i).getTitle() + "','" + vo.get(i).getGametype() + "','" + vo.get(i).getSportstype()
					+ "','" + vo.get(i).getTeamtype() + "','" + vo.get(i).getUploaddate() + "','"
					+ vo.get(i).getNowpeo() + "','" + vo.get(i).getMaxpeo() + "','" + vo.get(i).getViews() + "','"
					+ description + "');</script>");
		}
	%>
	<div id="create-category-modal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<div class="modal-header">
				<span class="close">&times;</span>
				<h2>Create new category</h2>
			</div>
			<form method=post action="/TeamProject5/create">
				<div class="modal-body">

					<table>
						<caption>Input information below</caption>
						<tr>
							<td>Title name:</td>
							<td><input id=title name=title type="text" class="cat-input"></td>
						</tr>
						<tr>
							<td>Sport/E-Sport:</td>
							<td><select id="sport-option" name=sport-type
								onchange="showSportType(this.value);" class="cat-input"><option>Sport</option>
									<option>E-Sport</option></select></td>
						</tr>
						<tr>
							<td>Game type:</td>
							<td><select id="sport-type" name=game-type class="cat-input"></select></td>
						</tr>
						<tr>
							<td>Single/Team:</td>
							<td><select id="singleOrTeam" name=singleOrTeam
								class="cat-input"><option>Single</option>
									<option>Team</option></select></td>
						</tr>
						<tr>
							<td>User limit:</td>
							<td><input id=userLimit name=userLimit class="cat-input"
								type="number"></td>
						</tr>
						<tr>
							<td>Description:</td>
							<td><textarea id=description name=description rows="5"
									cols="30" class="cat-input"></textarea></td>
						</tr>
					</table>


				</div>
				<div class="modal-footer">
					<input type=submit value="SAVE">
				</div>
			</form>
		</div>

	</div>
	<div id="show-description-modal" class="modal">

		<!-- Modal content -->
		<div class="modal-content">
			<div class="modal-header">
				<span class="close">&times;</span>
				<h2>Description</h2>
			</div>
			<form action="PartIn">
				<div class="modal-body"></div>
				<div class="modal-footer">
					<button id="send-request-button"></button>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="js/animations.js"></script>
	<script type="text/javascript" src="js/colors.js"></script>
	<script type="text/javascript" src="js/modal.js"></script>
	<script type="text/javascript" src="js/post.js"></script>

	<script>
<%-- sessionStorage.setItem("option","<%=option%>");
sessionStorage.setItem("sType","<%=sType%>");
sessionStorage.setItem("sName","<%=sName%>"); --%>
		init("<%=option%>","<%=sType%>","<%=sName%>");
	</script>
</body>
</html>