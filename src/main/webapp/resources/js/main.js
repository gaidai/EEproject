var index = 1;
function nextstep() {
    document.getElementById("step"+index).className = "step done";
    $("#block"+index).hide();
    ++ index ; 
      $("#block"+index).show();
    document.getElementById("step"+index).className = "step active";

    if(index ==1){ $("#back-btn").hide();} else{
    	$("#back-btn").show();
    }


     if(index ==4){
    	$("#next-btn").hide();
    };

};
function backstep() {
    document.getElementById("step"+index).className = "step";
     $("#block"+index).hide();
    -- index ; 
     $("#block"+index).show();
    document.getElementById("step"+index).className = "step active";
   $("#next-btn").show();
    if(index ==1){ $("#back-btn").hide();} else{
    	$("#back-btn").show();
    }
};
