function verwerkGetProductByAanbieding(data) {
    var div = document.createElement("div");
    div.setAttribute("class", "productLijst");

    var productId = document.createElement("label");
    productId.setAttribute("class", "productId")
    productId.innerText = data.id;
    productId.hidden;

    var naam = document.createElement("label");
    naam.setAttribute("class", "text");
    naam.innerText = data.naam;

    var prijs = document.createElement("label");
    prijs.setAttribute("class", "text");
    prijs.innerText = "Prijs: " + data.prijs;

    var aanbiedingPrijs = document.createElement("label");
    aanbiedingPrijs.setAttribute("class", "text");
    aanbiedingPrijs.innerText = "Aanbiedingsprijs: " + data.aanbiedingprijs;

    var button = document.createElement("input");
    button.setAttribute("type", "button");
    button.setAttribute("class", "productButton");
    button.setAttribute("value", "Bekijk");

    div.appendChild(naam);
    div.appendChild(prijs);
    if (data.aanbiedingprijs > 0){div.appendChild(aanbiedingPrijs);}
    div.appendChild(button);
    document.querySelector(".container").appendChild(div);

}