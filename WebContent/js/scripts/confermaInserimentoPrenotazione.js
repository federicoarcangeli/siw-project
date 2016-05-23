$('#submitBtn').click(function() {
	$('#date').text($('#datepicker').val());
	$('#time').text($('#timepicker').val());
	$('#osp').text($('#ospiti').val());
});

$('#submit').click(function(){
	$('#formfield').submit();
});