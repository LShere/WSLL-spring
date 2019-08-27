package spring.service;

import spring.pojo.Cart;

import java.util.List;

public interface CartService {
    public int countCart(String openid);

    int deleteCart(String openid, int goods_id);

    int addCart(String openid, int goods_id, int num);
    public List<Cart> listCart(String openid);

    public Integer clearCart(String openid);

}
