//pakt data van aanbiedingen maakt elementen aan voor elk deel van de data
function verwerkGetAanbiedingen(data) {
    let div = document.createElement("div");
    div.setAttribute("class", "aanbiedingLijst");

    let korting = document.createElement("label");
    korting.innerText = data.percentage + "% korting";

    let aanbiedingId = document.createElement("label");
    aanbiedingId.setAttribute("class", "aanbiedingId");
    aanbiedingId.innerText = data.id;
    aanbiedingId.hidden;

    let button = document.createElement("input");
    button.setAttribute("type", "button");
    button.setAttribute("class", "aanbiedingButton");
    button.setAttribute("value", "Bekijk");

    div.appendChild(button);
    div.appendChild(aanbiedingId);
    div.appendChild(korting);
    document.querySelector(".container").appendChild(div);

    button.addEventListener("click", function () {
        sessionStorage.removeItem("Categorie");
        sessionStorage.setItem("Aanbieding", data.id);
        window.location.href="/products.html";
    });
}
