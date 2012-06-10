<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset='utf-8' />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<title><spring:message code="title" /></title>
    <tiles:insertAttribute name="commonIncludes" />
</head>
<body>
	<div id="wrapper">
	
	<div id="header" class="true clearfix">
		<tiles:insertAttribute name="header" />
	</div>
		
	<div class="site clearfix">
	<div id="site-container" class="container">
		<tiles:insertAttribute name="body" />
	</div>
	</div>

	<div id="footer">
    	<tiles:insertAttribute name="footer" />
    </div>
	
	</div>
</body>
</html>
