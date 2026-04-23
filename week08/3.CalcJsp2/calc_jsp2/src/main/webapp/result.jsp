<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String num1Param = (String) request.getAttribute("num1Param");
    String num2Param = (String) request.getAttribute("num2Param");
    String op = (String) request.getAttribute("op");
    Double result = (Double) request.getAttribute("result");
    String errorMessage = (String) request.getAttribute("errorMessage");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>계산 결과</title>
</head>
<body>
<h2>계산 결과</h2>
<p>이파일은 result.jsp로 실행된 파일입니다.</p>

<% if (errorMessage != null) { %>
    <p><strong>오류:</strong> <%= errorMessage %></p>
<% } else { %>
    <p><%= num1Param %> <%= op %> <%= num2Param %> = <strong><%= result %></strong></p>
<% } %>

<a href="index.jsp">다시 계산하기</a>
</body>
</html>
