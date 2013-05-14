<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp"%>
<div id="outer-wrapper">
	<div id="left-pane" class="clearfix">

		<div id="search">
			<input name="q" type="text" size="40" placeholder="<spring:message code="search.products" />" id="searchbox" autocomplete="off" />
		</div>

		<br/>

		<div id="products">
			<ul class="product-list">
			</ul>
		</div>
	</div>

	<div id="right-pane">
		<div id="cart-details">
			<h2>Cart details</h2>
			<div id="product-details">
				<div class="header">
					<id>Id</id>				
					<name>Product name</name>
					<price>Price</price>
					<quantity>Quantity</quantity>
					<total>Total</total>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/jsp/sales/templates.jsp" %>

