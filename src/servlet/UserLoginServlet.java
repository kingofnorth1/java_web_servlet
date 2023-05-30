package servlet;

import Service.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import java.io.*;
import java.security.Provider;
import java.sql.*;
import Connection.*;
import Bean.*;
import Dao.*;

@WebServlet(name = "UserLoginServlet",urlPatterns = "/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String user_name = req.getParameter("username");
        String user_PassWord = req.getParameter("password");
        User user = new User();
        user.setUsername(user_name);
        user.setPassword(user_PassWord);
        try {
            UserService service = new UserService();
            User name = service.selectnamepass(user);
            req.getSession().setAttribute("username",name);
            if (name != null){
                req.getSession().setAttribute("msg","登录成功");
                resp.sendRedirect("header.jsp");
//                req.getRequestDispatcher("/header.jsp").forward(req,resp);
            }else {
                if (req.getSession().getAttribute("msg")!=null){
                    req.getRequestDispatcher("/user_login.jsp").forward(req,resp);
                }
                else {
                    req.getSession().setAttribute("msg","密码或账号错误，请重新登录");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
