<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

    request.setAttribute("num1Param", num1Param);
    request.setAttribute("num2Param", num2Param);
    request.setAttribute("op", op);
    request.setAttribute("result", result);
    request.setAttribute("errorMessage", errorMessage);
    request.getRequestDispatcher("result.jsp").forward(request, response);
    return;
%>
