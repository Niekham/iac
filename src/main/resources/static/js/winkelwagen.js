function verwerkProduct(data) {
    let item = data.split(',');
    let selectbox = document.getElementById("aantal");
    let aantal = selectbox.options[selectbox.selectedIndex].value;
    let json ={"id":parseInt(item[0]), "naam":item[1], "prijs":parseFloat(item[2]), "aanbiedingprijs":parseFloat(item[3]), "aantal":parseInt(aantal)};
    addToCart(json);
    location.reload();

}

function addToCart(data) {
    let myJson = {"product":[]};
    if (sessionStorage.getItem("bestellingregel") == null){
        myJson["product"].push(data);
        sessionStorage.setItem("bestellingregel", JSON.stringify(myJson));
    }else{
        let jsonStorage = JSON.parse(sessionStorage.getItem("bestellingregel"));
        let add=0;
        for (const item of jsonStorage['product']){
            if (data.id === item.id){
                item.aantal += data.aantal;
                add +=1;
                sessionStorage.setItem("bestellingregel", JSON.stringify(jsonStorage));
            }
        }
        if(add === 0) {
            jsonStorage["product"].push(data);
            sessionStorage.setItem("bestellingregel", JSON.stringify(jsonStorage));
            console.log("zit er nog niet in");
        }
    }
}


function showWinkelwagen(){
    let modal = document.querySelector(".winkelwagen");
    modal.style.display = "block";

    document.querySelector(".close").addEventListener("click", function () {
        document.querySelector(".winkelwagen").style.display = "none";
    });
    window.addEventListener("click", function () {
        if (event.target === modal) {
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

    //bestelknop doorsturen naar de afrekenpagina
    var bestelknop = document.getElementsByClassName("bestelButton")[0];

    if(bestelknop !== undefined) {
        bestelknop.addEventListener("click", function() {
            window.location.href = "/afrekenen";
        });
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

    let del = document.createElement("input");
    del.setAttribute("class", "closeButton");
    del.type="button";
    del.value="x";
    newDiv.appendChild(naam);
    newDiv.appendChild(prijs);
    newDiv.append(del);
    newDiv.appendChild(aantal);
    div.appendChild(newDiv);

    aantal.addEventListener("change", function () {
        changeAantal((aantal.selectedIndex + 1), item.id);
    });

    del.addEventListener("click", function () {
        deleteFromCart(item.id);
    });
    showTotal();
}

function showTotal() {
    let jsonObject = JSON.parse(sessionStorage.getItem("bestellingregel"));
    let total = 0;
    for (const item of jsonObject['product']){
            if (item.aanbiedingprijs !== null){
                total += item.aanbiedingprijs * item.aantal;
            } else {
                total += item.prijs * item.aantal;
            }
        }
    total = parseFloat(Math.round(total * 100) / 100).toFixed(2);
    document.querySelector(".total").innerHTML="Total: $"+total.toString();
}

function changeAantal(selected, productid) {
    let jsonObject = JSON.parse(sessionStorage.getItem("bestellingregel"));
    for (const item of jsonObject['product']){
           if (item.id === productid){
               item.aantal = selected;
           }
        }
    sessionStorage.setItem("bestellingregel", JSON.stringify(jsonObject));
    showTotal();
}

function deleteFromCart(productid) {
    let jsonObject = JSON.parse(sessionStorage.getItem("bestellingregel"));
    let myJson = {"product":[]};

   for (const item of jsonObject['product']){
       if(item.id !== productid) {
           myJson['product'].push(item);
       }
   }
   sessionStorage.setItem("bestellingregel", JSON.stringify(myJson));
   location.reload();
}

function emptyCart() {
    sessionStorage.setItem("bestellingregel", JSON.stringify({"product":[]}));
}