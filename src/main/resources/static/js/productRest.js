function checkLoad(){
    if (sessionStorage.getItem("Aanbieding") != null){
        getProductByAanbieding(sessionStorage.getItem("Aanbieding"));
    }if (sessionStorage.getItem("Categorie") != null){
        getProductByCategorie(sessionStorage.getItem("Categorie"));
    }if (sessionStorage.getItem("Aanbieding") == null && sessionStorage.getItem("Categorie") == null){
        getAllProducts();
    }
}

function getAllProducts() {
    fetch("http://localhost:8081/api/products")
        .then(function(response){
            return response.json();
        })
        .then(function(myJson){
            let i;
            for (i = 0; i < myJson.length; i++){
                console.log(myJson[i])
                verwerkGetProductByAanbieding(myJson[i])
            }
        });
}

function getProductByAanbieding(id) {
    fetch("http://localhost:8081/api/products/aanbieding/" + id)
        .then(function(response){
            return response.json();
        })
        .then(function(myJson){
            let i;
            for (i = 0; i < myJson.length; i++){
                console.log(myJson[i])
                verwerkGetProductByAanbieding(myJson[i])
            }
        });
}

function getProductByCategorie(id) {
    fetch("http://localhost:8081/api/products/categorie/" + id)
        .then(function(response){
            return response.json();
        })
        .then(function(myJson){
            let i;
            for (i = 0; i < myJson.length; i++){
                console.log(myJson[i])
                verwerkGetProductByAanbieding(myJson[i])
            }
        });
}