# week05 학습 정리

## 오늘 날짜
- 2026년 4월 1일

## 오늘 학습한 JSP 파일 요약
- `test.jsp`: VS Code에서 JSP를 작성하고 Tomcat 같은 서버에서 실행하는 기본 안내 문구를 작성함.
- `test2.jsp`: `test.jsp`와 유사한 형식으로 JSP 사용 예제를 추가 작성함.
- `test3.jsp`: JSP 핵심 개념을 실습 형태로 정리함.
  - page 지시어와 import 사용
  - 표현식 `<%= ... %>`으로 현재 시간 출력
  - 내장 객체 `request`로 요청 방식 확인

## 코드 스니펫 작성 요약
아래는 JSP 파일을 빠르게 시작할 때 사용할 수 있는 기본 스니펫 예시입니다.

```jsp
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>JSP 예제</title>
</head>
<body>
    <h1>JSP 시작</h1>
    <p>현재 서버 시간: <%= new java.util.Date() %></p>
    <p>요청 방식: <%= request.getMethod() %></p>
</body>
</html>
```

VS Code에서는 JSP 파일 편집 후, Tomcat 서버를 통해 실행 결과를 확인할 수 있습니다.
