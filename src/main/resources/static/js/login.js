function check(input) {
    if (input.value !== document.getElementById('pass').value) {
        document.querySelector(".ongelijk").style.display="inline";
    } else {
        document.querySelector(".ongelijk").style.display="none";
    }
}