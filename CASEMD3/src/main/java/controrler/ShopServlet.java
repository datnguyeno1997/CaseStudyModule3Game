package controrler;

import appconfig.AppConfig;
import model.Pageable;
import model.Product;
import model.ProductType;
import model.User;
import service.IProductService;
import service.IProductTypeService;
import service.ProductServiceMysql;
import service.ProductTypeServiceMysql;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShopServlet", urlPatterns = "/shop")
public class ShopServlet extends HttpServlet {
    private IProductService productService;
    private IProductTypeService productTypeService = new ProductTypeServiceMysql();
    @Override
    public void init() throws ServletException {
        productService = new ProductServiceMysql();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> productAction = productService.findAction();
        List<Product> productLogic = productService.findLogic();
        List<Product> productRacing = productService.findRacing();
        req.setAttribute("productAction", productAction);
        req.setAttribute("productLogic", productLogic);
        req.setAttribute("productRacing", productRacing);

        Pageable pageable = new Pageable();
        readPageable(req,pageable);

        productService.findProducts(pageable);
        User user = (User) req.getSession().getAttribute("user");


        List<Product> productList = productService.findProducts(pageable);
        req.setAttribute("products", productList);
        req.setAttribute("pageable", pageable);


        List<ProductType> productTypes = productTypeService.findAll();
        req.setAttribute("productTypes", productTypes);

        RequestDispatcher rs = req.getRequestDispatcher(AppConfig.VIEW_FRONTEND + "shop.jsp");
        rs.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    void readPageable(HttpServletRequest req, Pageable pageable) {
        String kw = "";
        if (req.getParameter("kw") != null){
            kw = req.getParameter("kw");

        }
        pageable.setKw(kw);
        int productType = -1;
        if (req.getParameter("product-type") != null){
            productType = Integer.parseInt(req.getParameter("product-type"));

        }
        pageable.setProductType(productType);
        int page = 1;
        if (req.getParameter("page") != null){
            page = Integer.parseInt(req.getParameter("page"));

        }
        pageable.setPage(page);
        int limit = 8;
        if (req.getParameter("limit") != null){
            limit = Integer.parseInt(req.getParameter("limit"));

        }
        pageable.setLimit(limit);
    }
}
