package servlet;
import Bean.*;
import Dao.*;
import Service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.awt.print.PrinterGraphics;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "GoodsServlet",urlPatterns = "/GoodsServlet")
public class GoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        String goodsid = req.getParameter("typeid");
        req.getSession().setAttribute("goodsid",goodsid);
        Goods goods = new Goods();
        goods.setgoods_id(goodsid);
        try {
            UserService service = new UserService();
            Goods goods1 = service.selectgoods(goods);
            req.getSession().setAttribute("good",goods1);
//            System.out.println(goods1.getgoods_name()+"  "+goods1.getgoods_describe());
            req.getRequestDispatcher("/Goods.jsp").forward(req,resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
