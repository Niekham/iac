//Rest call to fetch all categories
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

//Adds all categories to navigation bar
function verwerkGetCategories(data) {
    var navigatie = document.querySelector(".navigatie");
    var categorie = document.createElement("a");
    categorie.innerText = data.naam;
    categorie.name=data.id;
    categorie.href="products.html"
    navigatie.appendChild(categorie);

    categorie.addEventListener("click", function () {
        categorieSession(categorie.name.valueOf());
    });
}

function categorieSession(id){
    sessionStorage.removeItem("Aanbieding");
    sessionStorage.setItem("Categorie", id)
}

//Verwijderen van session storage om alle producten te laden
function emptySessionStorage() {
    sessionStorage.removeItem("Aanbieding");
    sessionStorage.removeItem("Categorie")
}
