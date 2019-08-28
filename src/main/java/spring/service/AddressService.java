package spring.service;

import spring.pojo.Address;
import java.util.List;

public interface AddressService {
    public List<Address> listAddress(String openid);

    public Integer deleteAddress(String address_id);
    public Integer setDefaulted(String address_id);
    public Integer addAddress(String address_id,String openid,String phone,String region,String detail,String name);
}
