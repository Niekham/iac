//get request voor het ophalen van alle categorieen
function getCategories() {
    $.ajax({
        'url': 'http://localhost:8081/api/categories',
        'type':'GET',
        'contentType':'application/json',
        'error':function () {
            console.log("Er is iers misgegaan met ophalen van categories")
        },
        'success':function (data) {
            if (data.length !== 0){
                let i;
                for (i = 0; i < data.length; i++){
                    verwerkGetCategories(data[i]);
                }
            } else {
                console.log("Er zijn geen categorieen gevonden");
            }

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

