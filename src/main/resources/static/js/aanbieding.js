function onloadFunction(){
    fetch("http://localhost:8081/api/aanbieding")
        .then(function(response){
            return response.json();
        })
        .then(function(myJson){
            console.log(myJson[0]);
            console.log(myJson[1]);
            for (ding in myJson)
            {
                console.log(ding.percentage);
                // newdiv = document.createElement("div");
                // newdiv.setAttribute("class", "aanbiedingLijst")
                // newText = document.createElement("label");
                // newText.innerText = ding[0].percentage + "% korting op je moeder";
                //
                // newdiv.class = "aanbiedingLijst";
                // newdiv.appendChild(newText);
                // document.querySelector(".container").appendChild(newdiv);
            }
        });
}