
날짜: 2026-05-14

학습 목표
- 기존 `if` 체인으로 구현된 액션 분기 로직을 `switch`문으로 리팩터링하여 가독성 및 확장성을 개선한다.

상세 변경 내용
- 대상 메서드: `service(HttpServletRequest req, HttpServletResponse resp)`
- 변경 전: 여러 개의 `if ("xxx".equals(action)) { ... return; }` 형태로 분기
- 변경 후:
  - `action` 파라미터가 `null` 또는 빈 문자열이면 기본값으로 `list`를 할당
  - `switch(action)`로 각 액션을 `case`로 분기하여 `list`, `insert`, `edit`, `update`, `delete`를 처리
  - `default`는 `list` 동작을 수행
  - 각 분기에서 `return` 대신 `break` 사용 후 메서드 끝에서 `return` 처리(흐름이 더 명확함)

왜 이렇게 변경했나 (이점)
- 가독성: 연속된 `if`-`return` 구문보다 `switch`가 동작별로 블록이 명확하여 읽기 쉬움
- 유지보수: 새로운 액션을 추가할 때 `case`만 추가하면 되어 확장성이 좋음
- 의도 명시: 기본 동작(`list`)이 명확히 드러남

변경된 파일
- 코드: [2026_01_web/week11/1.%20StudentJDBC/student_jdbc_11/src/main/java/kr/hun/ice/student/StudentController.java](2026_01_web/week11/1.%20StudentJDBC/student_jdbc_11/src/main/java/kr/hun/ice/student/StudentController.java#L1)

테스트 및 검증 방법
1) Maven 빌드 (프로젝트 루트에서 실행):

```bash
mvn -f 2026_01_web/week11/1.\ StudentJDBC/student_jdbc_11/pom.xml clean package
```

2) 생성된 WAR 또는 프로젝트를 Tomcat 등의 서블릿 컨테이너에 배포 후 브라우저에서 동작 확인
  - 예: `/student?action=list`, `/student?action=insert` 등으로 페이지 이동 및 동작 확인

3) 간단한 확인 절차
  - `action` 파라미터를 비워서 기본 리스트 동작이 나오는지 확인
  - 각 액션별(삽입, 수정, 삭제) 동작이 정상적으로 수행되는지 확인

추가 권장 사항
- 코드 스타일 일관성 유지: 팀 스타일 가이드에 따라 `switch` 블록의 들여쓰기와 예외 처리 규칙을 적용
- 단위 테스트/통합 테스트 추가: 서비스 레이어 또는 컨트롤러 행위를 검증하는 테스트 추가 고려

문의 또는 테스트를 원하시면, 어느 형태로 확인해드릴지 알려주세요 (로컬 빌드 실행 / Tomcat 배포 등).

