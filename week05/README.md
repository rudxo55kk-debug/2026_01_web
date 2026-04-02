20210586 김경태

# week05 학습 정리

## 2026년 4월 1일
### 오늘 학습한 JSP 파일 요약
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

## 2026년 4월 2일
### 오늘 학습한 내용
- Java 기본 문법을 정리하며 변수 타입(int, double, char, boolean) 사용과 출력 흐름을 실습함.
- 배열 처리 연습을 진행함.
  - int 배열로 점수 데이터를 순회하며 총점과 평균을 계산함.
  - String 배열에 과목명을 저장하고 인덱스 기반 반복문으로 출력함.
- 문자열 처리 방식 2가지를 비교함.
  - 문자열 리터럴과 new String 생성 방식 확인
  - StringBuilder append 체이닝으로 문장 조합 후 toString으로 변환
- Scanner 입력을 받아 기준값(limit) 미만의 2단부터 9단 배수를 반복문으로 출력하는 로직을 구현함.
- 2000 이하 완전수 탐색 로직을 구현함.
  - 약수 판별과 합산을 분리한 메서드로 구성
  - 완전수 조건(sum == n)을 함수로 검증하고 결과를 출력
