function afrekenenInit() {
    document.getElementById("annuleren").addEventListener("click", function () {
        window.location.href = "/";
    });

    document.getElementById("akkoord").addEventListener("click", function () {
        akkoord();
    });

    displayGegevens();
}

function akkoord() {
    let mand = JSON.parse(sessionStorage.getItem("bestellingregel"));
    let regels = mand["product"];

    var i;
    for(i = 0; i < regels.length; i++) {
        delete regels[i]["aanbiedingprijs"];
        delete regels[i]["naam"];
        delete regels[i]["prijs"];

        regels[i]["product_id"] = regels[i]["id"];
        delete regels[i]["id"];
    }
    console.log(regels);

}

function displayGegevens() {
    $.ajax({
        'url': 'http://localhost:8081/api/account/1',
        'type': 'GET',
        'success' : function(data){
            let klant = data["klant"];
            document.getElementById("naam").innerHTML = klant["naam"];
            document.getElementById("email").innerHTML = klant["email"];

            let adres = klant["adres"];
            document.getElementById("straat").innerHTML = adres["straat"];
            document.getElementById("postcode").innerHTML = adres["postcode"];
            document.getElementById("plaats").innerHTML = adres["plaats"];
        }
    });
}