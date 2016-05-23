/**
 * 
 */

var getComanda = function() {
		
	document.getElementById("libero").addEventListener('click',function() {
		var codiceTavolo = document.getElementById("codiceTavolo");
		alert(codiceTavolo);
		window.location.href = './processaComanda';
	});
	
	document.getElementById("prenotato").addEventListener('click',function() {
		alert('prenotato');
	});
	
	document.getElementById("occupato").addEventListener('click', function() {
		alert('occupato');
	});
}