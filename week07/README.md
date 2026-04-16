20210586 김경태

# week07 학습 정리

- 작성일: 2026-04-16

## 1) HelloWorld2 Servlet 실습 (3. helloworld_servlet)
- [week07/3. helloworld_servlet/helloworld2_servlet/src/main/java/HellowWorldSvl.java](week07/3.%20helloworld_servlet/helloworld2_servlet/src/main/java/HellowWorldSvl.java)에서 `@WebServlet` 기반 URL 매핑(`/hello2`)을 적용했다.
- `doGet`에서 현재 날짜/시간을 생성해 `getWriter()`로 HTML 응답을 직접 작성하는 흐름을 연습했다.
- `doPost`를 `doGet`으로 위임해 GET/POST 공통 처리 방식도 함께 확인했다.

## 2) Servlet 계산기 화면 구성
- [week07/4.clac_servlet/calcservlet/src/main/webapp/index.jsp](week07/4.clac_servlet/calcservlet/src/main/webapp/index.jsp)에 계산기 입력 폼을 구성했다.
- 숫자 2개 입력칸, 연산자 선택, 실행 버튼 형태로 화면을 맞췄다.

## 3) CalcServlet doGet 구현
- [week07/4.clac_servlet/calcservlet/src/main/java/CalcServlet.java](week07/4.clac_servlet/calcservlet/src/main/java/CalcServlet.java)에서 `num1`, `num2`, `op` 파라미터를 받아 연산하도록 구현했다.
- `+`, `-`, `*`, `/` 연산을 처리하고, 예외 상황(0으로 나누기, 숫자 형식 오류) 메시지도 출력하도록 했다.
- `getWriter()`로 HTML을 직접 작성해 계산 결과를 폼 하단에 출력하도록 구성했다.

## 4) WebServlet 어노테이션 적용
- [week07/4.clac_servlet/calcservlet/src/main/java/CalcServlet.java](week07/4.clac_servlet/calcservlet/src/main/java/CalcServlet.java)에 `@WebServlet("/clac")`를 추가해 URL 매핑을 설정했다.
- [week07/4.clac_servlet/calcservlet/src/main/webapp/WEB-INF/web.xml](week07/4.clac_servlet/calcservlet/src/main/webapp/WEB-INF/web.xml)을 Servlet 4.0 형식으로 맞춰 어노테이션 기반 동작과 호환되게 정리했다.

## 5) 소수점 계산 지원
- 입력 필드에 `step='any'`를 적용해 브라우저에서 소수점 입력이 가능하도록 수정했다.
- 서버 연산은 `Double.parseDouble` 기반으로 처리되어 소수점 계산이 정상 동작한다.

## 6) 오늘 학습 핵심
- Servlet에서 요청 파라미터를 받아 계산 로직을 수행하고, 응답 HTML을 직접 구성하는 흐름을 학습했다.
- JSP 화면과 Servlet 처리 로직의 역할을 분리해 웹 애플리케이션 구조를 연습했다.
