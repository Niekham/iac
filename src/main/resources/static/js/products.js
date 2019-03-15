//producten verwerken en laden op producten pagina
function loadProducts(data) {
    let div = document.createElement("div");
    div.setAttribute("class", "productLijst");

    let productId = document.createElement("label");
    productId.setAttribute("class", "productId");
    productId.innerText = data.id;
    productId.hidden;

    let naam = document.createElement("label");
    naam.setAttribute("class", "text");
    naam.innerText = data.naam;

    let prijs = document.createElement("label");
    prijs.setAttribute("class", "text");
    prijs.innerText = "Prijs: " + data.prijs;

    let aanbiedingPrijs = document.createElement("label");
    aanbiedingPrijs.setAttribute("class", "text");
    aanbiedingPrijs.innerText = "Aanbiedingsprijs: " + data.aanbiedingprijs;

    let button = document.createElement("input");
    button.setAttribute("type", "button");
    button.setAttribute("class", "productButton");
    button.setAttribute("value", "Bekijk");

    let addButton = document.createElement("input");
    addButton.setAttribute("type", "button");
    addButton.setAttribute("class", "addButton");
    addButton.setAttribute("value", "Toevoegen");

    div.appendChild(naam);
    div.appendChild(prijs);
    if (data.aanbiedingprijs > 0){div.appendChild(aanbiedingPrijs);}
    div.appendChild(button);
    div.appendChild(addButton);
    document.querySelector(".container").appendChild(div);

    addButton.addEventListener("click", function () {
        let json = {"id":data.id, "naam":data.naam, "prijs":data.prijs, "aanbiedingprijs":parseFloat(data.aanbiedingprijs), "aantal":1};
        addToCart(json);
    });
}