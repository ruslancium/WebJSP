<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html><head><title>Формат числа</title></head>
<body> <c:set var="currentNumber" value="118000"/>
<c:out value="Вывод формата числа : ${currentNumber}"/> <br/>
Формат (по умолчанию) : <fmt:formatNumber value="${currentNumber}" /><br/>
Процентный формат : <fmt:formatNumber value="${currentNumber}" type="percent"/><br/>
<fmt:setLocale value="be-BY"/>
Белорусские рубли : <fmt:formatNumber value="${currentNumber}" type="currency"/><br/>
<fmt:setLocale value="pl-PL"/>
Польская валюта :<fmt:formatNumber value="${currentNumber}" type="currency"/><br/>
Французская валюта :
<fmt:setLocale value="fr-FR"/>
<fmt:formatNumber value="${currentNumber}" type="currency"/><br/>
</body></html>