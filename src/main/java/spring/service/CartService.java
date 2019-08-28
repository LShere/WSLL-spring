package spring.service;

import spring.pojo.Cart;

import java.util.List;

public interface CartService {
    public Integer countCart(String openid);

    Integer deleteCart(String openid, Integer goods_id);

    Integer addCart(String openid, Integer goods_id, Integer num);
    public List<Cart> listCart(String openid);


    Integer plusMinusCart(String openid, Integer goods_id, Integer sign);

    public Integer clearCart(String openid);

}
