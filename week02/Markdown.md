# MarkDown 문서생성하기

## MarkDown 문서 형식의 제안

Markdown은 2004년 존 그루버(John Gruber)가 아론 스워츠(Aaron Swartz)와 함께 만든 마크업 언어입니다. Gruber의 블로그 "Daring Fireball"에서 처음 발표되었고, "읽기 쉽고 쓰기 쉬운" 문서 형식에 중점을 두었습니다.

Markdown은 간단한 텍스트 기반 문법으로, 아래처럼 읽기 쉽고 쓰기 쉬운 문서 작성을 돕습니다.

- **제목**은 `#` 기호로 표시합니다.
- **강조**는 `*기울임*` 또는 `**굵게**`로 표시합니다.
- **목록**은 `-` 또는 `*` 로 만듭니다.
- **표**는 `|`와 `-`를 사용해 구성합니다.

## MarkDown 주요 문법

### 제목
```markdown
# 제목1
## 제목2
### 제목3
```

### 강조
```markdown
*기울임* 또는 _기울임_
**굵게** 또는 __굵게__
~~취소선~~
```

### 목록
```markdown
- 순서 없는 목록 1
- 순서 없는 목록 2

1. 순서 있는 목록 1
2. 순서 있는 목록 2
```

### 링크와 이미지
```markdown
[GitHub](https://github.com)

![이미지 설명](https://via.placeholder.com/150)
```

### 코드 블록
```markdown
```java
// 자바 코드 예시
public class Hello {
  public static void main(String[] args) {
    System.out.println("Hello, Markdown!");
  }
}
```
```

### 인라인 코드
```markdown
`printf("Hello");`
```

## 예제

아래는 마크다운으로 작성된 예시 문장입니다.

> **중요:** 마크다운은 읽기 쉽고 관리하기 쉬운 문서 형식을 제공합니다.

- 첫 번째 항목
- 두 번째 항목
  - 서브 항목

## 이번 학기 시간표

| 요일 | 시간 | 과목 |
|------|------|------|
| 월요일 | 오전 10시 ~ 11시 50분 | 자바프로그래밍 |
| 월요일 | 오후 3시 ~ 4시 50분 | 이산수학 |
| 화요일 | 오후 3시 ~ 4시 50분 | 이산수학 |
| 수요일 | 오전 10시 ~ 11시 50분 | 웹 프로그래밍 |
| 수요일 | 오후 3시 ~ 4시 50분 | 자바프로그래밍(실습) |
| 목요일 | 오후 3시 ~ 4시 50분 | 웹프로그래밍 |
| 금요일 | 휴강 | - |

## GFM 사용과 샘플

GitHub Flavored Markdown(GFM)은 GitHub에서 확장된 기능을 제공합니다.

### 소스코드 블록 (Java 언어)

```java
// Java 언어로 된 코드 블록 예시
public class Schedule {
  public static void main(String[] args) {
    System.out.println("이번 학기 시간표를 확인하세요.");
  }
}
```

### 수식 (GitHub에서는 기본적으로 렌더링되지 않음)

인라인 수식 예시: `$a^2 + b^2 = c^2$`

블록 수식 예시:

```markdown
$$
E = mc^2
$$
```

> ⚠️ GitHub에서는 수식 렌더링이 기본적으로 지원되지 않지만, 위와 같이 작성하면 다른 수식 지원 도구와 함께 사용할 수 있습니다.
