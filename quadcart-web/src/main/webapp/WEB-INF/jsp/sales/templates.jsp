<script type="text/template" id="product-details-template">
	<li>
		<product class="product-view">
			<header>
				<h1 class="product-header"># {{ id }}. {{ name }}</h1>
			</header>
			<div>
				<a href="#" title="Product details">
					<img src="<c:url value="/statics/images/product-image.png" />" alt="product details.">
				</a>
			</div>
			<div class="product-details">
				<dl>
					<dt><spring:message code="manufacturer.abbrevation" />: </dt>
					<dd>{{ manufacturerName }}</dd>
				</dl>
				<dl>
					<dt><spring:message code="product.price" />: </dt>
					<dd>{{ price }}</dd>
				</dl>
			</div>
			<div class="clear"></div>
		</product>
	</li>
</script>

<script type="text/template" id="product-empty-template">
  	<li class="products-empty"><spring:message code="no.products.found" /></li>
</script>

<script type="text/template" id="product-cart-template">
	<div>
		<id>{{ id }}</id>
		<name>{{ name }}</name>
		<price>{{ price }}</price>
		<quantity><input type="text" maxlength="4" value="{{ quantity }}" /></quantity>
		<total>{{ total }}</total>
	</div>
</script>
