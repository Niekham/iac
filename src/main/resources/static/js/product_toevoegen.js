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
    let json = JSON.parse(JSON.stringify(jQuery('.productForm').serializeArray()));
    let obj = formToJson(json);
    obj["afbeelding"] = document.getElementById("naam").value;
    $.ajax({
        'url': 'http://localhost:8081/api/products/add',
        'data': JSON.stringify(obj),
        'type': 'POST',
        'contentType': 'application/json',
        'success' : function(){
            alert("Product is toegevoegd")
            sessionStorage.setItem("productnaam", document.getElementById("naam1").value);
            sessionStorage.setItem("productprijs", document.getElementById("prijs").value);
            sessionStorage.setItem("productafbeelding", document.getElementById("naam").value);
        },
        'erorr' : function(){
            alert("Product is niet toegevoegd")
        }
    });
}

function nieuwe_categorie(){
    toevoegen();
    document.querySelector(".optie").value = "/api/categorie/add";
}

function bestaande_categorie(){
    toevoegen();
    document.querySelector(".optie").value = "/api/bestaande_categorie";
}

function producten(){

    fetch("http://localhost:8081/api/products")
        .then(function(response){
            return response.json();
        })
        .then(function(myJson) {
            for (const product of myJson) {
                let table = document.querySelector("table");
                let row = table.insertRow(1);
                let cell1 = row.insertCell(0);
                let cell2 = row.insertCell(1);
                let cell3 = row.insertCell(2);
                let cell4 = row.insertCell(3);

                cell1.innerHTML = product.id;
                cell2.innerHTML = product.naam;
                cell3.innerHTML = product.prijs;
                cell4.innerHTML = product.aanbiedingprijs;

                var btn = document.createElement('input');
                btn.type = "radio";
                btn.className = "radio";
                btn.value = "Toevoegen aan product";
                row.appendChild(btn);





            }
        });
    uncheck_button();
}
function uncheck_button(){$(document).ready(function() {

    $(function() {
        let allRadios = $('input[type=radio]')
        let radioChecked;

        let setCurrent =
            function(e) {
                let obj = e.target;

                radioChecked = $(obj).attr('checked');
            }

        let setCheck =
            function(e) {

                if (e.type == 'keypress' && e.charCode != 32) {
                    return false;
                }

                let obj = e.target;

                if (radioChecked) {
                    $(obj).attr('checked', false);
                } else {
                    $(obj).attr('checked', true);
                }
            }

        $.each(allRadios, function(i, val) {
            let label = $('label[for=' + $(this).attr("id") + ']');

            $(this).bind('mousedown keydown', function(e) {
                setCurrent(e);
            });

            label.bind('mousedown keydown', function(e) {
                e.target = $('#' + $(this).attr("for"));
                setCurrent(e);
            });

            $(this).bind('click', function(e) {
                setCheck(e);
            });

        });

    });
});
}