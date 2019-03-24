//haalt alle aanbiedingen op
function getAanbiedingen() {
    $.ajax({
        'url': 'http://localhost:8081/api/aanbieding',
        'type': 'GET',
        'contentType': "application/json",
        'error': function () {
            console.log("Er is iets misgegaan met ophalen van aanbieding");
        },
        'success': function (data) {
            if (data.length !== 0) {
                let i;
                for (i = 0; i < data.length; i++) {
                    verwerkGetAanbiedingen(data[i]);
                }
            } else {
                console.log("Geen aanbiedingen gevonden!");
            }
        }
    });
}

//pakt data van aanbiedingen maakt elementen aan voor elk deel van de data
function verwerkGetAanbiedingen(data) {
    let div = document.createElement("div");
    div.setAttribute("class", "aanbiedingLijst");

    let korting = document.createElement("label");
    korting.setAttribute("class", "aanbiedinglabel");
    korting.innerText = data.omschrijving;

    let aanbiedingId = document.createElement("label");
    aanbiedingId.setAttribute("class", "aanbiedingId");
    aanbiedingId.innerText = data.id;
    aanbiedingId.hidden;

    let vanDatum = document.createElement("label");
    let vanDatumDate = new Date(data.vanDatum);
    let vanDatumFormat = vanDatumDate.getDate() + '-' + (vanDatumDate.getMonth() + 1) + '-' + vanDatumDate.getFullYear();
    let totDatumDate = new Date(data.totDatum);
    let totDatumDateFormat = totDatumDate.getDate() + '-' + (vanDatumDate.getMonth() + 1) + '-' + totDatumDate.getFullYear();
    vanDatum.setAttribute("class", "looptijd");
    vanDatum.innerText="De actie loopt van "+ vanDatumFormat + " tot " + totDatumDateFormat;

    let button = document.createElement("input");
    button.setAttribute("type", "button");
    button.setAttribute("class", "aanbiedingButton");
    button.setAttribute("value", "Bekijk");

    div.appendChild(button);
    div.appendChild(aanbiedingId);
    div.appendChild(korting);
    div.appendChild(vanDatum);
    document.querySelector(".container").appendChild(div);

    button.addEventListener("click", function () {
        window.location.href="/aanbieding/" + data.id;
    });
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

function toevoegen_aanbieding(){
    let van_datum = document.getElementById("input2").value;
    let tot_datum = document.getElementById("input3").value;
    let date = van_datum.toString();
    let date1 = tot_datum.toString();
    let json = JSON.parse(JSON.stringify($('.aanbieding_form').serializeArray()));
    let obj = formToJson(json);
    obj["vanDatum"]=date;
    obj["totDatum"]=date1;
    console.log(obj);
    $.ajax({
        'url': 'http://localhost:8081/api/aanbieding/add',
        'data': JSON.stringify(obj),
        'type': 'POST',
        'contentType': 'application/json',
        'success' : function(){
            alert("Aanbieding is toegevoegd");
            location.reload();
        },
        'error' : function(){
            alert("Aanbieding is niet toegevoegd");
        }
    });

}

function bestaande_producten(){
    toevoegen_aanbieding();
    window.location.href = "/api/bestaandeProducten"
}