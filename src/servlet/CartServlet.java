package servlet;
import Bean.*;
import Service.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.Provider;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@WebServlet(name="CartServlet",value="/CartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        User user = (User) req.getSession().getAttribute("username");
        try {
            if (user != null) {
                UserService service = new UserService();
                HashMap<Orderitem, Goods> hash = service.SelectGoodOrder(user);
//                System.out.println(hash.values());
                Order order = service.SelectOrder(user);
                req.getSession().setAttribute("orderitem", hash);
                req.getSession().setAttribute("orders", order);
                req.getRequestDispatcher("/goods_cart.jsp").forward(req, resp);
            } else {
                System.out.println("还未注册");
                req.getSession().setAttribute("msg", "未注册用户");
                req.getRequestDispatcher("/UserLoginServlet").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
