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

//Maakt form informatie om naar json formaat
function formToJson(tojson){
    let i;
    let json = {};
    for (i = 0; i < tojson.length; i++) {
        json[tojson[i].name] = tojson[i].value;
    }
    JSON.stringify(json);
    return json;
}

//voor het aanamaken van een account
function createAccount(){
    let json = JSON.parse(JSON.stringify(jQuery('.createAccount').serializeArray()));
    let obj = formToJson(json);
    $.ajax({
        "url": "http://localhost:8081/api/account",
        "data": JSON.stringify(obj),
        "type": "POST",
        "contentType": "application/json",
        "success": function (response) {
            console.log("succes" + response);
            alert("Account is aangemaakt");
            hideCreate();
        },
        "error": function(response) {
            console.log("Er is iets fout gegaan"+response);
        }
    });
}

//voor het inloggen, zet accountid in de sessionstorage
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
            'success' : function(data){
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