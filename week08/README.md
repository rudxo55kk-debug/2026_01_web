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

## 2026-04-23

### 작업 위치
- 2.CalcJsp/calc_jsp/src/main/webapp
- 3.CalcJsp2/calc_jsp2/src/main/webapp
- 4.CalcJsp3/calc_jsp3/src/main/webapp

### 오늘 작업 내용
- 2.CalcJsp에서 두 숫자와 연산자를 입력받는 계산기 폼/계산 로직 구성
- 3.CalcJsp2 프로젝트 생성 및 2.CalcJsp 내용 복사 후 프로젝트명 식별값 정리
- 3.CalcJsp2에서 계산 화면 분리: index.jsp(입력) -> calc.jsp(계산) -> result.jsp(출력)
- calc.jsp의 HTML 출력 로직을 result.jsp로 분리하고, result.jsp 안내 문구 추가
- 4.CalcJsp3 프로젝트 생성 및 계산기 기본 구조 구성
- 4.CalcJsp3에서 JSP forward 방식으로 result.jsp에 결과 전달 처리
- 4.CalcJsp3에서 request.setAttribute 방식 대신 JSP 파라미터 전달 방식으로 변경

### 확인 포인트
- calc.jsp에서 계산 후 result.jsp로 정상 이동/전달됨
- result.jsp에서 계산 결과 또는 오류 메시지가 정상 출력됨
- 0으로 나누기, 숫자 입력 오류 등 예외 케이스가 메시지로 처리됨
