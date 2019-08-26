package spring.service;

public interface CartService {
    public int countCart(String openid);

    int deleteCart(String openid, int goods_id);

    int addCart(String openid, int goods_id, int num);

}
