var Products = (function() {
	var searchBox, productsContainer;

	handleSearchEvent = function(event) {
		clearTimeout($.data(this, 'timer'));
		if (event.keyCode == 13) {
			searchProducts(true);
		} else {
			$(this).data('timer', setTimeout(searchProducts, 500));
		}
	}, searchProducts = function(force) {
		var searchText = searchBox.val();
		if (searchText !== '') {
			var queryString = '?q=' + searchText;
			$.get("sales/searchproduct" + queryString, function(products) {
				productsContainer.html(products).show();
			});
		} else {
			productsContainer.empty();
		}
	};

	return {
		init : function() {
			searchBox = $("#searchbox");
			productsContainer = $("#products");
		},
		bindEvents : function() {
			searchBox.keyup(function(event) {
				handleSearchEvent(event);
			});
		}
	};
})();

$(document).ready(function() {
	Products.init();
	Products.bindEvents();
});
