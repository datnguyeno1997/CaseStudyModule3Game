package controrler;

import appconfig.AppConfig;
import model.Cart;
import model.Product;
import model.User;
import service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    private IProductService productService;

    private ICartService iCartService;
    private ICartItemService iCartItemService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        iCartService = new CartService();
        iCartItemService = new CartItemService();
    }

    @Override
    public void init() throws ServletException {
        productService = new ProductServiceMysql();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "add":
                addToCartView(req,resp);
                break;
            case "update":
                updateCartView(req,resp);
                break;
            case "delete":
                deleteCartView(req,resp);
                break;
            default:
                showCartView(req,resp);
                break;
        }



    }

    private void updateCartView(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null){
            resp.sendRedirect("/login");
            return;
        }

        long idProduct = Long.parseLong(req.getParameter("id"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));


        Cart cart = iCartService.updateCartInfo(user.getId(), idProduct, quantity);
        req.setAttribute("cart", cart);
        req.getRequestDispatcher(AppConfig.VIEW_FRONTEND + "cart.jsp").forward(req,resp);

    }

    private void showCartView(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null){
            resp.sendRedirect("/login");
            return;
        }


        Cart cart = iCartService.getCartById(user.getId());
        req.setAttribute("cart", cart);
        req.getRequestDispatcher(AppConfig.VIEW_FRONTEND + "cart.jsp").forward(req,resp);


    }

    private void addToCartView(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        int idProduct = Integer.parseInt(req.getParameter("id"));
        int quantity = 1;
        if(req.getParameter("qty")!=null){
            quantity = Integer.parseInt(req.getParameter("qty"));
        }
        User user = (User) req.getSession().getAttribute("user");
        if (user == null){
            resp.sendRedirect("/login");
            return;
        }
        iCartService.addToCart(idProduct, quantity, user.getId());

        Cart cart = iCartService.getCartById(user.getId());
        req.setAttribute("cart", cart);
        req.getRequestDispatcher(AppConfig.VIEW_FRONTEND + "cart.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "add":
                addToCartView(req,resp);
                break;
            case "update":
                updateCartView(req,resp);
                break;
            case "delete":
                deleteCartView(req,resp);
                break;
            default:
                showCartView(req,resp);
                break;
        }

    }
    private void deleteCartView(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login");
            return;
        }
        int id = Integer.parseInt(req.getParameter("id"));

        iCartItemService.deleteCartItem(id);
//        req.getSession().setAttribute("messageDelete", "Xóa thành công");
        resp.sendRedirect("/cart");
    }
}