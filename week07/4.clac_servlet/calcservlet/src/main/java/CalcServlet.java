import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/clac")
public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");

        String num1Param = req.getParameter("num1");
        String num2Param = req.getParameter("num2");
        String op = req.getParameter("op");

        String resultText = "";

        if (num1Param != null && num2Param != null && op != null
                && !num1Param.trim().isEmpty() && !num2Param.trim().isEmpty()) {
            try {
                double num1 = Double.parseDouble(num1Param);
                double num2 = Double.parseDouble(num2Param);
                double result = 0;

                switch (op) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 == 0) {
                            resultText = "0으로 나눌 수 없습니다.";
                        } else {
                            result = num1 / num2;
                        }
                        break;
                    default:
                        resultText = "지원하지 않는 연산자입니다.";
                }

                if (resultText.isEmpty()) {
                    resultText = num1 + " " + op + " " + num2 + " = " + result;
                }
            } catch (NumberFormatException e) {
                resultText = "숫자를 올바르게 입력해주세요.";
            }
        }

        if (num1Param == null) {
            num1Param = "";
        }
        if (num2Param == null) {
            num2Param = "";
        }
        if (op == null || op.trim().isEmpty()) {
            op = "+";
        }

        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>계산기 JSP</title>");
        out.println("<style>");
        out.println("body { font-family: 'Malgun Gothic', sans-serif; margin: 30px; }");
        out.println("h1 { margin-bottom: 30px; }");
        out.println(".calc-form { display: flex; align-items: center; gap: 8px; }");
        out.println(".calc-form input, .calc-form select, .calc-form button { height: 32px; font-size: 24px; padding: 2px 8px; box-sizing: border-box; }");
        out.println(".calc-form input { width: 160px; }");
        out.println(".result { margin-top: 24px; font-size: 22px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>계산기 JSP</h1>");
        out.println("<form class='calc-form' method='get' action='clac'>");
        out.println("<input type='number' name='num1' value='" + num1Param + "' step='any' required>");
        out.println("<select name='op' required>");
        out.println("<option value='+' " + ("+".equals(op) ? "selected" : "") + ">+</option>");
        out.println("<option value='-' " + ("-".equals(op) ? "selected" : "") + ">-</option>");
        out.println("<option value='*' " + ("*".equals(op) ? "selected" : "") + ">*</option>");
        out.println("<option value='/' " + ("/".equals(op) ? "selected" : "") + ">/</option>");
        out.println("</select>");
        out.println("<input type='number' name='num2' value='" + num2Param + "' step='any' required>");
        out.println("<button type='submit'>실행</button>");
        out.println("</form>");

        if (!resultText.isEmpty()) {
            out.println("<div class='result'>결과: " + resultText + "</div>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
