<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSTL 기초 예제 (if / choose / forEach / forTokens) & EL 출력</title>
    <style>body{font-family:Arial,Helvetica,sans-serif;margin:20px} h2{color:#2a6f97} table{border-collapse:collapse;width:100%} td,th{border:1px solid #ccc;padding:8px}</style>
</head>
<body>
    <h2>1. 변수 설정 (JSTL)</h2>
    <c:set var="name" value="김경태" />
    <c:set var="age" value="${20}" />
    <c:set var="score" value="${85.5}" />
    <c:set var="tokens" value="apple,banana,kiwi" />
    <c:set var="numsStr" value="1,2,3,4,5" />
    <c:set var="fruitsStr" value="orange,pear,grape,melon" />
    <c:set var="nums" value="${fn:split(numsStr, ',')}" />
    <c:set var="fruits" value="${fn:split(fruitsStr, ',')}" />

    <h2>2. JSTL 태그로 출력 (왼쪽) / EL로 출력 (오른쪽)</h2>
    <table>
        <tr>
            <th>JSTL 태그 사용</th>
            <th>Expression Language (EL) 사용</th>
        </tr>
        <tr>
            <td>
                <strong>변수 출력</strong><br>
                이름: <c:out value="${name}" /><br>
                나이: <c:out value="${age}" /><br>
                점수: <c:out value="${score}" />
            </td>
            <td>
                <strong>EL 출력</strong><br>
                이름: ${name} <br>
                나이: ${age} <br>
                점수: ${score}
            </td>
        </tr>
        <tr>
            <td>
                <strong>조건문: &lt;c:if&gt;</strong><br>
                <c:if test="${age ge 20}">성인입니다.</c:if>
                <c:if test="${age lt 20}">미성년자입니다.</c:if>
            </td>
            <td>
                <strong>EL 조건식 (삼항 연산자)</strong><br>
                <c:out value="${age ge 20 ? '성인입니다.' : '미성년자입니다.'}" />
            </td>
        </tr>
        <tr>
            <td>
                <strong>선택문: &lt;c:choose&gt;</strong><br>
                <c:choose>
                    <c:when test="${score ge 90}">등급: A</c:when>
                    <c:when test="${score ge 80}">등급: B</c:when>
                    <c:otherwise>등급: C 이하</c:otherwise>
                </c:choose>
            </td>
            <td>
                <strong>EL로 등급 계산</strong><br>
                <c:out value="${score ge 90 ? '등급: A' : (score ge 80 ? '등급: B' : '등급: C 이하')}" />
            </td>
        </tr>
        <tr>
            <td>
                <strong>반복: &lt;c:forEach&gt;</strong><br>
                <c:forEach var="n" items="${nums}" varStatus="st">
                    <c:out value="${st.index + 1}" />) 값: <c:out value="${n}" /><br />
                </c:forEach>
            </td>
            <td>
                <strong>EL로 목록 출력 (fn:join 사용)</strong><br>
                <c:out value="${fn:join(nums, ', ')}" />
            </td>
        </tr>
        <tr>
            <td>
                <strong>문자열 배열 + &lt;c:forEach&gt;</strong><br>
                <c:forEach var="f" items="${fruits}" varStatus="s">
                    <c:out value="${s.index + 1}" />) <c:out value="${f}" /><br />
                </c:forEach>
            </td>
            <td>
                <strong>EL로 문자열 배열 출력</strong><br>
                <c:out value="${fn:join(fruits, ', ')}" />
            </td>
        </tr>
        <tr>
            <td>
                <strong>토큰 분리: &lt;c:forTokens&gt;</strong><br>
                <c:forTokens items="${tokens}" delims="," var="fruit">
                    - <c:out value="${fruit}" /><br />
                </c:forTokens>
            </td>
            <td>
                <strong>EL로 토큰 표현</strong><br>
                <c:out value="${fn:join(fn:split(tokens, ','), ', ')}" />
            </td>
        </tr>
    </table>

    <h2>3. 요약</h2>
    <ul>
        <li>&lt;c:set&gt;: 변수 설정</li>
        <li>&lt;c:if&gt; / &lt;c:choose&gt;: 조건 처리</li>
        <li>&lt;c:forEach&gt;: 리스트 반복</li>
        <li>&lt;c:forTokens&gt;: 구분자 기반 토큰 반복</li>
        <li>EL: ${'$'}{...} 을 사용해 동일한 변수값을 간결하게 출력할 수 있음</li>
    </ul>

</body>
</html>
