package kr.hun.ice.student;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class StudentController extends HttpServlet {
    private StudentDAO dao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        dao = new StudentDAO();
        String url = getServletContext().getInitParameter("jdbcUrl");
        if (url != null) {
            String user = getServletContext().getInitParameter("dbUser");
            String pass = getServletContext().getInitParameter("dbPass");
            try {
                dao.connect(url, user, pass);
            } catch (Exception e) {
                writeInitError(e);
                throw new ServletException("Unable to connect to DB (overridden)", e);
            }
        } else {
            try {
                dao.connect();
            } catch (Exception e) {
                writeInitError(e);
                throw new ServletException("Unable to connect to DB (DAO defaults)", e);
            }
        }
    }

    private void writeInitError(Exception e) {
        try {
            String tmp = System.getProperty("java.io.tmpdir");
            java.io.File f = new java.io.File(tmp, "student_servlet_init_error.log");
            try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(f, true))) {
                pw.println("----- " + new java.util.Date() + " -----");
                e.printStackTrace(pw);
            }
        } catch (Exception ignore) {
        }
    }

    @Override
    public void destroy() {
        if (dao != null) dao.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        service(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if ("POST".equalsIgnoreCase(req.getMethod())) {
                req.setCharacterEncoding("UTF-8");
            }
            resp.setCharacterEncoding("UTF-8");

            String action = req.getParameter("action");
            if (action == null || action.isEmpty()) {
                action = "list";
            }
            switch (action) {
                case "list":
                    list(req, resp);
                    break;
                case "insert":
                    insert(req, resp);
                    break;
                case "edit":
                    edit(req, resp);
                    break;
                case "update":
                    update(req, resp);
                    break;
                case "delete":
                    delete(req, resp);
                    break;
                default:
                    list(req, resp);
            }
            return;
        } catch (Exception e) {
            writeRuntimeError(e, req);
            if (e instanceof ServletException) throw (ServletException) e;
            if (e instanceof IOException) throw (IOException) e;
            throw new ServletException(e);
        }
    }

    private void writeRuntimeError(Exception e, HttpServletRequest req) {
        try {
            String tmp = System.getProperty("java.io.tmpdir");
            java.io.File f = new java.io.File(tmp, "student_servlet_runtime_error.log");
            try (java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(f, true))) {
                pw.println("----- " + new java.util.Date() + " -----");
                pw.println("Request: " + req.getMethod() + " " + req.getRequestURI() + "?" + req.getQueryString());
                e.printStackTrace(pw);
            }
        } catch (Exception ignore) {
        }
    }

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Student> students = dao.getAll();
            req.setAttribute("students", students);
            req.getRequestDispatcher("/studentInfo.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Student editStudent = dao.getById(id);
            List<Student> students = dao.getAll();
            req.setAttribute("editStudent", editStudent);
            req.setAttribute("students", students);
            req.getRequestDispatcher("/studentInfo.jsp").forward(req, resp);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void insert(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student s = new Student();
        try {
            BeanUtils.populate(s, req.getParameterMap());
            dao.insert(s);
            resp.sendRedirect(req.getContextPath() + "/student?action=list");
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ServletException("Failed to bind request parameters to Student", e);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student s = new Student();
        try {
            BeanUtils.populate(s, req.getParameterMap());
            dao.update(s);
            resp.sendRedirect(req.getContextPath() + "/student?action=list");
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ServletException("Failed to bind request parameters to Student", e);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            dao.delete(id);
            resp.sendRedirect(req.getContextPath() + "/student?action=list");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
