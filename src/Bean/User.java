package Bean;
public class User {
    String id = null;
    String username = null;
    String password = null;
    String email = null;
    String phone = null;
    String name = null;
    String address = null;
    String isadmin = null;
    public String getId(){return id;}
    public void setId(String id){this.id = id;}
    public String getisadmin(){
        return isadmin;
    }
    public void setisaddress(String isadmins){
        isadmin = isadmins;
    }
    public String getaddress(){
        return address;
    }
    public void setaddress(String addresss){
        address = addresss;
    }
    public String getname(){
        return name;
    }
    public void setname(String names){
        name = names;
    }
    public String getphone(){
        return phone;
    }
    public void set(String phones){
        phone = phones;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String name){
        username = name;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String pass){
        password = pass;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String emails){
        email = emails;
    }
}
