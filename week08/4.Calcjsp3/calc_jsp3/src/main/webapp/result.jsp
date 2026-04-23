<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");

    String num1Param = request.getParameter("num1Param");
    String num2Param = request.getParameter("num2Param");
    String op = request.getParameter("op");
    String result = request.getParameter("result");
    String errorMessage = request.getParameter("errorMessage");

    if (errorMessage != null && errorMessage.isEmpty()) {
        errorMessage = null;
    }
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
