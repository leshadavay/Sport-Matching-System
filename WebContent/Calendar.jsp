<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@page import="BoarderModel.BoarderDao"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/calendar.css">
<script type="text/javascript" src="js/makeCalendar.js"></script>
<script src="js/jquery.min.js"></script>
</head>
<body>
 <div>
 <%String usernameInSession= (String)session.getAttribute("ID"); %>
 <%BoarderDao dao = new BoarderDao(); %>
    <script>
        username=localStorage.getItem("uname");
        usernameInSession='<%=usernameInSession%>';
        if(username){
           if(username!=usernameInSession)
              localStorage.setItem('isEvent','init');
        }
       var eventStatus=localStorage.getItem("isEvent");     
       if(eventStatus=="failtosave"){
          alert("Error saving new event to database");
       }
       else if(eventStatus=="failtoremove"){
          alert("Error removing event from database");
       }
       else if(eventStatus!="no"||eventStatus=="dberror"){
            <%
           out.println("console.log('connecting database'); ");

           
          ArrayList<String> data = dao.fetchAllEvents(usernameInSession);
          
          if(data==null){
             out.println("alert('error on connecting database'); ");
             out.println("localStorage.setItem('isEvent','dberror');");
          }
          else{
           
          String dates="";
          String events="";
          
          if(data.size()!=0) {
             for(int i=0;i<data.size();i+=2) {
                dates+=data.get(i)+"/";   
                events+=data.get(i+1)+"/";
             }
          }
           
          out.println("localStorage.setItem('uname','"+usernameInSession+"');localStorage.setItem('isEvent','init');localStorage.setItem('eventDate','"+dates+"');localStorage.setItem('eventDetails','"+events+"');");
          }
        %>
       }
       
        initDate();
        
    </script>
   </div>
</body>
</html>