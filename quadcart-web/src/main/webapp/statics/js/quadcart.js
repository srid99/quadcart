$(document).ready(function() {
    $("#searchbox").keyup(function(event) {
    	Products.handleSearchEvent(event);
    });
});

var Products = (function() {

    return {
    	handleSearchEvent: function(event) {
            clearTimeout($.data(this, 'timer'));
            if (event.keyCode == 13) {
                Products.searchProducts(true);
            } else {
                $(this).data('timer', setTimeout(Products.searchProducts, 500));
            }
    	},
        searchProducts: function(force) {
            var searchText = $("#searchbox").val();
            if (searchText !== '') {
                var queryString = '?q=' + searchText;
                $.get("sales/searchproduct" + queryString, function(products) {
                    $("#products").html(products).show();
                });
            } else {
                $("#products").empty();
            }
        }
    };
})();
