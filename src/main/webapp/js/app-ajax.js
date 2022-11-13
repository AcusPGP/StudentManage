$(document).ready(function() {
    $('#userName').blur(function(event) {
        var name = $('#userName').val();
        $.get('GetUserServlet', {
            userName : name
        }, function(responseText) {
            $('#ajaxGetUserServletResponse').text(responseText);
        });
    });
});


/**
 * We can also make jQuery AJAX call using it’s ajax() method, as shown below. Above is the shorthand approach to using ajax() method.
 *
 * $(document).ready(function() {
 * 	$('#userName').blur(function() {
 * 		$.ajax({
 * 			url : 'GetUserServlet',
 * 			data : {
 * 				userName : $('#userName').val()
 * 			},
 * 			success : function(responseText) {
 * 				$('#ajaxGetUserServletResponse').text(responseText);
 * 			}
 * 		});
 * 	});
 * });
 */