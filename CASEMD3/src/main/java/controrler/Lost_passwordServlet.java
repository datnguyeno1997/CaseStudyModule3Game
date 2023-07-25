package controrler;

import appconfig.AppConfig;
import model.Product;
import service.IProductService;
import service.ProductServiceMysql;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Lost_passwordServlet", urlPatterns = "/lost_password")
public class Lost_passwordServlet extends HttpServlet {
    private IProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductServiceMysql();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAll();

        req.setAttribute("products", products);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(AppConfig.VIEW_FRONTEND + "lost_password.jsp");
        requestDispatcher.forward(req, resp);

    }
}
