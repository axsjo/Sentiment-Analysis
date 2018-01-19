/**
 * 
 */

	$(document).ready(function(){
		$("#alertPanel").hide();
		$("#loginBtn").click(function(){
		var userId1 = $("#userId").val();
		var password1 = $("#password").val();
			if( userId1 =='' || password1 ==''){
				$('input[type="text"],input[type="password"],input[type="select"] ').css("border","2px solid red");
				$('input[type="text"],input[type="password"],input[type="select"] ').css("box-shadow","0 0 3px red");
				alert("Please fill all fields...!!!!!!");
			}else {
				//$("#loginForm").submit();
				$.post("/authenticate",{ userId: userId1, password:password1},
				function(data) {
					if(data.status == "STATUS_FAILURE") {
						$('input[type="text"],input[type="password"],input[type="select"] ').css({"border":"2px solid red","box-shadow":"0 0 3px red"});
						$("#alertPanel").show();
						$("#alertMessage").text(data.statusDesc);
					} else {
						//$( location ).attr("href", "/main.html");
						handleNextView();
					}
				});
			}
		});
});
function handleNextView() {
	var role = "";
	$.ajax({
		url : "/getUserRole",
		async : false,
		success : function(data) {
			role = data.response;
		}
	});
	if(role=="user" || role == "admin" || role=="admin_manager") {
		$( location ).attr("href", "/main.html");
	} else {
		$( location ).attr("href", "/main.html");
	}
}