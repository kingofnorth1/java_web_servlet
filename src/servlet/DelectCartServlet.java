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

@WebServlet(name="DelectCartServlet",value="/DelectCartServlet")
public class DelectCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        User user = (User)req.getSession().getAttribute("username");
        String itemid = req.getParameter("itemid");
//        System.out.println(goodsid);
        try{
            UserService userService = new UserService();
            Order order = userService.DelectOrderitem(itemid,user);
            req.getSession().setAttribute("orders",order);
            req.getRequestDispatcher("/CartServlet").forward(req,resp);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
