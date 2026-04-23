<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");

    String num1Param = request.getParameter("num1");
    String num2Param = request.getParameter("num2");
    String op = request.getParameter("op");

    Double result = null;
    String errorMessage = null;

    try {
        double num1 = Double.parseDouble(num1Param);
        double num2 = Double.parseDouble(num2Param);

        if ("+".equals(op)) {
            result = num1 + num2;
        } else if ("-".equals(op)) {
            result = num1 - num2;
        } else if ("*".equals(op)) {
            result = num1 * num2;
        } else if ("/".equals(op)) {
            if (num2 == 0) {
                errorMessage = "0으로 나눌 수 없습니다.";
            } else {
                result = num1 / num2;
            }
        } else {
            errorMessage = "지원하지 않는 연산자입니다.";
        }
    } catch (Exception e) {
        errorMessage = "숫자를 올바르게 입력해주세요.";
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

<% if (errorMessage != null) { %>
    <p><strong>오류:</strong> <%= errorMessage %></p>
<% } else { %>
    <p><%= num1Param %> <%= op %> <%= num2Param %> = <strong><%= result %></strong></p>
<% } %>

<a href="index.jsp">다시 계산하기</a>
</body>
</html>
