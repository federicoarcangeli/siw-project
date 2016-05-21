/**
 * 
 */

var getComanda = function() {
	
	document.getElementById("libero").addEventListener('click',function() {
		alert('libero');
	});
	
	document.getElementById("prenotato").addEventListener('click',function() {
		alert('prenotato');
	});
	
	document.getElementById("occupato").addEventListener('click', function() {
		alert('occupato');
	});
}