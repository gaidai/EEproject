var index = 1;
function nextstep() {
    if(index===3){
        var payment = document.getElementById('form1:payment').value;
        if( payment==="" ){
            alert('Choose your Payment method !');
        }else{
            stepto();        
        }
    }    
    if(index===2){
        var delivery = document.getElementById('form1:delivery').value;
        var adress = document.getElementById('form1:adress').value;
        if( delivery==="" || adress===""){
            alert('Choose your Delivery method and write your adress!');
        }else{
            stepto();        
        }
    }
    
    if(index===1){
        var firstname = document.getElementById('form1:firstname').value;
        var lastname = document.getElementById('form1:lastname').value;
        var phone = document.getElementById('form1:phone').value;
        if( firstname.length < 2 ||firstname.length > 15|| lastname.length < 2 ||lastname.length > 15 
            || phone.length !== 10  ){
                 alert('Write your contact information!\n\ Firstname and Lastname must contain from 3 to 15 symbols \n\ Phone - 10 symbols ');
        }else{
            stepto();        
        }
    }
};
function stepto() {
      document.getElementById("step"+index).className = "step done";
    $("#block"+index).hide();
    ++ index ; 
      $("#block"+index).show();
    document.getElementById("step"+index).className = "step active";

    if(index ===1){ $("#back-btn").hide();} else{
    	$("#back-btn").show();
    }


     if(index ===4){
    	$("#next-btn").hide();
    };
}

function backstep() {
    document.getElementById("step"+index).className = "step";
     $("#block"+index).hide();
    -- index ; 
     $("#block"+index).show();
    document.getElementById("step"+index).className = "step active";
   $("#next-btn").show();
    if(index ===1){ $("#back-btn").hide();} else{
    	$("#back-btn").show();
    }
};