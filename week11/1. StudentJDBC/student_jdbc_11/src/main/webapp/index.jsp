<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<title>Redirect</title>
	<script>
		location.replace('<%= request.getContextPath() %>/student?action=list');
	</script>
</head>
<body>
<noscript>
	<a href="<%= request.getContextPath() %>/student?action=list">학생 목록으로 이동</a>
</noscript>
</body>
</html>
