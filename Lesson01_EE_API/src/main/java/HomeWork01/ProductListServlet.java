package HomeWork01;

import HomeWork01.Persist.Product;
import HomeWork01.Persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductList", urlPatterns = "/ProductList")

public class ProductListServlet extends HttpServlet{
    private ProductRepository productRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        List<Product> products=productRepository.findAll();
        resp.getWriter().println("<table>");
        for (int i = 0; i <products.size() ; i++) {
            resp.getWriter().println("<tr height=\"30\">");
            resp.getWriter().println("<td valign=\"top\">"+products.get(i).getId()+"</td>");
            resp.getWriter().println("<td valign=\"top\">"+products.get(i).getTitle()+"</td>");
            resp.getWriter().println("<td valign=\"top\">"+products.get(i).getCost()+"</td>");
            resp.getWriter().println("</tr>");

        }
        resp.getWriter().println("</table>");
    }

    @Override
    public void init() throws ServletException {
        productRepository=(ProductRepository) getServletContext().getAttribute("ProductRepository");
    }
}
