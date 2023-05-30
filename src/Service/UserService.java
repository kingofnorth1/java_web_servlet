package Service;
import Bean.*;
import Dao.*;
import com.mchange.v1.identicator.IdList;
import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UserService {
    public void addService(User user) throws SQLException {
        UserDao udo = new UserDao();
        udo.addUser(user);
    }
    public User selectnamepass(User user) throws SQLException{
        UserDao udo = new UserDao();
        User name = udo.selectnamepass(user);
        return name;
    }
    public List<Goods> selectallgoods() throws SQLException{
        UserDao dao = new UserDao();
        List<Goods> list = dao.selectallgoods();
        return list;
    }
    public Goods selectgoods(Goods good) throws SQLException{
        UserDao udo = new UserDao();
        Goods goods = udo.selectgoods(good);
        return goods;

    }
    public Order SelectOrder(User user)throws SQLException{
        UserDao udo = new UserDao();
        Order order = udo.SelectGoodOrder(user);
        return order;
    }
    public HashMap<Orderitem, Goods> SelectGoodOrder(User user) throws SQLException{
        UserDao udo = new UserDao();
        Order order = udo.SelectGoodOrder(user);
//        if (order == null){
//            HashMap<Orderitem, Goods> hash = new HashMap<Orderitem, Goods>();
//            udo.AddGoodOrder(user,goods);
//            Order order1 = udo.SelectGoodOrder(user);
//            udo.AddGoodOrderitem(order1,goods);
//            return null;
        HashMap<Orderitem, Goods> hash = new HashMap<Orderitem, Goods>();
        List<Orderitem> list = udo.SelectGoodItem(order);
        for (Orderitem orderitem:list){
            Goods goods = udo.SelectGoodByOrder(orderitem);
            hash.put(orderitem,goods);
        }
        return hash;
    }
    public Order addGoodOrder(User user,Goods goods) throws SQLException{
        UserDao udo = new UserDao();
        Order order = udo.SelectGoodOrder(user);
        goods = udo.selectgoods(goods);
//        System.out.println("132:"+goods.getgoods_id());
        if (order == null){
            udo.AddGoodOrder(user,goods);
            Order order1 = udo.SelectGoodOrder(user);
            udo.AddGoodOrderitem(order1,goods);
        }else{
            Orderitem orderitem = udo.SelectOrderByGood(goods);
            if (orderitem == null){
                udo.AddGoodOrderitem(order,goods);
            }else {
                int amount = Integer.parseInt(orderitem.getOrderitem_amount())+1;
                udo.UpdateOrderitem(amount,goods);
            }
            List<Orderitem> list = udo.SelectGoodItem(order);
            int sum_price = 0;
            int sum_amount = 0;
            for (Orderitem orderitem1:list){
                int temp1 = Integer.parseInt(orderitem1.getOrderitem_amount());
                int temp2 = Integer.parseInt(orderitem1.getOrderitem_price());
                sum_amount += temp1;
                sum_price += temp2*temp1;
            }
            udo.UpdataOrder(sum_amount,sum_price,user);
        }
        order = udo.SelectGoodOrder(user);
        return order;
    }
    public Order DelectOrderitem(String itemsid,User user) throws SQLException {
        UserDao udo = new UserDao();
        udo.DelectOrderitem(itemsid);
        Order order = udo.SelectGoodOrder(user);
        List<Orderitem> list = udo.SelectGoodItem(order);
        int sum_price = 0;
        int sum_amount = 0;
        for (Orderitem orderitem1:list){
            int temp1 = Integer.parseInt(orderitem1.getOrderitem_amount());
            int temp2 = Integer.parseInt(orderitem1.getOrderitem_price());
            sum_amount += temp1;
            sum_price += temp2*temp1;
        }
        udo.UpdataOrder(sum_amount,sum_price,user);
        order = udo.SelectGoodOrder(user);
        return order;
    }
    public List<Goods> SelectGoods(String goods_type) throws SQLException{
        UserDao udo = new UserDao();
        List<Goods> list = new ArrayList<Goods>();
        list = udo.SelectGoodstype(goods_type);
        for (Goods goods:list){
            System.out.println(goods.getgoods_id());
        }
        return list;
    }
    public void UpdatePayment(User user) throws SQLException {
        UserDao udo = new UserDao();
        udo.UpdatePayment(user);
    }
}
