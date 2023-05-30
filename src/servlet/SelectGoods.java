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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="SelectGoods",value="/SelectGoods")
public class SelectGoods extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String goods_type = req.getParameter("goods_type");
        System.out.println(goods_type);
        try {
            UserService userService = new UserService();
            List<Goods> list = new ArrayList<Goods>();
            list = userService.SelectGoods(goods_type);
            req.getSession().setAttribute("goods",list);
            req.getRequestDispatcher("/SelectGoods.jsp").forward(req,resp);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
