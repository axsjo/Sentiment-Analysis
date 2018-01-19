(function(){
	
	$(init);
	
	function init()
	{
		$("SearchMobile").click(SearchMobile);
		var mobileName=$("#mobileName");
		
		function SearchMobile()
		{
		var title=mobileName.val();
		alert("SearchMobile: " + title);
		}
	}
	
})();