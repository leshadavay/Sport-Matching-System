<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.css">
<link href="https://fonts.googleapis.com/css?family=Barlow+Condensed|Black+Han+Sans|Poiret+One&display=swap" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet" type="text/css">
 
<script src="js/titleAnimation.js"></script>
<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet"> <!--font-family: 'Ubuntu', sans-serif;-->
<link href="https://fonts.googleapis.com/css?family=Orbitron" rel="stylesheet"> <!--font-family: 'Orbitron', sans-serif;-->
<link href="https://fonts.googleapis.com/css?family=Julius+Sans+One" rel="stylesheet"> <!--font-family: 'Julius Sans One', sans-serif;-->  <link href="https://fonts.googleapis.com/css?family=Short+Stack" rel="stylesheet"> <!--font-family: 'Short Stack', cursive;-->
<link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Barlow+Condensed|Black+Han+Sans|Poiret+One&display=swap" rel="stylesheet">

<style>
.mySlides {display:none;
overflow: hidden;
}
 
</style>
</head>


<body>

<div class="container-fluid" style="background-color:black;">

   <div class="row">
      <div class="col-12">
      <%@include file="header.jsp" %>
      </div>
   </div>
 
 <div id="animated_text">
	    <div id="animate-container"></div>
	</div> 
	<script>
		initText(); 
	</script>
      
    <div class="row" style="height:700px;  overflow: hidden">
      <div class="col-12" style="background-color:black;" align="center">
      	  <%@include file="slider.jsp" %>
      </div>
    </div>
   
     <% //원래 있던 코드 %>
   <!-- <div class="row" style="height:700px; overflow: hidden">
      <div class="col-12" style="background-color:black;" align="center">
         <p>
         <div class="w3-content w3-section" style="width:inherit; max-width:100%;" align="center">
           <img align="center" class="mySlides" src="resource/soccer.jpg"  >
           <img class="mySlides" src="resource/basket.jpg"  >
           <img class="mySlides" src="resource/ping.jpg"  >
           <img class="mySlides" src="resource/lol.jpg"  >
           <img class="mySlides" src="resource/battle.jpg"  >
           <img class="mySlides" src="resource/mm.jpg"  >
         </div>
         </p>
      </div>
   </div> -->
   
   
   
   <div class="row">
      <div class="col-12">
         <%@include file="footer.jsp" %>
      </div>
   </div>
</div>
<script>
/* var myIndex = 0;
carousel();

function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  myIndex++;
  if (myIndex > x.length) {
     myIndex = 1
     }    
  x[myIndex-1].style.display = "block";  
  setTimeout(carousel, 4000); // Change image every 2 seconds
} */
</script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</html>