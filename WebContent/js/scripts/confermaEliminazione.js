//primo modale 
$('#submitBtn').click(function() {
	$('#elm').text($('#elimina').val());
});

//secondo modale
$('#submit').click(function(){
	$($('#elm').val()).submit();
});