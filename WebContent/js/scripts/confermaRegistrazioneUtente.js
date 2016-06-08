$('#conferma').click(function() {
	$('#nom').text($('#registrazioneUtente\\:nome').val());
	$('#cog').text($('#registrazioneUtente\\:cognome').val());
	$('#ema').text($('#registrazioneUtente\\:email').val());
	$('#use').text($('#registrazioneUtente\\:username').val());
	$('#tel').text($('#registrazioneUtente\\:telefono').val());
});