<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.net.URLEncoder" %>
<%
    request.setCharacterEncoding("UTF-8");

    String num1Param = request.getParameter("num1");
    String num2Param = request.getParameter("num2");
    String op = request.getParameter("op");

    Double result = null;
    String errorMessage = null;

    if (num1Param != null && num2Param != null && op != null) {
        try {
            double num1 = Double.parseDouble(num1Param);
            double num2 = Double.parseDouble(num2Param);

            if ("+".equals(op)) {
                result = num1 + num2;
            } else if ("-".equals(op)) {
                result = num1 - num2;
            } else if ("*".equals(op)) {
                result = num1 * num2;
            } else if ("/".equals(op)) {
                if (num2 == 0) {
                    errorMessage = "0으로 나눌 수 없습니다.";
                } else {
                    result = num1 / num2;
                }
            } else {
                errorMessage = "지원하지 않는 연산자입니다.";
            }
        } catch (Exception e) {
            errorMessage = "숫자를 올바르게 입력해주세요.";
        }
    } else {
        errorMessage = "입력값이 없습니다.";
    }

    String encodedNum1 = URLEncoder.encode(num1Param != null ? num1Param : "", "UTF-8");
    String encodedNum2 = URLEncoder.encode(num2Param != null ? num2Param : "", "UTF-8");
    String encodedOp = URLEncoder.encode(op != null ? op : "", "UTF-8");
    String encodedResult = URLEncoder.encode(result != null ? String.valueOf(result) : "", "UTF-8");
    String encodedError = URLEncoder.encode(errorMessage != null ? errorMessage : "", "UTF-8");

    String query = "num1Param=" + encodedNum1
        + "&num2Param=" + encodedNum2
        + "&op=" + encodedOp
        + "&result=" + encodedResult
        + "&errorMessage=" + encodedError;

    request.getRequestDispatcher("result.jsp?" + query).forward(request, response);
    return;
%>
