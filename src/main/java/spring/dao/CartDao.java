package spring.dao;

import org.apache.ibatis.annotations.Param;
import spring.pojo.Cart;
import java.util.List;

import java.util.Map;
public interface CartDao {

    public int countCart(String openid);

    public List<Cart> listCart(String openid);

    public int deleteCart(Map map);

    public int addCart(Map map);

    public Cart findCart(Map map);

    Integer plusMinusCart(Map<String, Object> map);

    public Integer clearCart(String openid); //清空购物车

}
