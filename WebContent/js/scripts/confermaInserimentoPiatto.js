$('#conferma').click(function() {
	$('#cat').text($('#inserimentoPiatti\\:categoria').val());
	$('#nom').text($('#inserimentoPiatti\\:nome').val());
	$('#des').text($('#inserimentoPiatti\\:descrizione').val());
	$('#pre').text($('#inserimentoPiatti\\:prezzo').val());
});