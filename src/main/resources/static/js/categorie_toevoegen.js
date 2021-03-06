function formToJson(tojson){
    let i;
    let json = {};
    for (i = 0; i < tojson.length; i++) {
        json[tojson[i].name] = tojson[i].value;
    }
    JSON.stringify(json);
    return json;
}

function toevoegen(){
    let json = JSON.parse(JSON.stringify(jQuery('.categerieForm').serializeArray()));
    let obj = formToJson(json);
    obj["afbeelding"] = document.getElementById("naam").value;
    $.ajax({
        'url': 'http://localhost:8081/api/categories/add',
        'data': JSON.stringify(obj),
        'type': 'POST',
        'contentType': 'application/json',
        'success' : function(){
            alert("Categorie is toegevoegd");
        },
        'erorr' : function(){
            alert("Categorie is niet toegevoegd")
        }
    });

}

function categorien(){
    fetch("http://localhost:8081/api/categories")
        .then(function(response){
            return response.json();
        })
        .then(function(myJson){
            for(const categorie of myJson){
                if (categorie.naam !== "Nieuw") {
                    var table = document.querySelector("table");
                    var row = table.insertRow(1);
                    var cell1 = row.insertCell(0);
                    var cell2 = row.insertCell(1);
                    var cell3 = row.insertCell(2);
                    cell1.innerHTML = categorie.id;
                    cell2.innerHTML = categorie.naam;
                    cell3.innerHTML = categorie.omschrijving;

                    var btn = document.createElement('input');
                    btn.type = "button";
                    btn.className = "btn";
                    btn.value = "Toevoegen aan product";
                    row.appendChild(btn);
                    var button = document.querySelector(".btn");


                    button.addEventListener("click", function () {
                        let input1 = sessionStorage.getItem("productnaam");
                        let input2 = sessionStorage.getItem("productprijs");
                        let input3 = sessionStorage.getItem("productafbeelding");
                        var text = '{"naam":"' + input1 + '","prijs":"' + input2 + '","afbeelding":"' + input3 + '"}';
                        let obj = JSON.parse(text);
                        $.ajax({
                            'url': 'http://localhost:8081/api/products/get_product',
                            'data': JSON.stringify(obj),
                            'type': 'POST',
                            'contentType': 'application/json',
                            'success': function (data) {
                                $.ajax({
                                    'url': 'http://localhost:8081/api/products/add_categorie/' + data.id + '/' + categorie.id,
                                    'data': JSON.stringify(obj),
                                    'type': 'POST',
                                    'contentType': 'application/json',
                                    'success': function () {
                                        window.location.href = "http://localhost:8081/"
                                    },

                                });
                            }
                        });


                    });
                }
            }
        });
}

function catgorieToevoegen(){
    toevoegen();
            let input1 = sessionStorage.getItem("productnaam");
            let input2 = sessionStorage.getItem("productprijs");
            let input3 = sessionStorage.getItem("productafbeelding");
            var text = '{"naam":"'+input1+'","prijs":"'+input2+'","afbeelding":"'+input3+'"}';
            let obj = JSON.parse(text);
            $.ajax({
                'url': 'http://localhost:8081/api/products/get_product',
                'data': JSON.stringify(obj),
                'type': 'POST',
                'contentType': 'application/json',
                'success': function (data1) {
                    $.ajax({
                        'url': 'http://localhost:8081/api/categories',
                        'type': 'GET',
                        'contentType': 'application/json',
                        'success': function (data) {
                            let lijst= [];
                            let i;
                            for (i=0;i<data.length; i++) {
                                lijst.push(data[i].id);
                            }
                            $.ajax({
                                'url': 'http://localhost:8081/api/products/add_categorie/' + data1.id + '/' + Math.max.apply(Math, lijst),
                                'type': 'POST',
                                'contentType': 'application/json',
                                'success': function () {
                                    console.log("het werkt");
                                },

                            });
                        }
                    });
                }
        });
}

function getCatgorie(){
    $.ajax({
        'url': 'http://localhost:8081/api/categories',
        'type': 'GET',
        'contentType': 'application/json',
        'success': function (data) {
            for (const categorie of data) {
                let table = document.querySelector("table");
                let row = table.insertRow(1);
                let cell1 = row.insertCell(0);
                let cell2 = row.insertCell(1);
                let cell3 = row.insertCell(2);
                cell1.innerHTML = categorie.id;
                cell2.innerHTML = categorie.naam;
                cell3.innerHTML = categorie.omschrijving;

                let btn = document.createElement('input');
                btn.type = "button";
                btn.className = "button";
                btn.value = "Wijzigen"
                row.appendChild(btn);

                let btn_verwijderen = document.createElement('input');
                btn_verwijderen.type = "button";
                btn_verwijderen.className = "verwijderen";
                btn_verwijderen.value = "Verwijderen";
                row.appendChild(btn_verwijderen);

                btn.addEventListener("click", function(){
                    sessionStorage.setItem("categorieID",categorie.id);
                    window.location.href = "http://localhost:8081/api/categorie/AttributenWijzigen"
                })

                btn_verwijderen.addEventListener("click", function(){
                    $.ajax({
                        'url': 'http://localhost:8081/api/categories/delete/'+categorie.id,
                        'type': 'DELETE',
                        'contentType': 'application/json',
                        'success' : function(){
                            alert("Categorie is verwijderd");
                            location.reload();
                        },

                    });
                })

    }
}
    });
}

function wijzigCategorie(){
    let json = JSON.parse(JSON.stringify(jQuery('.categerieForm').serializeArray()));
    let obj = formToJson(json);
    obj["afbeelding"] = document.getElementById("naam").value;
    let id = sessionStorage.getItem("categorieID")
    $.ajax({
        'url': 'http://localhost:8081/api/categories/edit/'+id,
        'data': JSON.stringify(obj),
        'type': 'POST',
        'contentType': 'application/json',
        'success' : function(){
            alert("Categorie is gewijzigd");
        },
        'erorr' : function(){
            alert("Categorie is niet gewijzigd")
        }
    });

}