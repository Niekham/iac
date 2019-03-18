//get request voor het ophalen van alle categorieen
function getCategories() {
    fetch("http://localhost:8081/api/categories")
        .then(function(response){
            return response.json();
        })
        .then(function(myJson){
            var i;
            for (i = 0; i < myJson.length; i++){
                verwerkGetCategories(myJson[i]);
            }
        });
}

//voegt alle categorieen te aan de pagina
function verwerkGetCategories(data) {
    var navigatie = document.querySelector(".navigatie");
    var categorie = document.createElement("a");
    categorie.innerText = data.naam;
    categorie.href="/categorie/" +data.id;
    navigatie.appendChild(categorie);
}

