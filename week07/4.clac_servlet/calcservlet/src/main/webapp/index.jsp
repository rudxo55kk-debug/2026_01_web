<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>계산기 JSP</title>
	<style>
		body {
			font-family: "Malgun Gothic", sans-serif;
			margin: 30px;
		}

		h1 {
			margin-bottom: 30px;
		}

		.calc-form {
			display: flex;
			align-items: center;
			gap: 8px;
		}

		.calc-form input,
		.calc-form select,
		.calc-form button {
			height: 32px;
			font-size: 24px;
			padding: 2px 8px;
			box-sizing: border-box;
		}

		.calc-form input {
			width: 160px;
		}
	</style>
</head>
<body>
	<h1>계산기 JSP</h1>

	<form class="calc-form" method="post" action="">
		<input type="number" name="num1" required>

		<select name="op" required>
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*" selected>*</option>
			<option value="/">/</option>
		</select>

		<input type="number" name="num2" required>
		<button type="submit">실행</button>
	</form>
</body>
</html>
