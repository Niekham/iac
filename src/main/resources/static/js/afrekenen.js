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

    $.ajax({
       'url': 'http://localhost:8081/api/bestelling/add',
        'type': 'POST',
        'data': JSON.stringify(regels),
        'contentType': 'application/json',
        'success' : function(data) {
           if(data === 200) {
               window.location.href = "/success";
               emptyCart()
           } else if (data === 500) {
               window.location.href = "/login";
           }
        }
    });

}

function displayGegevens() {

    $.ajax({
        'url': 'http://localhost:8081/api/account/details',
        'type': 'GET',
        'success' : function(klant){
            document.getElementById("naam").innerHTML = klant["naam"];
            document.getElementById("email").innerHTML = klant["email"];

            let adres = klant["adres"];
            document.getElementById("straat").innerHTML = adres["straat"];
            document.getElementById("postcode").innerHTML = adres["postcode"];
            document.getElementById("plaats").innerHTML = adres["plaats"];
        },
        'error': function (xhr, ajaxOptions, thrownError) {
            if (xhr['status'] === 500) {
                window.location.href = "/login";
            }
        }
    });
}