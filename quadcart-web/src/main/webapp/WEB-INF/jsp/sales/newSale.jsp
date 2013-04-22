<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp"%>
<div id="outer-wrapper">
	<div id="left-pane" class="clearfix">

		<div id="search">
			<input name="q" type="text" size="40" placeholder="<spring:message code="search.products" />" id="searchbox" autocomplete="off" />
		</div>

		<br/>

		<div id="products">
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
<!-- 				<div>
					<id>121</id>
					<name>MRF</name>
					<price>200.00</price>
					<quantity><input type="text" maxlength="4" value="1" /></quantity>
					<total>600.00</total>
				</div>
 -->			</div>
		</div>
	</div>
</div>
