package spring.dao;

import org.apache.ibatis.annotations.Param;
import spring.pojo.Address;

import java.util.List;
import java.util.Map;

public interface AddressDao {


    public List<Address> listAddress(String openid);

    public Integer deleteAddress(String address_id);
    public Integer setDefaulted(Map<String, Object> map);
    public String findOpenId(String Address_id);


}
