//haalt alle aanbiedingen op
function getAanbiedingen(){
    fetch("http://localhost:8081/api/aanbieding")
        .then(function(response){
            return response.json();
        })
        .then(function(myJson){
            var i;
            for (i = 0; i < myJson.length; i++){
                verwerkGetAanbiedingen(myJson[i]);
            }
        });
}


//pakt data van aanbiedingen maakt elementen aan voor elk deel van de data
function verwerkGetAanbiedingen(data) {
    let div = document.createElement("div");
    div.setAttribute("class", "aanbiedingLijst");

    let korting = document.createElement("label");
    korting.setAttribute("class", "aanbiedinglabel");
    korting.innerText = data.percentage + "% korting";

    let aanbiedingId = document.createElement("label");
    aanbiedingId.setAttribute("class", "aanbiedingId");
    aanbiedingId.innerText = data.id;
    aanbiedingId.hidden;

    let vanDatum = document.createElement("label");
    vanDatum.setAttribute("class", "aanbiedinglabel");
    vanDatum.innerText="Van: "+data.vanDatum;

    let totDatum = document.createElement("label");
    totDatum.setAttribute("class", "aanbiedinglabel");
    totDatum.innerText="Tot: "+data.totDatum;


    let button = document.createElement("input");
    button.setAttribute("type", "button");
    button.setAttribute("class", "aanbiedingButton");
    button.setAttribute("value", "Bekijk");

    div.appendChild(button);
    div.appendChild(aanbiedingId);
    div.appendChild(korting);
    div.appendChild(vanDatum);
    div.appendChild(totDatum);
    document.querySelector(".container").appendChild(div);

    button.addEventListener("click", function () {
        sessionStorage.removeItem("Categorie");
        sessionStorage.setItem("Aanbieding", data.id);
        window.location.href="/aanbieding/" + data.id;
    });
}
