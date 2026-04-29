<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>계산기</title>
</head>
<body>
    <h2>간단한 계산기</h2>
    <form method="post" action="calc.jsp">
        <label for="n1">첫 번째 숫자:</label>
        <input type="number" id="n1" name="n1" step="any" required>
        <br><br>
        
        <label for="op">연산자:</label>
        <select id="op" name="op" required>
            <option value="">선택하세요</option>
            <option value="+">더하기 (+)</option>
            <option value="-">빼기 (-)</option>
            
            <option value="*">곱하기 (*)</option>
            <option value="/">나누기 (/)</option>
        </select>
        <br><br>
        
        <label for="n2">두 번째 숫자:</label>
        <input type="number" id="n2" name="n2" step="any" required>
        <br><br>
        
        <button type="submit">계산</button>
    </form>
</body>
</html>
