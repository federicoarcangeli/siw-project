
function show_alert() {
	var check = confirm("Stai per inserire:\n"
			+ document.getElementById("nome").value + "\n"
			+ document.getElementById("prezzo").value);
	if (check == true) {
		return true;
	} else {
		window.location.href = "./inserimentoPiatti.jsp";
		return false;
	}

}