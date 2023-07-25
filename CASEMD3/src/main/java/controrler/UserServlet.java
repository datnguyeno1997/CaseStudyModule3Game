package controrler;

import appconfig.AppConfig;
import model.Role;
import model.User;
import service.IUserService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static dao.DbContext.getConnection;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action) {
            case "edit":
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(AppConfig.VIEW_DASHBOARD + "user/edit.jsp");
                requestDispatcher.forward(req, resp);
                break;
            default:
                RequestDispatcher rp = req.getRequestDispatcher(AppConfig.VIEW_DASHBOARD + "user/infor.jsp");
                rp.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "reset-password":
                //TBD
                RequestDispatcher rp = req.getRequestDispatcher(AppConfig.VIEW_DASHBOARD + "user/infor.jsp");
                rp.forward(req, resp);
                break;
            default:
                edit(req,resp);
        }

    }
    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        long id = Long.parseLong(req.getParameter("id"));
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String fullname = req.getParameter("fullname");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        user.setUsername(username);
        user.setFullname(fullname);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        userService.updateUser(id, user);
        req.setAttribute("messageEdit", "Sửa thành công");
        req.setAttribute("user", user);
        req.getSession().setAttribute("user", user);
        RequestDispatcher rp = req.getRequestDispatcher(AppConfig.VIEW_DASHBOARD + "user/infor.jsp");
        rp.forward(req, resp);
    }

}
