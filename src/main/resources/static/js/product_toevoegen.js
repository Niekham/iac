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

