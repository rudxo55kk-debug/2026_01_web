<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Student Info</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid #ccc; padding: 8px; }
    </style>
</head>
<body>
<h1>학생 목록</h1>

<form action="student" method="post" accept-charset="UTF-8">
    <c:choose>
        <c:when test="${not empty editStudent}">
            <input type="hidden" name="action" value="update" />
            <input type="hidden" name="id" value="${editStudent.id}" />
        </c:when>
        <c:otherwise>
            <input type="hidden" name="action" value="insert" />
        </c:otherwise>
    </c:choose>
    이름: <input type="text" name="name" value="${editStudent.name}" />
    학교: <input type="text" name="univ" value="${editStudent.univ}" />
    생년월일: <input type="text" name="birthdate" placeholder="YYYY-MM-DD" value="${editStudent.birthdate}" />
    이메일: <input type="text" name="email" value="${editStudent.email}" />
    <c:choose>
        <c:when test="${not empty editStudent}">
            <button type="submit">수정</button>
            <a href="student?action=list">취소</a>
        </c:when>
        <c:otherwise>
            <button type="submit">추가</button>
        </c:otherwise>
    </c:choose>
</form>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>이름</th>
        <th>학교</th>
        <th>생년월일</th>
        <th>이메일</th>
        <th>비고</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="s" items="${students}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.univ}</td>
            <td>${s.birthdate}</td>
            <td>${s.email}</td>
            <td>
                <a href="student?action=edit&id=${s.id}" title="수정">&#9998;</a>
                <a href="student?action=delete&id=${s.id}" title="삭제" onclick="return confirm('해당 학생을 삭제할까요?');">&#128465;</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
