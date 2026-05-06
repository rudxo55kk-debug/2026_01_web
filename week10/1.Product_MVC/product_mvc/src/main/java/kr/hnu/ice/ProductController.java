package kr.hnu.ice;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductController", urlPatterns = {"/products", "/product"})
public class ProductController extends HttpServlet {
    private ProductService service;

    @Override
    public void init() {
        service = new ProductService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        String view;

        if ("/product".equals(path)) {
            view = info(request, response);
        } else {
            view = list(request, response);
        }

        if (view != null) {
            request.getRequestDispatcher(view).forward(request, response);
        }
    }

    private String list(HttpServletRequest request, HttpServletResponse response) {
        List<Product> products = service.findAll();
        request.setAttribute("products", products);
        return "/productList.jsp";
    }

    private String info(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        if (id == null || id.trim().isEmpty()) {
            response.sendRedirect(request.getContextPath() + "/products");
            return null;
        }

        Product product = service.find(id);
        request.setAttribute("product", product);
        if (product == null) {
            request.setAttribute("error", "Product not found.");
        }

        return "/productInfo.jsp";
    }
}
