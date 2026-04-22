20210586 김경태

# week08 작업 요약

## 2026-04-22

### 작업 위치
- 1.HelloJsp/jsp_hello_08/src/main/webapp

### 오늘 작업 내용
- jspTotal.jsp 파일 생성
- randomNumber.jsp 파일 생성
- jspTotal.jsp에서 include 지시어로 randomNumber.jsp 포함
- 선언문에서 필드 num1 = 20 선언
- 선언문에서 clac(int num2) 메서드 구현 (num2는 인자)
- randomNumber.jsp에서 임의의 숫자 num2 생성
- jspTotal.jsp에서 clac(num2) 계산 결과 출력
- 선언문에서 String 배열 subjects 선언
- 본문에서 JSP 반복문으로 unordered list 출력
- Maven/Tomcat 서버 실행 후 JSP 페이지 동작 확인

### 확인 포인트
- jspTotal.jsp 실행 시 num1(20), 랜덤 num2, 계산 결과가 함께 출력됨
- subjects 배열 내용이 UL 목록으로 렌더링됨
- 서버 구동 상태에서 페이지 정상 응답 확인
