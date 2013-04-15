<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp"%>
<div id="outer-wrapper">
	<div id="left-pane" class="clearfix">

		<form method="get" action="#" id="search">
			<input name="q" type="text" size="40" placeholder="<spring:message code="search.products" />" id="searchbox" autocomplete="off" />
		</form>

		<br/>

		<div id="products">
			
		</div>
	</div>

	<!-- 
	<div id="right-pane">
		<div id="cart">
		<h2>Cart details</h2>
		</div>
	</div>
	 -->
</div>
