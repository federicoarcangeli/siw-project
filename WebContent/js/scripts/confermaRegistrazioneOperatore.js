$('#submitBtn').click(function() {
	$('#use').text($('#username').val());
	$('#rol').text($('#role').val());
});

$('#submit').click(function(){
	$('#formfield').submit();
});