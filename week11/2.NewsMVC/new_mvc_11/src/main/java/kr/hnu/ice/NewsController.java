package kr.hnu.ice;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.commons.beanutils.BeanUtils;

@WebServlet(urlPatterns = {"/news.ice"})
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class NewsController extends HttpServlet {
    private NewsDAO newsDAO;

    @Override
    public void init() throws ServletException {
        newsDAO = new NewsDAO();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null || action.isEmpty()) {
            action = "listNews";
        }
        try {
            Method method = this.getClass().getMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            String view = (String) method.invoke(this, request, response);
            if (view != null) {
                if (view.startsWith("redirect:/")) {
                    response.sendRedirect(request.getContextPath() + view.substring("redirect:".length()));
                } else {
                    RequestDispatcher dispatcher = request.getRequestDispatcher(view);
                    dispatcher.forward(request, response);
                }
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    public String listNews(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<News> list = newsDAO.getAll();
        request.setAttribute("newsList", list);
        return "newsList.jsp";
    }

    public String getNews(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int aid = Integer.parseInt(request.getParameter("aid"));
        News news = newsDAO.getNews(aid);
        request.setAttribute("news", news);
        return "newsView.jsp";
    }

    public String addNews(HttpServletRequest request, HttpServletResponse response) throws Exception {
        News news = new News();
        BeanUtils.populate(news, request.getParameterMap());
        Part filePart = request.getPart("file");
        String fileName = getFilename(filePart);
        if (fileName != null && !fileName.isEmpty()) {
            File dir = new File("C:/xampp/tomcat/webapps/img");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            filePart.write(new File(dir, fileName).getAbsolutePath());
            news.setImg(fileName);
        }
        newsDAO.addNews(news);
        return "redirect:/news.ice?action=listNews";
    }

    public String editNews(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int aid = Integer.parseInt(request.getParameter("aid"));
        News news = newsDAO.getNews(aid);
        request.setAttribute("news", news);
        return "newsEdit.jsp";
    }

    public String updateNews(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int aid = Integer.parseInt(request.getParameter("aid"));
        String oldImg = request.getParameter("oldImg");
        Part filePart = request.getPart("file");
        String fileName = getFilename(filePart);
        String finalImg = oldImg;

        if (fileName != null && !fileName.isEmpty()) {
            File dir = new File("C:/xampp/tomcat/webapps/img");
            if (!dir.exists()) {
                dir.mkdirs();
            }
            filePart.write(new File(dir, fileName).getAbsolutePath());
            finalImg = fileName;
        }

        News news = new News();
        news.setAid(aid);
        news.setTitle(request.getParameter("title"));
        news.setContent(request.getParameter("content"));
        news.setImg(finalImg);
        newsDAO.updateNews(news);
        return "redirect:/news.ice?action=getNews&aid=" + aid;
    }

    public String delNews(HttpServletRequest request, HttpServletResponse response) throws Exception {
        int aid = Integer.parseInt(request.getParameter("aid"));
        newsDAO.delNews(aid);
        return "redirect:/news.ice?action=listNews";
    }

    public String getFilename(Part part) {
        String contentDisposition = part.getHeader("content-disposition");
        if (contentDisposition == null) {
            return "";
        }
        String[] items = contentDisposition.split(";");
        for (String item : items) {
            String trimmed = item.trim();
            if (trimmed.startsWith("filename")) {
                String fileName = trimmed.substring(trimmed.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
            }
        }
        return "";
    }
}
