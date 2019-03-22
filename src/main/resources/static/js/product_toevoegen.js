function formToJson(tojson){
    let i;
    let json = {};
    for (i = 0; i < tojson.length; i++) {
        json[tojson[i].name] = tojson[i].value;
    }
    JSON.stringify(json);
    return json;
}

function toevoegen(){
    let json = JSON.parse(JSON.stringify(jQuery('.productForm').serializeArray()));
    let obj = formToJson(json);
    obj["afbeelding"] = document.getElementById("naam").value;
    $.ajax({
        'url': 'http://localhost:8081/api/products/add',
        'data': JSON.stringify(obj),
        'type': 'POST',
        'contentType': 'application/json',
        'success' : function(){
            alert("Product is toegevoegd")
            sessionStorage.setItem("productnaam", document.getElementById("naam1").value);
            sessionStorage.setItem("productprijs", document.getElementById("prijs").value);
            sessionStorage.setItem("productafbeelding", document.getElementById("naam").value);
        },
        'erorr' : function(){
            alert("Product is niet toegevoegd")
        }
    });
}

function nieuwe_categorie(){
    toevoegen();
    document.querySelector(".optie").value = "/api/categorie/add";
}

function bestaande_categorie(){
    toevoegen();
    document.querySelector(".optie").value = "/api/bestaande_categorie";
}

function producten(){
    $.ajax({
        'url': 'http://localhost:8081/api/products',
        'type': 'GET',
        'contentType': 'application/json',
        'success': function (data) {
            for (const product of data) {
                let table = document.querySelector("table");
                let row = table.insertRow(1);
                let cell1 = row.insertCell(0);
                let cell2 = row.insertCell(1);
                let cell3 = row.insertCell(2);
                let cell4 = row.insertCell(3);

                cell1.innerHTML = product.id;
                cell2.innerHTML = product.naam;
                cell3.innerHTML = product.prijs;
                cell4.innerHTML = product.aanbiedingprijs;

                let btn = document.createElement('input');
                btn.type = "button";
                btn.className = "button";
                btn.value = "Toevoegen aan product";
                row.appendChild(btn);

                btn.addEventListener("click", function () {
                    $.ajax({
                        'url': 'http://localhost:8081/api/aanbieding/getAanbiedingen',
                        'type': 'GET',
                        'contentType': 'application/json',
                        'success': function (data) {
                            let lijst = [];
                            let i;
                            for (i = 0; i < data.length; i++) {
                                lijst.push(data[i].id);
                            }
                            $.ajax({
                                'url': 'http://localhost:8081/api/aanbieding/add_product/'+product.id+"/"+Math.max.apply(Math, lijst),
                                'type': 'POST',
                                'contentType': 'application/json',
                                'success': function () {
                                    table.deleteRow(row.rowIndex);
                                }
                            });
                        }
                    });
                });
            }
        }
        });
}


function bestaande_producten(){
    producten();
    document.querySelector(".optie").value = "/api/bestaande_categorie";
}

function getProducten(){
    $.ajax({
        'url': 'http://localhost:8081/api/products',
        'type': 'GET',
        'contentType': 'application/json',
        'success': function (data) {
            for (const product of data) {
                let table = document.querySelector("table");
                let row = table.insertRow(1);
                let cell1 = row.insertCell(0);
                let cell2 = row.insertCell(1);
                let cell3 = row.insertCell(2);
                let cell4 = row.insertCell(3);

                cell1.innerHTML = product.id;
                cell2.innerHTML = product.naam;
                cell3.innerHTML = product.prijs;
                cell4.innerHTML = product.aanbiedingprijs;

                let btn = document.createElement('input');
                btn.type = "button";
                btn.className = "button";
                btn.value = "Wijzigen";
                row.appendChild(btn);

                let btn_verwijderen = document.createElement('input');
                btn_verwijderen.type = "button";
                btn_verwijderen.className = "verwijderen";
                btn_verwijderen.value = "Verwijderen";
                row.appendChild(btn_verwijderen);
            }
        }
    });

}
