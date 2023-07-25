package controrler;

import appconfig.AppConfig;
import model.Bill;
import model.Cart;
import model.User;
import service.*;
import untils.ValidatesUntils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "BillServlet", urlPatterns = "/bill")
public class BillServlet extends HttpServlet {
    private ICartService iCartService;
    private ICartItemService iCartItemService;
    private IBillServlet billServlet = new BillServiceMysql();

    @Override
    public void init(ServletConfig config) throws ServletException {
        iCartService = new CartService();
        iCartItemService = new CartItemService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login");
            return;
        }

        Cart cart = iCartService.getCartById(user.getId());

        req.setAttribute("cart", cart);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(AppConfig.VIEW_FRONTEND + "bill.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                break;
            default:
                savePayment(req, resp);
                break;
        }
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        req.setCharacterEncoding("UTF-8");
//        super.service(req, resp);
//    }

    private void savePayment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Bill bill = new Bill();
        List<String> errors = new ArrayList<>();

        validateName(req, bill, errors);
        validateAddress(req, bill, errors);
        validatePhone(req, bill, errors);
        validateEmail(req, bill, errors);
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/login");
            return;
        }
        Cart cart = iCartService.getCartById(user.getId());
        req.setAttribute("cart", cart);
        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/frontend/payment.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            billServlet.save(bill);
            deleteCart(cart.getId() ,req, resp);
            req.setAttribute("bill", bill);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/frontend/bill.jsp");
            requestDispatcher.forward(req, resp);
        }

    }

    private void deleteCart( long id, HttpServletRequest req, HttpServletResponse resp) {
        iCartItemService.deleteIdCart(id);
        iCartService.remote(id);
    }


    private void validateName(HttpServletRequest req, Bill bill, List<String> errors) throws UnsupportedEncodingException {
        String name = req.getParameter("name");
        if (!ValidatesUntils.isValidName(name)) {
            errors.add("Tên không hợp lệ. Vui lòng nhập lại");
        }
        bill.setName(name);
    }

    private void validateAddress(HttpServletRequest req, Bill bill, List<String> errors) {
        String address = req.getParameter("address");
        if (!ValidatesUntils.isValidAddress(address)) {
            errors.add("Địa chỉ không hợp lệ. Vui lòng nhập lại");
        }
        bill.setAddress(address);
    }

    private void validatePhone(HttpServletRequest req, Bill bill, List<String> errors) {
        String phone = req.getParameter("phone");
        if (!ValidatesUntils.isValidPhone(phone)) {
            errors.add("Số điện thoại không hợp lệ. Không được có chữ và gồm 10 số");
        }
        bill.setPhone(phone);
    }

    private void validateEmail(HttpServletRequest req, Bill bill, List<String> errors) {
        String email = req.getParameter("email");
        if (!ValidatesUntils.isValidEmail(email)) {
            errors.add("Email không hợp lệ. Vui lòng nhập lại");
        }
        bill.setEmail(email);
    }
}
