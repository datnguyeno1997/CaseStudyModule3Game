package controrler;


import appconfig.AppConfig;
import model.Pageable;
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

@WebServlet(name = "Product_detailServlet", urlPatterns = "/product")
public class Product_detailServlet extends HttpServlet {
    private IProductService productService;
    private ShopServlet shopServlet;

    @Override
    public void init() throws ServletException {
        productService = new ProductServiceMysql();
        shopServlet = new ShopServlet();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long id = Long.parseLong(req.getParameter("id"));
        Product product = productService.findById(id);
        req.setAttribute("p", product);
        Pageable pageable = new Pageable();
        shopServlet.readPageable(req,pageable);
        List<Product> productList = productService.findProducts(pageable);
        req.setAttribute("products", productList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(AppConfig.VIEW_FRONTEND + "product-details.jsp");
        requestDispatcher.forward(req, resp);

    }
}
