function klantenOphalen() {
    var uri = "http://localhost:8081/api/account/alleKlanten";
    fetch(uri)
        .then(response => response.json())
        .then(function(myJson){
        for(const klant of myJson){
                var naam = klant.naam;
                var email = klant.email
                var adres = klant.adres;
                var straat = adres.straat;
                var postcode = adres.postcode;
                var plaats = adres.plaats;


                var table = document.querySelector("#klanten-tabel");

                var newRow = table.insertRow(-1);
                // create a new cell
                var naamcell = newRow.insertCell(0);
                var emailcell = newRow.insertCell(1);
                var straatcell = newRow.insertCell(2);
                var postcodecell = newRow.insertCell(3);
                var plaatscell = newRow.insertCell(4);

                // add value to the cell
                naamcell.innerHTML = naam;
                emailcell.innerHTML = email;
                straatcell.innerHTML = straat;
                postcodecell.innerHTML = postcode;
                plaatscell.innerHTML = plaats;
        }
    })
}
