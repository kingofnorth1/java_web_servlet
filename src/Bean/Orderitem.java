package Bean;

public class Orderitem {
    String orderitem_id = null;
    String orderitem_price = null;
    String orderitem_amount = null;
    String goods_id = null;
    String order_id = null;
    public String getOrderitem_id(){
        return orderitem_id;
    }
    public void setOrderitem_id(String orderitem_id){
        this.orderitem_id = orderitem_id;
    }
    public String getOrderitem_price(){
        return orderitem_price;
    }
    public void setOrderitem_price(String orderitem_price){
        this.orderitem_price = orderitem_price;
    }
    public String getOrderitem_amount(){
        return orderitem_amount;
    }
    public void setOrderitem_amount(String orderitem_amount){
        this.orderitem_amount = orderitem_amount;
    }
    public String getGoods_id(){
        return goods_id;
    }
    public void setGoods_id(String goods_id){
        this.goods_id = goods_id;
    }
    public String getOrder_id(){
        return order_id;
    }
    public void setOrder_id(String order_id){
        this.order_id = order_id;
    }
}
