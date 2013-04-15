<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp"%>
<ul class="product-list">
	<c:choose>
	  <c:when test="${empty searchResult}">
	  	<li class="products-empty"><spring:message code="no.products.found" /></li>
	  </c:when>
	  <c:otherwise>
		<c:forEach items="${searchResult}" var="product" varStatus="status">
			<li>
				<product class="product-view">
					<header>
						<h1 class="product-header">#${status.count}. ${product.name}</h1>
					</header>
					<div>
						<a href="#" title="Product details">
							<img src="<c:url value="/statics/images/product-image.png" />" alt="product details.">
						</a>
					</div>
					<div class="product-details">
						<dl>
							<dt><spring:message code="manufacturer.abbrevation" />: </dt>
							<dd>${product.manufacturer.name}</dd>
						</dl>
						<dl>
							<dt><spring:message code="product.price" />: </dt>
							<dd>${product.price}</dd>
						</dl>
					</div>
					<div class="clear"></div>
				</product>
			</li>
		</c:forEach>
	  </c:otherwise>
	</c:choose>
</ul>
