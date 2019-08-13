 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
 <link href="https://fonts.googleapis.com/css?family=Barlow+Condensed|Black+Han+Sans|Poiret+One&display=swap" rel="stylesheet">
</head>
<body>
<!-- 	아이디:<INPUT TYPE=TEXT NAME='ID' PLACEHOLDER='아이디'><BR>
	비밀번호:<INPUT TYPE=PASSWORD NAME='PASSWORD' PLACEHOLDER='비밀번호'><BR>
	<BUTTON TYPE="BUTTON">로그인</BUTTON> -->
	<div id="login-container" style="display: none">
			<div class="wrap-login100"  >
				<form class="login100-form validate-form" action="Login" method="POST">
               		<table>
               			<tr><td>
			               <div id="logo-user" class="login100-form-logo">
			                
			               </div>
              			</td></tr>
					<tr><td>
			               <span class="login100-form-title">
			                  User
			               </span>
               		</td></tr>	<tr><td>
		               <div id="logo-id" class="wrap-input100 validate-input" >
		                  <input class="input100" type="text" name="username" placeholder="User Id">
		                  
		                  <span class="focus-input100" ></span> 
		               </div>
					</td></tr>	<tr><td>
					
		               <div id="logo-password" class="wrap-input100 validate-input" >
		                  <input class="input100" type="password" name="password" placeholder="User Password">
		                  <span class="focus-input100" ></span> 
		               </div>
					</td></tr>	<tr><td>

            
               <div class="container-login100-form-btn">
                  <button class="login100-form-btn" onclick="location.href='Login'">
                     Login
                  </button>
               </div>
			</td></tr></table>
            </form>
			</div>

		</div>
</body>
</html>