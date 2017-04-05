<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="ru_RU" />
<fmt:bundle basename="resources.pagecontent" prefix = "label." >
<html><head>
<title><fmt:message key="title" /></title>
</head>
<body>
<fmt:message key="welcome" />
<br/>
<fmt:message key="footer.copyright" />
</body></html>
</fmt:bundle>