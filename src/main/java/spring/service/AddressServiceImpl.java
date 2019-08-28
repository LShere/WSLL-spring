package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.AddressDao;
import spring.dao.UserDao;
import spring.pojo.Address;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressDao addressDao;
    @Autowired
    UserDao userDao;

    public List<Address> listAddress(String openid) {
        return addressDao.listAddress(openid);
    }

    public Integer deleteAddress(String address_id) {
        return addressDao.deleteAddress(address_id);
    }

    public Integer setDefaulted(String address_id) {
        String s = addressDao.findOpenId(address_id);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("address_id",address_id);
        map.put("openid",s);
        return addressDao.setDefaulted(map);
    }

    public Integer addAddress(String address_id, String openid, String phone, String region, String detail,String name) {

        Map<String,Object> map = new HashMap<String, Object>();
        map.put("address_id",address_id);
        map.put("openid",openid);
        map.put("phone",phone);
        map.put("region",region);
        map.put("detail",detail);
        map.put("name",name);

        return addressDao.addAddress(map);
    }
}
