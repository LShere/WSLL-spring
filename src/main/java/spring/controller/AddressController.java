package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.pojo.Address;
import spring.service.AddressService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AddressController {

    @Autowired
    AddressService addressService;

    //根据address_id删除地址
    @RequestMapping(value = "/deleteAddress")
    @ResponseBody
    public String deleteAddress(String address_id){
        int result = addressService.deleteAddress(address_id);
        if(result > 0){
            return "success";
        }else{
            return "fail";
        }
    }

    //根据openid查询用户地址
    @RequestMapping(value = "/listAddress")
    @ResponseBody
    public List listAddress(String openid){
        Map<String,Object> map1;
        Map<String,Object> map2;
        List<Address> list = addressService.listAddress(openid);
        List<Map<String,Object>> mapList = new ArrayList<Map<String, Object>>();
        for (Address add:list) {
            map1=new HashMap<String, Object>();
            map2=new HashMap<String, Object>();

            map2.put("region",add.getRegion());
            map2.put("detail",add.getDetail());

            map1.put("openid",add.getOpenid());
            map1.put("address_id",add.getAddress_id());
            map1.put("name",add.getName());
            map1.put("phone",add.getPhone());
            map1.put("address",map2);
            map1.put("defaulted",add.getDefaulted());

            mapList.add(map1);

        }


        return mapList;
    }

    //根据address_id设置默认地址
    @RequestMapping(value = "/setDefault")
    @ResponseBody
    public String setDefault(String address_id){
        int result = addressService.setDefaulted(address_id);
        if(result > 0){
            return "success";
        }else{
            return "fail";
        }
    }




}
