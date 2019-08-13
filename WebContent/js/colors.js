var gradient=[];
    gradient.push("linear-gradient(120deg, #fccb90 0%, #d57eeb 100%)");
    gradient.push("linear-gradient(45deg, #ff9a9e 0%, #fad0c4 99%, #fad0c4 100%)");
    gradient.push("linear-gradient(120deg, #f6d365 0%, #fda085 100%)");
    gradient.push("linear-gradient(90deg, #fbc2eb 0%, #a6c1ee 100%)");
    gradient.push("linear-gradient(120deg, #a1c4fd 0%, #c2e9fb 100%)");
    gradient.push("linear-gradient(120deg, #d4fc79 0%, #96e6a1 100%)");
    gradient.push("linear-gradient(120deg, #84fab0 0%, #8fd3f4 100%)");
    gradient.push("linear-gradient(120deg, #fccb90 0%, #d57eeb 100%)");
    gradient.push("linear-gradient(90deg, #5ee7df 0%, #b490ca 100%)");
    gradient.push("linear-gradient(15deg, #13547a 0%, #80d0c7 100%)");
    gradient.push("linear-gradient(90deg, #ff0844 0%, #ffb199 100%)");
    gradient.push("linear-gradient(90deg, #b3ffab 0%, #12fff7 100%)");
    gradient.push("linear-gradient(-225deg, #A8BFFF 0%, #884D80 100%)");

    var darkGradient=[];
    darkGradient.push("linear-gradient(140deg, #3c3b3f, #605c3c,#3c3b3f)");
    darkGradient.push("linear-gradient(140deg, #0f2027, #203a43, #2c5364)");
    darkGradient.push("linear-gradient(120deg, #000000, #434343)");
    darkGradient.push("linear-gradient(140deg, #1e130c, #9a8478)");
    darkGradient.push("linear-gradient(140deg, #870000, #190a05)");
    darkGradient.push("linear-gradient(140deg, #16222a, #3a6073)");
    darkGradient.push("linear-gradient(140deg, #232526, #414345)");
    darkGradient.push("linear-gradient(140deg, #093028, #237a57)");

    function getGradientColor(){
        var rand=Math.floor(Math.random()*gradient.length);
        //console.log(rand,gradient[rand]);
        return gradient[rand];
    }
    function getDarkGradientColor(){

        var rand=Math.floor(Math.random()*darkGradient.length);
        //console.log(rand,gradient[rand]);
        return darkGradient[rand];
    }