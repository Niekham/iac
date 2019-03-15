//kijkt of er een categorie of aanbieding is aangeklikt
function checkLoad(){
    if (sessionStorage.getItem("Aanbieding") != null){
        getProductByAanbieding(sessionStorage.getItem("Aanbieding"));
    }if (sessionStorage.getItem("Categorie") != null){
        getProductByCategorie(sessionStorage.getItem("Categorie"));
    }if (sessionStorage.getItem("Aanbieding") == null && sessionStorage.getItem("Categorie") == null){
        getAllProducts();
    }
}

//haalt alle producten op
function getAllProducts() {
    fetch("http://localhost:8081/api/products")
        .then(function(response){
            return response.json();
        })
        .then(function(myJson){
            let i;
            for (i = 0; i < myJson.length; i++){
                loadProducts(myJson[i])
            }
        });
}

//haalt producten op bij gekozen aanbieding
function getProductByAanbieding(id) {
    fetch("http://localhost:8081/api/products/aanbieding/" + id)
        .then(function(response){
            return response.json();
        })
        .then(function(myJson){
            let i;
            for (i = 0; i < myJson.length; i++){
                loadProducts(myJson[i])
            }
        });
}

//haalt producten op bij gekozen categorie
function getProductByCategorie(id) {
    fetch("http://localhost:8081/api/products/categorie/" + id)
        .then(function(response){
            return response.json();
        })
        .then(function(myJson){
            let i;
            for (i = 0; i < myJson.length; i++){
                loadProducts(myJson[i])
            }
        });
}