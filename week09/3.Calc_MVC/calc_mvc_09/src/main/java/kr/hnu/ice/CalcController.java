package kr.hnu.ice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

@WebServlet("/CalcControl")
public class CalcController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        Calculator calculator = new Calculator();
        try {
            BeanUtils.populate(calculator, req.getParameterMap());
        } catch (Exception e) {
            throw new ServletException("요청 파라미터를 Calculator에 매핑하지 못했습니다.", e);
        }

        double result = calculator.calc();

        req.setAttribute("calculator", calculator);
        req.setAttribute("result", result);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/calcResult.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
