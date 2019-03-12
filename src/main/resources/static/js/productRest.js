function checkLoad(){
    if (sessionStorage.getItem("Aanbieding") != null){
        getProductByAanbieding(sessionStorage.getItem("Aanbieding"));
    }if (sessionStorage.getItem("Categorie") != null){
        console.log("Wel een categorie");
    }
}

function getProductByAanbieding(id) {
    fetch("http://localhost:8081/api/products/aanbieding/" + id)
        .then(function(response){
            return response.json();
        })
        .then(function(myJson){
            var i;
            for (i = 0; i < myJson.length; i++){
                console.log(myJson[i])
                verwerkGetProductByAanbieding(myJson[i])
            }
        });
}