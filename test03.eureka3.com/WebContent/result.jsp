<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://test03.eureka3.com/tags/Result"
           prefix="result"%>

<!DOCTYPE html>
<html>

<head>

<meta http-equiv="Content-type" content="text/html; charset=utf-8">

<%@ include file="commonreference.jsp" %>

<title>
Insert title here
</title>
</head>

<body>

<div class="centerContents">

<%@ include file="commonheader.jsp" %>

<% String strCode = request.getParameter("pref_code"); %>
<result:Result condition="<%=strCode %>"/>

</div>

</body>

</html>