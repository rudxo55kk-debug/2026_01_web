<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>간단 계산기 2</title>
</head>
<body>
<h2>계산기 2</h2>

<form action="calc.jsp" method="get">
	<label for="num1">첫 번째 숫자:</label>
	<input type="number" id="num1" name="num1" step="any" required>

	<label for="op">연산자:</label>
	<select id="op" name="op" required>
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="*">*</option>
		<option value="/">/</option>
	</select>

	<label for="num2">두 번째 숫자:</label>
	<input type="number" id="num2" name="num2" step="any" required>

	<button type="submit">계산</button>
</form>

</body>
</html>
