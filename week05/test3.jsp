<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>JSP 기본 예제</title>
    <style>
        body {
            font-family: "Malgun Gothic", sans-serif;
            margin: 24px;
            line-height: 1.7;
        }
        .box {
            border: 1px solid #d9d9d9;
            padding: 16px;
            border-radius: 8px;
            background: #fafafa;
        }
        h1 {
            color: #0b4f6c;
        }
    </style>
</head>
<body>
    <h1>JSP 관련 내용 정리</h1>

    <div class="box">
        <p>1) JSP는 HTML 안에 Java 코드를 포함해 동적인 웹 페이지를 만들 수 있습니다.</p>
        <p>2) 지시어(Directive) 예시: page, include, taglib</p>
        <p>3) 표현식(Expression) 예시: 현재 시간 = <%= LocalDateTime.now() %></p>
        <p>4) 내장 객체 예시: 요청 방식 = <%= request.getMethod() %></p>
    </div>

    <p>VS Code에서 JSP 파일을 작성한 뒤, Tomcat 같은 서버에서 실행하면 결과를 확인할 수 있습니다.</p>
</body>
</html>
