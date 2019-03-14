function hideLogin(){
    document.querySelector(".loginContainer").setAttribute("class", "loginContainer hidden");
    document.querySelector(".createContainer").setAttribute("class", "createContainer show");
}

function hideCreate() {
    document.querySelector(".loginContainer").setAttribute("class", "loginContainer show");
    document.querySelector(".createContainer").setAttribute("class", "createContainer hidden");
}