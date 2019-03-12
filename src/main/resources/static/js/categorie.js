function verwerkGetCategories(data) {
    var navigatie = document.querySelector(".navigatie");
    var categorie = document.createElement("a");
    categorie.innerText=data.naam;
    navigatie.appendChild(categorie);
}

function deleteStorage(){
    sessionStorage.removeItem("Aanbieding");
}