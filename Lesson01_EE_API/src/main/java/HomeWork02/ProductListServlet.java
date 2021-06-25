package HomeWork02;

import HomeWork02.Persist.Product;
import HomeWork02.Persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ProductList02", urlPatterns = "/ProductList02/*")

public class ProductListServlet extends HttpServlet {
    private ProductRepository productRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter wr = resp.getWriter();
        if (req.getPathInfo() == null) {
            List<Product> products = productRepository.findAll();

            resp.getWriter().println("<table>");
            wr.println("<tr height=\"30\">");
            wr.println("<td valign=\"top\">\"ID\"</td>");
            wr.println("<td valign=\"top\">\"Наименование\"</td>");
            wr.println("<td valign=\"top\">\"Цена\"</td>");
            wr.println("</tr>");
            for (int i = 0; i < products.size(); i++) {
                String uid = products.get(i).getId().toString();
                String uid2 = req.getContextPath() + req.getServletPath() + "/" + uid;
                wr.println("<tr height=\"30\">");
                wr.println("<td valign=\"top\">" + products.get(i).getId() + "</td>");


                wr.println("<td valign=\"top\">" +
                        "<a href='" + uid2 + "'>" + products.get(i).getTitle() + "</a>"
                        + "</td>");
                wr.println("<td valign=\"top\">" + products.get(i).getCost() + "</td>");
                wr.println("</tr>");

            }
            resp.getWriter().println("</table>");
        } else {
            String pathInfo = req.getPathInfo();
            String idInfo = StaticPharseService.removeFirstChar(pathInfo);
            Long ParseId = Long.parseLong(idInfo);
            Product product = productRepository.findByID(ParseId);
            wr.println(product.getId() + "\n" + product.getTitle() + "\n" + product.getCost() + "\n\r");
            wr.println("<p>" +
                    "<a href='" + req.getContextPath() + req.getServletPath() + "'> Вернуться в корзину </a>" +
                    "</p>");
        }
    }

    @Override
    public void init() throws ServletException {
        productRepository = (ProductRepository) getServletContext().getAttribute("ProductRepository");
    }


}
