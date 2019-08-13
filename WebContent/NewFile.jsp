<%@page contentType="text/html; charset=UTF-8" errorPage="DBError.jsp" %>
<%@page import="java.sql.*"%>


<h1><%=request.getAttribute("title") %></h1>
<h1><%=request.getAttribute("soption") %></h1>
<h1><%=request.getAttribute("stype") %></h1>
<h1><%=request.getAttribute("singleOrTeam") %></h1>
<h1><%=request.getAttribute("userLimit") %></h1>
<h1><%=request.getAttribute("description") %></h1>

<%
/*
 	String title=request.getAttribute("title").toString();
	String soption= request.getAttribute("sport-option").toString();
	String stype= request.getAttribute("sport-type").toString();
	String singleOrTeam= request.getAttribute("singleOrTeam").toString();
	String userLimit= request.getAttribute("userLimit").toString();
	String description= request.getAttribute("description").toString();
 	
	
	Connection conn = null;
    Statement stmt = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sportmatching?serverTimezone=UTC", "root", "student");
        if (conn == null)
            throw new Exception("데이터베이스에 연결할 수 없습니다.");
        stmt = conn.createStatement();
        String command = String.format("insert into board " +
                  "(id,username,title,stype,sportoresport,singleorteam,status,currentusers,maxusers,viewcount,description) values ('%s', '%s', '%s','%s', '%s', '%s','%s', '%s', '%s','%s', '%s');",
                  "1000", "User1", title,stype,soption,singleOrTeam,"가능","0",userLimit,"0",description);
        int rowNum = stmt.executeUpdate(command);
        if (rowNum < 1)
            throw new Exception("데이터를 DB에 입력할 수 없습니다.");
    }
    finally {
        try { 
            stmt.close();
        } 
        catch (Exception ignored) {
        }
        try { 
            conn.close();
        } 
        catch (Exception ignored) {
        }
    }
    */
%>
 
 