package spring.dao;

import org.apache.ibatis.annotations.Param;
import java.util.Map;
public interface CartDao {

    public int countCart(String openid);

    public int deleteCart(Map map);
    public int addCart(Map map);

}
