package Dao;

import Bean.*;
import com.mysql.cj.x.protobuf.MysqlxCrud;
import org.apache.commons.dbutils.QueryRunner;
import Connection.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserDao {
    public void addUser(User user) throws SQLException {
        String selectusername = "insert into login values(?,?,?,?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(selectusername,0,user.getUsername(),user.getPassword(),user.getEmail(),user.getphone(),user.getname(),user.getaddress(),0);
    }
    public User selectnamepass(User user) throws SQLException{
        String selectusername = "select * from login where username = '"+user.getUsername()+"'and password = '"+user.getPassword()+"'";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        User select_user = (User)runner.query(selectusername,new BeanHandler(User.class));

        return select_user;
    }
    public List<Goods> selectallgoods() throws SQLException{
        String sql = "select * from goods";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        List<Goods> list = (List)runner.query(sql,new BeanListHandler(Goods.class));
        return list;
    }
    public Goods selectgoods(Goods good) throws SQLException{
        String sql = "select * from goods where goods_id = '"+good.getgoods_id()+"'";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        Goods goods = (Goods)runner.query(sql,new BeanHandler(Goods.class));
        return goods;
    }
    public List<Orderitem> SelectGoodItem(Order order) throws SQLException {
        String sql = "select * from orderitem where order_id = '"+order.getOrder_id()+"'";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        List<Orderitem> list = (List)runner.query(sql,new BeanListHandler(Orderitem.class));
        return list;
    }
    public Order SelectGoodOrder(User user) throws SQLException {
        String sql = "select * from orders where user_id = '"+user.getId()+"'";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        Order orders = (Order)runner.query(sql,new BeanHandler(Order.class));
        return orders;
    }
    public Goods SelectGoodByOrder(Orderitem orderitem) throws SQLException {
        String sql = "select * from goods where goods_id = '"+orderitem.getGoods_id()+"'";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        Goods goods = (Goods)runner.query(sql,new BeanHandler(Goods.class));
        return goods;
    }
    public Orderitem SelectOrderByGood(Goods goods) throws SQLException{
        String sql = "select * from orderitem where goods_id ='"+goods.getgoods_id()+"'";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        Orderitem orderitem = (Orderitem)runner.query(sql,new BeanHandler(Orderitem.class));
        return orderitem;
    }
    public void AddGoodOrder(User user,Goods goods) throws SQLException {
        String selectusername = "insert into orders values(?,?,?,?,?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        runner.update(selectusername,0,goods.getgoods_price(),1,0,goods.getgoods_name(),user.getphone(),user.getaddress(),formatter.format(date),user.getId());
    }
    public void AddGoodOrderitem(Order order,Goods goods)throws SQLException{
        String selectusername = "insert into orderitem values(?,?,?,?,?)";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(selectusername,0,goods.getgoods_price(),1,goods.getgoods_id(),order.getOrder_id());
    }
    public void UpdateItemAmount()throws SQLException{

    }
    public void UpdataOrder(int amount,int total,User user)throws SQLException{
        String sql = "update orders set order_total = '"+total+"' , order_amount = '"+amount+"' where user_id = '"+user.getId()+"'";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql);
    }
    public void UpdateOrderitem(int amount,Goods goods)throws SQLException{
        String sql = "update orderitem set orderitem_amount = '"+amount+"' where goods_id='"+goods.getgoods_id()+"'";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql);
    }
    public void DelectOrderitem(String itemid) throws SQLException{
        String sql = "delete from orderitem where orderitem_id = '"+itemid+"'";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql);
    }
    public List<Goods> SelectGoodstype(String goods_type) throws SQLException{
        String sql = "select * from goods where goods_type = '"+goods_type+"'";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        List<Goods> list = (List)runner.query(sql,new BeanListHandler(Goods.class));
        return list;
    }
    public void UpdatePayment(User user) throws SQLException{
        String sql = "update orders set order_paytype = 1 where user_id='"+user.getId()+"'";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        runner.update(sql);
    }
}