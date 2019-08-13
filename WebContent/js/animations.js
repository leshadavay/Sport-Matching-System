//animations

    var main=document.getElementById("main-page");
    var leftBar=document.getElementById("left-menu-bar");
    var rightBar=document.getElementById("right-menu-bar");
    //var gradientColors=["#0f2027","#203a43","#2c5364","#c31432", "#240b36","#654ea3","#eaafc8","#ad5389", "#3c1053","#333333","#3e5151", "#decba4"];
    
    var option;
    var sportName;
    var sportType;
    leftBar.onmouseover=expandLeftBar;
    leftBar.onmouseout=reduceLeftBar;
    rightBar.onmouseover=expandRightBar;
    rightBar.onmouseout=reduceRightBar;

     function expandLeftBar() {
         leftBar.style.width="250px";

    }
    function reduceLeftBar(){
         leftBar.style.width="80px";
    }
    function expandRightBar() {
        rightBar.style.width="300px";
    }
    function reduceRightBar(){
        rightBar.style.width="80px";
    }
  function getBackgroundImage(sportType,gameType){
    	var image; 
    	switch(gameType){
         case "ALL": {
        	 if(sportType=="SPORT")image="url('resource/wall_sport.jpg')"; 
        	 else if(sportType=="ESPORT") image="url('resource/wall_esport_blur.jpg')";
        	 else image="url('resource/wall_all.jpg')";
         }break;
         case "SOCCER": image="url('resource/wall_soccer.jpg')"; break;
         case "BASEBALL": image="url('resource/wall_baseball.jpg')"; break;
         case "PINGPONG": image="url('resource/wall_pingpong2.jpg')"; break;
         case "BASKETBALL": image="url('resource/wall_basketball.jpg')"; break;
      
         case "TENNIS": image="url('resource/wall_tennis2.jpg')"; break;
         case "BATTLEGROUND": image="url('resource/wall_battleground.jpg')"; break;
         case "OVERWATCH": image="url('resource/wall_overwatch.jpg')"; break;
         case "LOL": image="url('resource/wall_lol.jpg')"; break;
         case "ROCKET": image="url('resource/wall_rocket.jpg')"; break;
         
         	default:     image= getDarkGradientColor();
         	break;
         }
    	console.log(image);
    	return image;
    }
    function init(opt,sType,sName) {
        //alert(opt+"\n"+sType+"\n"+sName);
/*        sessionStorage.getItem("option");
        sessionStorage.getItem("sType");
        sessionStorage.getItem("sName");*/
        option = opt;
        sportType=sType;
        sportName=sName;

        document.body.style.backgroundImage= getBackgroundImage(sType,sName);
        document.body.style.backgroundSize="cover";
        document.body.style.backgroundRepeat="no-repeat";
        //document.body.style.background= "linear-gradient(to right, #0f0c29, #302b63, #24243e)";
        var dataBox=document.getElementsByClassName("cat-box");
        //var type=dataBox[0].firstChild.childNodes[4].innerHTML;
        for(var i=0;i<dataBox.length;i++){
            dataBox[i].firstChild.style.background=getDarkGradientColor();
        }
        
        var middleLi = document.getElementsByClassName("btn-options");
        var leftLi=document.getElementsByClassName("left-logo");
        var rightLi=document.getElementsByClassName("right-logo");
        
        for (var i = 0; i < middleLi.length; i++) {
            var id = middleLi[i].getAttribute("id");

            if (id == option) {
                middleLi[i].style.backgroundColor = "#fff";
                middleLi[i].style.color = "#1b1b1b";
                break;
            }
        }

        if(sportType=="SPORT") {
            for (var i = 0; i < leftLi.length; i++) {
                var parent = leftLi[i].parentNode;
                var id = parent.getAttribute("id");

                if (id == sportName) {
                    leftLi[i].style.transform = "scale(1.3)";
                    //leftLi[i].style.border="1px solid #eee32d";
                    leftLi[i].style.borderRadius = "50px";
                    leftLi[i].style.boxShadow = "0 0 3px 3px #eee32d";

                    break;
                }

            }
        }
        else if(sportType=="ESPORT") {
            for (var i = 0; i < rightLi.length; i++) {
                var parent = rightLi[i].parentNode;
                var id = parent.getAttribute("id");
                //console.log(id);
                if (id == sportName) {
                    rightLi[i].style.transform = "scale(1.3)";
                    //rightLi[i].style.border="1px solid #eee32d";
                    rightLi[i].style.borderRadius = "50px";
                    rightLi[i].style.boxShadow = "0 0 3px 3px #eee32d";
                    break;
                }

            }
        }
        else if(sportType=="ALL"){
            for (var i = 0; i < leftLi.length; i++) {
                var parent = leftLi[i].parentNode;
                var id = parent.getAttribute("id");

                if (id == sportName) {
                    leftLi[i].style.transform = "scale(1.3)";
                    //leftLi[i].style.border="1px solid #eee32d";
                    leftLi[i].style.borderRadius = "50px";
                    leftLi[i].style.boxShadow = "0 0 3px 3px #eee32d";

                    break;
                }

            }
            for (var i = 0; i < rightLi.length; i++) {
                var parent = rightLi[i].parentNode;
                var id = parent.getAttribute("id");
                //console.log(id);
                if (id == sportName) {
                    rightLi[i].style.transform = "scale(1.3)";
                    //rightLi[i].style.border="1px solid #eee32d";
                    rightLi[i].style.borderRadius = "50px";
                    rightLi[i].style.boxShadow = "0 0 3px 3px #eee32d";
                    break;
                }

            }

        }
    }

    function sendOptionRequestParameter(node) {

        option=node.getAttribute("id");
        //location.replace("matching.php?option=" + option + "&sType=" + sportType + "&sName=" + sportName);
        location.replace("showboard?option="+option+"&sType="+sportType+"&sName="+sportName);
    }
    function sendSPORTegoryRequestParameter(node) {
        if (sessionStorage.getItem("slbl")) {
            sportName = node.getAttribute("id");

            if (sportName == "ALL") {

                if (sessionStorage.getItem("ESPORT") != null) {
                    if (sportType == "ALL") {
                        sportType = "SPORT";
                        sessionStorage.removeItem("SPORT");
                    }
                    else {
                        sportType = "ALL";
                        sessionStorage.setItem("SPORT", "ON");
                    }

                }
                else {
                    sportType = "SPORT";
                    sessionStorage.setItem("SPORT", "ON");
                }
            }
            else {
                sportType = "SPORT";
                sessionStorage.removeItem("SPORT");
                sessionStorage.removeItem("ESPORT");
            }
            sessionStorage.removeItem("slbl");
            //location.replace("matching.php?option=" + option + "&sType=" + sportType + "&sName=" + sportName);
            location.replace("showboard?option="+option+"&sType="+sportType+"&sName="+sportName);
        }
        else
            sessionStorage.setItem("slbl", "1");
    }
    function sendESPORTegoryRequestParameter(node) {
        if (sessionStorage.getItem("elbl")) {

            sportName = node.getAttribute("id");
            if (sportName == "ALL") {
                if (sessionStorage.getItem("SPORT") != null) {
                    if (sportType == "ALL") {
                        sportType = "ESPORT";
                        sessionStorage.removeItem("ESPORT");
                    }
                    else {
                        sportType = "ALL";
                        sessionStorage.setItem("ESPORT", "ON");
                    }

                }
                else {
                    sportType = "ESPORT";
                    sessionStorage.setItem("ESPORT", "ON");
                }
            }
            else {
                sportType = "ESPORT";
                sessionStorage.removeItem("ESPORT");
                sessionStorage.removeItem("SPORT");
            }
            sessionStorage.removeItem("elbl");
            //location.replace("matching.php?option=" + option + "&sType=" + sportType + "&sName=" + sportName);
            location.replace("showboard?option="+option+"&sType="+sportType+"&sName="+sportName);
           
        }
        else{
            sessionStorage.setItem("elbl", "1");
        }

    }
    function sendRequestForJoin(){
        alert("request ok");
    }

    //when click create button
    showSportType("Sport");
    function showSportType(type) {
        var sportNode=document.getElementById("sport-type");

        switch (type) {
            case "Sport":{
                while(sportNode.hasChildNodes()){
                    sportNode.removeChild(sportNode.lastChild);
                }
                sportNode.appendChild(createElement("option","SOCCER"));
                sportNode.appendChild(createElement("option","BASEBALL"));
                sportNode.appendChild(createElement("option","PINGPONG"));
                sportNode.appendChild(createElement("option","BASKETBALL"));
                sportNode.appendChild(createElement("option","TENNIS"));

            }break;
            case "E-Sport":{
                while(sportNode.hasChildNodes()){
                    sportNode.removeChild(sportNode.lastChild);
                }
                sportNode.appendChild(createElement("option","BATTLEGROUND"));
                sportNode.appendChild(createElement("option","OVERWATCH"));
                sportNode.appendChild(createElement("option","LOL"));
                sportNode.appendChild(createElement("option","ROCKET"));
            }break;
        }

    }
    function createElement(elementName,elementValue){
        var node = document.createElement(elementName);
        if(elementValue!=""){
            node.innerHTML = elementValue;
        }
        return node;
    }
