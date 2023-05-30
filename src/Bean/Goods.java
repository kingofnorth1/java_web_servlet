package Bean;

public class Goods {
    String goods_id = null;
    String goods_name = null;
    String goods_img = null;
    String goods_num = null;
    String goods_type = null;
    String goods_price = null;
    String goods_describe = null;
    public String getgoods_price(){
        return goods_price;
    }
    public void setgoods_price(String goods_prices){
        this.goods_price = goods_prices;
    }
    public String getgoods_describe(){
        return goods_describe;
    }
    public void setgoods_describe(String goods_describes){
        this.goods_describe = goods_describes;
    }
    public String getgoods_id(){
        return goods_id;
    }
    public void setgoods_id(String goods_id){
        this.goods_id = goods_id;
    }
    public String getgoods_name(){
        return goods_name;
    }
    public void setgoods_name(String goods_name){
        this.goods_name = goods_name;
    }
    public String getgoods_img(){
        return goods_img;
    }
    public void setgoods_img(String goods_type){
        this.goods_img = goods_type;
    }
    public String getgoods_num(){
        return goods_num;
    }
    public void setgoods_num(String goods_num){
        this.goods_num = goods_num;
    }
    public String getgoods_type(){
        return goods_type;
    }
    public void setgoods_type(String goods_type){
        this.goods_type = goods_type;
    }
}
