<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp"%>
{"products": [<c:forEach items="${searchResult}" var="product" varStatus="status">
	{"id": ${status.count}, "name": "${product.name}", "manufacturerName": "${product.manufacturer.name}", "price": "${product.price}"}<c:if test="${!status.last}">,</c:if>
</c:forEach>
]}
