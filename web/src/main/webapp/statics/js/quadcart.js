_.templateSettings = {
    interpolate: /\{\{(.+?)\}\}/g
};

var Products = (function() {
    var searchBox, productsContainer, searchKeyDelay = 200,
        productDetailsTemplate, productDetailsEmptyTemplate;

    var handleSearchEvent = function(event) {

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
    
        Cart.add(product);
    
    };

    return {
        init: function() {

            searchBox = $('#searchbox');

            productsContainer = $('#products .product-list');

            productDetailsTemplate = _.template($('#product-details-template').html());
            productDetailsEmptyTemplate = $('#product-empty-template').html();

            return this;
        
        },
        bindEvents: function() {
        
            searchBox.keyup(function(event) {
                handleSearchEvent(event);
            });

            $('#products ul').on('click', 'product', function() {
                addProductToCart($(this));
            });

            return this;
        
        }
    };
})();

var Cart = (function() {

    var productCartTemplate, productsAddedToCart = [];

    var addProductToCart = function(product) {

        var productId = product.data('id');

        if(productAlreadyExistInCart(productId)) {
            updateExistingProductInCart(productId);
        } else {
            addNewProductToCart(product);
        }

    }, updateExistingProductInCart = function(productId) {

        var $selectedProduct = $('#cart_' + productId);
        
        var $quantity = $selectedProduct.find('input[type=text]');
        var quantity = +$quantity.val();
        $quantity.val(quantity + 1);

        var $total = $selectedProduct.find('total');
        var $price = $selectedProduct.find('price');
        var price = +$price.html();
        $total.html("" + (price * (quantity + 1)));
    
    }, addNewProductToCart = function(product) {
        
        var productId = product.data('id');

        var data = {
            id: productId,
            name: product.data('name'),
            price: product.data('price'),
            quantity: '1',
            total: product.data('price')
        };

        var result = productCartTemplate(data);
        $('#product-details').append(result);

        productsAddedToCart.push(data);

    }, productAlreadyExistInCart = function(productId) {

        var alreadyAddedToCart = false;

        $(productsAddedToCart).each(function(index, productInCart) {
            alreadyAddedToCart = productId === productInCart.id;
            return !alreadyAddedToCart;
        });

        return alreadyAddedToCart;

    };

    return {
        add: addProductToCart,
        init: function() {
            
            productCartTemplate = _.template($('#product-cart-template').html());

            return this;
        
        }
    };
})();

$(document).ready(function() {
    Products.init().bindEvents();
    Cart.init();
});
