//haalt alle aanbiedingen op
function getAanbiedingen(){
    fetch("http://localhost:8081/api/aanbieding")
        .then(function(response){
            return response.json();
        })
        .then(function(myJson){
            var i;
            for (i = 0; i < myJson.length; i++){
                verwerkGetAanbiedingen(myJson[i]);
            }
        });
}

