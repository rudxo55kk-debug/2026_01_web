<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>계산 결과</title>
</head>
<body>
    <h2>계산 결과</h2>
    
    <!-- Calculator 빈 생성 -->
    <jsp:useBean id="calc" class="bean_exam.Calculator" />
    
    <!-- index.jsp에서 전달받은 값을 빈의 property에 설정 -->
    <jsp:setProperty name="calc" property="n1" param="n1" />
    <jsp:setProperty name="calc" property="n2" param="n2" />
    <jsp:setProperty name="calc" property="op" param="op" />
    
    <!-- 결과 출력 -->
    <table border="1">
        <tr>
            <td>첫 번째 숫자</td>
            <td><jsp:getProperty name="calc" property="n1" /></td>
        </tr>
        <tr>
            <td>연산자</td>
            <td><jsp:getProperty name="calc" property="op" /></td>
        </tr>
        <tr>
            <td>두 번째 숫자</td>
            <td><jsp:getProperty name="calc" property="n2" /></td>
        </tr>
        <tr>
            <td><strong>결과</strong></td>
            <td><strong><%= calc.calc() %></strong></td>
        </tr>
    </table>
    
    <br>
    <a href="index.jsp">다시 계산하기</a>
</body>
</html>
