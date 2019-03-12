function verwerkGetAanbiedingen(data) {
    var div = document.createElement("div");
    div.setAttribute("class", "aanbiedingLijst");

    var korting = document.createElement("label");
    korting.innerText = data.percentage + "% korting";

    var aanbiedingId = document.createElement("label");
    aanbiedingId.setAttribute("class", "aanbiedingId")
    aanbiedingId.innerText = data.id;
    aanbiedingId.hidden;

    var button = document.createElement("input");
    button.setAttribute("type", "button");
    button.setAttribute("class", "aanbiedingButton");
    button.setAttribute("value", "Bekijk");

    div.appendChild(button);
    div.appendChild(aanbiedingId);
    div.appendChild(korting);
    document.querySelector(".container").appendChild(div);

    button.addEventListener("click", function () {
        sessionStorage.removeItem("Categorie")
        sessionStorage.setItem("Aanbieding", data.id)
        window.location.href="/products.html"
    })
}
