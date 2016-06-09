$('#conferma').click(function() {
	$('#date').text($('#prenotazioni\\:datepicker').val());
	$('#time').text($('#prenotazioni\\:timepicker').val());
	$('#osp').text($('#prenotazioni\\:coperti').val());
});