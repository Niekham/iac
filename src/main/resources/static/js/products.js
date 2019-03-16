//producten verwerken en laden op producten pagina
function loadProducts(data) {
    //maakt div element waar alle informatie over een product in komt te staan
    let div = document.createElement("div");
    div.setAttribute("class", "productLijst");

    //label per product om id van product op te vragen
    let productId = document.createElement("label");
    productId.setAttribute("class", "productId");
    productId.innerText = data.id;
    productId.hidden;

    //label voor de naam per product
    let naam = document.createElement("label");
    naam.setAttribute("class", "text");
    naam.innerText = data.naam;

    //label voor prijs per product
    let prijs = document.createElement("label");
    prijs.setAttribute("class", "text");
    prijs.innerText = "Prijs: " + data.prijs;

    //Label voor aanbiedingsprijs
    let aanbiedingPrijs = document.createElement("label");
    aanbiedingPrijs.setAttribute("class", "text");
    aanbiedingPrijs.innerText = "Aanbiedingsprijs: " + data.aanbiedingprijs;

    //button voor het bekijken van een product
    let button = document.createElement("input");
    button.setAttribute("type", "button");
    button.setAttribute("class", "productButton");
    button.setAttribute("value", "Bekijk");

    //button voor het toevoegen aan winkelmand
    let addButton = document.createElement("input");
    addButton.setAttribute("type", "button");
    addButton.setAttribute("class", "addButton");
    addButton.setAttribute("value", "Toevoegen");

    //voegt alle product informatie toe aan div element
    div.appendChild(naam);
    div.appendChild(prijs);
    if (data.aanbiedingprijs > 0){div.appendChild(aanbiedingPrijs);} //als aanbiedingsprijs niet groter is dan 0, niet laten zien bij product
    div.appendChild(button);
    div.appendChild(addButton);
    document.querySelector(".container").appendChild(div);

    //Zorgt ervoor dat alle informatie per product verzonden wordt naar addToCart functie
    addButton.addEventListener("click", function () {
        let json = {"id":data.id, "naam":data.naam, "prijs":data.prijs, "aanbiedingprijs":parseFloat(data.aanbiedingprijs), "aantal":1};
        addToCart(json);
    });
}
