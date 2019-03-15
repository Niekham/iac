function hideLogin(){
    document.querySelector(".loginContainer").setAttribute("class", "loginContainer hidden");
    document.querySelector(".createContainer").setAttribute("class", "createContainer show");
}

function hideCreate() {
    document.querySelector(".loginContainer").setAttribute("class", "loginContainer show");
    document.querySelector(".createContainer").setAttribute("class", "createContainer hidden");
}

function formToJson(tojson){
    let i;
    let json = {};
    for (i = 0; i < tojson.length; i++) {
        json[tojson[i].name] = tojson[i].value;
    }
    JSON.stringify(json);
    return json;
}

function createAccount(){
    let json = JSON.parse(JSON.stringify(jQuery('.createAccount').serializeArray()));
    let obj = formToJson(json);
    $.ajax({
        "url": "http://localhost:8081/api/account",
        'data': JSON.stringify(obj),
        'type': 'POST',
        'contentType': 'application/json'
    });
}

function login() {
    //Aan de button inloggen wordt een event listener toegevoegd.
    var button = document.getElementById("Login");
    button.addEventListener('click', function () {
        let json = JSON.parse(JSON.stringify(jQuery('.loginForm').serializeArray()));
        let obj = formToJson(json);
        $.ajax({
            'url': 'http://localhost:8081/api/account/login',
            'data': JSON.stringify(obj),
            'type': 'POST',
            'contentType': 'application/json',
            'success' : function(data,response){
                //sessionStorage.setItem("myJWT", JWT);
                sessionStorage.setItem("UserID", data);
                document.location.href = "Index.html";
            }
        });
    })

}

function logout() {
    sessionStorage.removeItem("UserID")
}