<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="randomNumber.jsp" %>
<%--
  JSP 종합 예제
  - 선언(필드/메서드), 참조, include 지시어, 스크립트릿, 반복문 출력
--%>
<%!
    int num1 = 20;

    int clac(int num2) {
        return num1 + num2;
    }

    String[] subjects = {"HTML", "CSS", "JavaScript", "JSP", "Servlet"};
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP Total</title>
</head>
<body>
    <h1>JSP Total 예제</h1>

    <%
        int result = clac(num2);
    %>

    <p>num1 (필드): <%= num1 %></p>
    <p>num2 (랜덤): <%= num2 %></p>
    <p>clac(num2) 결과: <strong><%= result %></strong></p>

    <h2>과목 목록</h2>
    <ul>
    <% for (String subject : subjects) { %>
        <li><%= subject %></li>
    <% } %>
    </ul>
</body>
</html>
