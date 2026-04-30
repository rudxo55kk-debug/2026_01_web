<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<meta charset="UTF-8">
</head>
<body>
<h2>Calc MVC</h2>
<form action="CalcControl" method="post">
	<label for="n1">n1</label>
	<input id="n1" name="n1" type="number" step="any" required>
	<br>
	<label for="n2">n2</label>
	<input id="n2" name="n2" type="number" step="any" required>
	<br>
	<label for="op">operator</label>
	<select id="op" name="op" required>
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="*">*</option>
		<option value="/">/</option>
	</select>
	<br>
	<button type="submit">calc</button>
</form>
</body>
</html>
