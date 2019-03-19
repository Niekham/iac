function check(input) {
    if (input.value !== document.getElementById('pass').value) {
        document.querySelector(".ongelijk").style.display="inline";
    } else {
        document.querySelector(".ongelijk").style.display="none";
    }
}


//verbergt inlog scherm, laat create account zien
function hideLogin(){
    document.querySelector(".loginContainer").setAttribute("class", "loginContainer hidden");
    document.querySelector(".createContainer").setAttribute("class", "createContainer show");
}

//verbergt create account scherm, laat login scherm zien
function hideCreate() {
    document.querySelector(".loginContainer").setAttribute("class", "loginContainer show");
    document.querySelector(".createContainer").setAttribute("class", "createContainer hidden");
}

function logout() {
    sessionStorage.removeItem("UserID");
    document.querySelector(".login").setAttribute("class", "login show");
    document.querySelector(".loguit").setAttribute("class", "login hidden");
}


function checkLogin() {
    if(sessionStorage.getItem("UserID") == null){
        document.querySelector(".login").setAttribute("class", "login show");
        document.querySelector(".loguit").setAttribute("class", "loguit hidden");
    }else {
        document.querySelector(".login").setAttribute("class", "login hidden");
        document.querySelector(".loguit").setAttribute("class", "loguit show");
    }
}