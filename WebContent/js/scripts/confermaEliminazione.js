$('#submitBtn').click(function() {
	$('#elm').text($('#elimina').val());
});

$('#submit').click(function(){
	$($('#elimina').val()).submit();
});