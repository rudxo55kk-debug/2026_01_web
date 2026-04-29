20210586 김경태

# week09 학습 정리

## 2026-04-29

오늘 진행한 내용 요약:

- `2.jstl_exam/jstl_09` 프로젝트 생성 및 `index.jsp` 작성
  - JSTL 예제 추가: `c:set`, `c:if`, `c:choose`, `c:forEach`, `c:forTokens`
  - EL(Expression Language) 출력 예제 병행 작성
- 문자열 배열(`fruits`) 추가 및 `c:forEach`로 출력 구현
- `nums` 배열 처리 실험: EL 배열 리터럴 `${[1,2,3,4,5]}` 적용 시 Tomcat EL 파서 문제(호환성) 발생 가능성 확인
  - 호환성 문제 해결을 위해 `fn:split` 대체안 사용 가능함(필요 시 적용)
- `index.jsp`의 중복 HTML 제거 및 문법 정리(500 내부 서버 오류 원인 제거)

파일 위치 및 참고:
- `week09/2.jstl_exam/jstl_09/src/main/webapp/index.jsp`

---

*작성일: 2026-04-29*
