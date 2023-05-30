package servlet;

import Bean.*;
import Service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

@WebServlet(name="AddCartServlet",value="/AddCartServlet")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        User user = (User)req.getSession().getAttribute("username");
        String goodsid = (String) req.getSession().getAttribute("goodsid");
        Goods goods = new Goods();
        goods.setgoods_id(goodsid);
        try{
            if (user != null){
                UserService userService = new UserService();
                Order order = userService.addGoodOrder(user,goods);
                req.getSession().setAttribute("orders",order);
                req.getRequestDispatcher("/CartServlet").forward(req,resp);

            }else{
                req.getSession().setAttribute("msg","未注册用户");
                req.getRequestDispatcher("/UserLoginServlet").forward(req,resp);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
