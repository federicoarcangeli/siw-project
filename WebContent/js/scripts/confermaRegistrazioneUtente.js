$('#submitBtn').click(function() {
	$('#nom').text($('#nome').val());
	$('#cog').text($('#cognome').val());
	$('#ema').text($('#email').val());
	$('#use').text($('#username').val());
	$('#tel').text($('#telefono').val());
});

$('#submit').click(function(){
	$('#formfield').submit();
});