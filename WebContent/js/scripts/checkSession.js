/**
 * controllo se la sessione in corso è attiva. In caso negativo si viene
 * reindirizzati ad una pagina 404
 */

function checkSession() {
	var session = '<%=session.getAttribute("amministratoreCorrente") != null%>';
	if (session == false) {
		alert('sessione scaduta');
		window.location = "./404.html";
	} else {
		alert('else')
	}
	setInterval(checkSession(), 1000);

}