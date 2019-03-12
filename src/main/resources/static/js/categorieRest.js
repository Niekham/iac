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