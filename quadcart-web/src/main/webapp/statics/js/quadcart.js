$(document).ready(function() {
	$("#searchbox").keypress(function(event){
	    if(event.which ==13 ){
			var searchText = $(this).val();
			var queryString = 'q=' + searchText;
			if (searchText !== '') 
			{
				$.ajax({
					type : "GET",
					url : "searchproduct.html",
					data : queryString,
					cache : false,
					success : function(html)
					{
						$("#products").html(html).show();
					}
				});
			}
			return false;
	    } 
		return true;
	});

});
