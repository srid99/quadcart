_.templateSettings = {
    interpolate: /\{\{(.+?)\}\}/g
};

var Products = (function() {
    var searchBox, productsContainer, searchKeyDelay = 200,
        productDetailsTemplate, productDetailsEmptyTemplate, productCartTemplate;

    handleSearchEvent = function(event) {
        clearTimeout($.data(this, 'timer'));
        if (event.keyCode == 13) {
            searchProducts();
        } else {
            $(this).data('timer', setTimeout(searchProducts, searchKeyDelay));
        }
    }, searchProducts = function() {
        var searchText = searchBox.val();
        if (searchText !== '') {
            var queryString = '?q=' + searchText;
            $.get('sales/searchproduct' + queryString, function(jsonObj) {
                renderProductDetails($.parseJSON(jsonObj).products);
            });
        } else {
            productsContainer.empty();
        }
    }, renderProductDetails = function(products) {
        var productDetailsContent = '';

        if(products.length > 0) { 
            _.each(products, function(product) {
                productDetailsContent += productDetailsTemplate(product);
            });
        } else {
            productDetailsContent = productDetailsEmptyTemplate;
        }

        productsContainer.html(productDetailsContent).show();
    }, addProductToCart = function(product) {
        var data = {
            id: product.data('id'),
            name: product.data('name'),
            price: product.data('price'),
            quantity: '1',
            total: product.data('price')
        };
        var result = productCartTemplate(data);
        $('#product-details').append(result);
    };

    return {
        init: function() {
            searchBox = $('#searchbox');

            productsContainer = $('#products .product-list');

            productCartTemplate = _.template($('#product-cart-template').html());
            productDetailsTemplate = _.template($('#product-details-template').html());
            productDetailsEmptyTemplate = $('#product-empty-template').html();
        },
        bindEvents: function() {
            searchBox.keyup(function(event) {
                handleSearchEvent(event);
            });

            $('#products ul').on('click', 'product', function() {
                addProductToCart($(this));
            });
        }
    };
})();

$(document).ready(function() {
    Products.init();
    Products.bindEvents();
});
