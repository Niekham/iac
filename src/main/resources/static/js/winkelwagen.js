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
        let label =  document.createElement("label");
        label.innerText = "U heeft nog geen producten in uw winkelwagen";

        document.querySelector(".winkelwagen-body").appendChild(label);
    }
}