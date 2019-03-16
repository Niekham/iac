function addToCart(data) {
    let myJson = {"product":[]};
    if (sessionStorage.getItem("bestellingregel") == null){
        myJson["product"].push(data);
        sessionStorage.setItem("bestellingregel", JSON.stringify(myJson));
    }else{
        let jsonStorage = JSON.parse(sessionStorage.getItem("bestellingregel"));
        jsonStorage["product"].push(data);
        sessionStorage.setItem("bestellingregel", JSON.stringify(jsonStorage));
    }
}


function showWinkelwagen(){
    let modal = document.querySelector(".winkelwagen");
    modal.style.display = "block";

    document.querySelector(".close").addEventListener("click", function () {
        document.querySelector(".winkelwagen").style.display = "none";
    });
    window.addEventListener("click", function () {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    });
}


function winkelWagenContent(){
    if (sessionStorage.getItem("bestellingregel") == null){
        document.querySelector(".geenItem").style.display = "block";
    }else {
        document.querySelector(".geenItem").style.display = "hidden";
        let productJson = JSON.parse(sessionStorage.getItem("bestellingregel"));
        for(const item of productJson['product']){
            printContentToWinkelwagen(item);
        }
    }
}

function printContentToWinkelwagen(item) {
    let div = document.querySelector(".winkelwagen-body");

    let newDiv = document.createElement("div");
    newDiv.setAttribute("class", "productInWinkelwagen");

    let id = document.createElement("label");
    id.setAttribute("class", "idProductInWinkelwagen");
    id.style.display="none";
    id.innerText=item.id;

    let naam = document.createElement("label");
    naam.setAttribute("class", "naamProductInWinkelwagen");
    naam.innerText=item.naam;

    let prijs = document.createElement("label");
    prijs.setAttribute("class", "prijsProductInWinkelwagen");
    if (!item.aanbiedingprijs > 0){
        prijs.innerText= "Prijs: $" + item.prijs;
    }else{ prijs.innerText= "Aanbiedingprijs: $" + item.aanbiedingprijs;}

    let aantal = document.createElement("select");
    aantal.setAttribute("class", "aantalProductInWinkelwagen");

    let i;
    for (i = 1; i < 10; i++){
        let option = document.createElement("option");
        option.value=i;
        option.text=i;
        aantal.selectedIndex = item.aantal - 1;
        aantal.appendChild(option);
    }

    newDiv.appendChild(naam);
    newDiv.appendChild(prijs);
    newDiv.appendChild(aantal);
    div.appendChild(newDiv);

    aantal.addEventListener("change", function () {
        changeAantal((aantal.selectedIndex + 1), item.id);
    })
}

function changeAantal(selected, productid) {
    let jsonObject = JSON.parse(sessionStorage.getItem("bestellingregel"));
    for (const item of jsonObject['product']){
           if (item.id == productid){
               item.aantal = selected;
           }
        }
    sessionStorage.setItem("bestellingregel", JSON.stringify(jsonObject));
}