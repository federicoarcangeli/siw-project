$('#conferma').click(function() {
	$('#nom').text($('#prenotazioni\\:nominativo').val());
	$('#date').text($('#prenotazioni\\:datepicker').val());
	$('#time').text($('#prenotazioni\\:timepicker').val());
	$('#osp').text($('#prenotazioni\\:coperti').val());
});