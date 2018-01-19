var userRole;
$(document).ready(function() {
	userRole = getRole();
	//appendHeader();
	//appendFooter();
	document.title="";
});

function getRole() {
	var role = "";
	$.ajax({
		url : "/getUserRole",
		async : false,
		success : function(data) {
			role = data.response;
		}
	});
	return role;

}