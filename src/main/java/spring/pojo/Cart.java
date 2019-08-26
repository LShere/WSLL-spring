package spring.pojo;

import java.util.Date;

public class Cart {
    int cart_id;
    String cart_openid;
    int cart_goods_id;
    int cart_num;
    Date cart_create_time;

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public String getCart_openid() {
        return cart_openid;
    }

    public void setCart_openid(String cart_openid) {
        this.cart_openid = cart_openid;
    }

    public int getCart_goods_id() {
        return cart_goods_id;
    }

    public void setCart_goods_id(int cart_goods_id) {
        this.cart_goods_id = cart_goods_id;
    }

    public int getCart_num() {
        return cart_num;
    }

    public void setCart_num(int cart_num) {
        this.cart_num = cart_num;
    }

    public Date getCart_create_time() {
        return cart_create_time;
    }

    public void setCart_create_time(Date cart_create_time) {
        this.cart_create_time = cart_create_time;
    }
}
