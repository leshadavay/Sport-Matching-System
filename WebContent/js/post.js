//send post
    function createNewCategory() {
        var input=document.getElementsByClassName("cat-input");
        var emptyFound=false;
        for(var i=0;i<input.length;i++){
            if(input[i].value==""){
                alert("Please, input empty fields");
                emptyFound=true;
                break;
            }
        }
        if(!emptyFound){
        	console.log(input[0].value+"|"+input[1].value+"|"+input[3].value+"|"+input[4].value+"|"+input[5].value);
        	alert("ok");
        	return;
        	

        }
    }