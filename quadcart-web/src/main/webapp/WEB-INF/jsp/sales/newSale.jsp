<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp"%>
<div id="outer-wrapper">
	<div id="left-pane" class="clearfix">

		<form method="get" action="/search" id="search">
			<input name="q" type="text" size="40" value='Search products...' onfocus="if(this.value=='Search products...'){this.value='';}" onblur="if(this.value==''){this.value='Search products...';}" />
		</form>

		<br/>

		<div id="products">
			<ul class="product-list">
				<c:forEach begin="1" end="12" var="i">
				<li>
					<product class="product-view">
						<header>
							<h1 class="product-header">#${i}. Product name</h1>
						</header>
						<div>
							<a href="#" title="Product details"><img src="<c:url value="/statics/images/product-image.png" />" alt="product details."></a>
						</div>
						<div class="product-details">
						<dl>
							<dd>XYZ Industries</dd>
						</dl>
						<dl>
							<dt>Price:</dt>
							<dd>1234.56</dd>
						</dl>
						</div>
						<div class="clear"></div>
					</product>
				</li>
				</c:forEach>
			</ul>
		</div>
	</div>

	<div id="right-pane">
		<div id="cart">
		<h2>Cart details</h2>
		</div>
	</div>
</div>
