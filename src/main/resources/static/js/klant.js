function klantOphalen() {
    $.ajax({
        'url': 'api/account/details',
        'type': 'GET',
        'success' : function(klant){
            var naamrow = document.querySelector("#naam");
            var naamcell = naamrow.insertCell(-1);
            naamcell.innerHTML = klant["naam"];

            var emailrow = document.querySelector("#email");
            var emailcell = emailrow.insertCell(-1);
            emailcell.innerHTML = klant["email"];

            let adres = klant["adres"];

            var plaatsrow = document.querySelector("#plaats");
            var plaatscell = plaatsrow.insertCell(-1);
            plaatscell.innerHTML = adres["plaats"];

            var straatrow = document.querySelector("#straat");
            var straatcell = straatrow.insertCell(-1);
            straatcell.innerHTML = adres["straat"];

            var postcoderow = document.querySelector("#postcode");
            var postcodecell = postcoderow.insertCell(-1);
            postcodecell.innerHTML = adres["postcode"];

        },
        'error': function (xhr, ajaxOptions, thrownError) {
            if (xhr['status'] === 500) {
                window.location.href = "/login";
            }
        }
    });
}
