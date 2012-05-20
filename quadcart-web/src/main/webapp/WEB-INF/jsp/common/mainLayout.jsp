<%@ include file="/WEB-INF/jsp/common/tagLibs.jsp" %>
<html>
<head>
    <title><spring:message code="title" /></title>
    <tiles:insertAttribute name="commonIncludes" />
</head>
<body>
	<div id="container">
	    <div id="header">
	       <tiles:insertAttribute name="header" />
	    </div>
	    <div id="content">
	       <tiles:insertAttribute name="body" />
	    </div>
	    <div id="footer">
	       <tiles:insertAttribute name="footer" />
	    </div>
    </div>
</body>
</html>