package login;

import Service.*;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import Bean.*;
import Dao.*;
import javax.sql.DataSource;
import java.io.*;
import java.sql.*;
import java.util.*;
@WebServlet(name = "UserRegisterServlet",urlPatterns = "/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String registerusername = req.getParameter("username");
        String registerPassWord = req.getParameter("password");
        String registeremail = req.getParameter("email");
        String registerphone = req.getParameter("phone");
        String registername = req.getParameter("name");
        String registeraddress= req.getParameter("address");
        String registerisadmin = req.getParameter("isadmin");
        User user = new User();
        user.setUsername(registerusername);
        user.setPassword(registerPassWord);
        user.setEmail(registeremail);
        user.setEmail(registerphone);
        user.setEmail(registername);
        user.setEmail(registeraddress);
        user.setEmail(registerisadmin);
        try {
            UserService service = new UserService();
            service.addService(user);
            req.getRequestDispatcher("/user_login.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
