_.templateSettings = {
    interpolate: /\{\{(.+?)\}\}/g
};

var Products = (function() {
    var searchBox, productsContainer, searchKeyDelay = 200,
        productDetailsTemplate, productDetailsEmptyTemplate,

    handleSearchEvent = function(event) {
        clearTimeout($.data(this, 'timer'));
        if (event.keyCode == 13) {
            searchProducts();
        } else {
            $(this).data('timer', setTimeout(searchProducts, searchKeyDelay));
        }
    },

    searchProducts = function() {
        var searchText = searchBox.val();
    
        if (searchText !== '') {
            var queryString = '?q=' + searchText;

            $.get('sales/searchproduct' + queryString, function(jsonObj) {
                renderProductDetails($.parseJSON(jsonObj).products);
            });
        } else {
            productsContainer.empty();
        }
    },

    renderProductDetails = function(products) {
        var productDetailsContent = '';

        if(products.length > 0) { 
            _.each(products, function(product) {
                productDetailsContent += productDetailsTemplate(product);
            });
        } else {
            productDetailsContent = productDetailsEmptyTemplate;
        }

        productsContainer.html(productDetailsContent).show();
    },

    addProductToCart = function(product) {
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

    var productCartTemplate,

    addProductToCart = function(product) {
        var productId = product.data('id');

        if(ProductCollection.exist(productId)) {
            updateExistingProductInCart(productId);
        } else {
            addNewProductToCart(product);
        }
    },

    updateExistingProductInCart = function(productId) {

        console.log(productId);

        var $selectedProduct = $('#cart_' + productId);
        
        var $quantity = $selectedProduct.find('input[type=text]');
        var quantity = +$quantity.val();
        $quantity.val(quantity + 1);

        var $total = $selectedProduct.find('total');
        var $price = $selectedProduct.find('price');
        var price = +$price.html();
        $total.html("" + (price * (quantity + 1)));
    },

    addNewProductToCart = function(product) {
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

        ProductCollection.add(data);

        if(ProductCollection.size() == 1) {
            toggleClearCartButton();
        }
    },

    emptyCart = function() {
        ProductCollection.clear();
        toggleClearCartButton();
        $('#product-details div:gt(0)').remove();
    },

    toggleClearCartButton = function() {
        $('.clear-cart').toggleClass('hidden');
    }

    return {
        add: addProductToCart,
        
        init: function() {            
            productCartTemplate = _.template($('#product-cart-template').html());

            return this;
        },

        bindEvents: function() {
            $('.clear-cart').click(function() {
                emptyCart();
            });

            return this;            
        }
    };
})();

var ProductCollection = (function() {
    var productsAddedToCart = [],

    add = function(product) {
        productsAddedToCart.push(product);
    },

    remove = function(productId) {
        productsAddedToCart = jQuery.grep(productsAddedToCart, function(product) {
            return product.id != productId;
        });
    },

    clear = function() {
        productsAddedToCart.length = 0;
    },

    size = function() {
        return productsAddedToCart.length;
    },

    exist = function(productId) {
        var alreadyAddedToCart = false;

        productsAddedToCart.every(function(product) {
            return !(alreadyAddedToCart = productId === product.id);
        });

        return alreadyAddedToCart;
    };

    return {
        add: add,
        remove: remove,
        clear: clear,
        size: size,
        exist: exist
    };
})();

$(document).ready(function() {
    Products.init().bindEvents();
    Cart.init().bindEvents();
});
