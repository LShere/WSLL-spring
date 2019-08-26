package spring.dao;

import org.apache.ibatis.annotations.Param;

public interface CartDao {

    public int countCart(String openid);

    public int deleteCart(@Param("openid")String openid,@Param("goods_id")int goods_id);

}
