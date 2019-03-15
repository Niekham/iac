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
