package spring.AdminController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.pojo.Goods;
import spring.pojo.Orders;
import spring.service.GoodsService;
import spring.service.OrdersService;
import spring.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping(value = "/admin")
public class GoodsControllerAdmin {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UserService userService;

    /*插入商品表的正确姿势*/
    @PostMapping(value = "addGood")
    @ResponseBody
    public int addGood(Goods goods) {
        int rows = this.goodsService.addGoods(goods);
        return rows;
    }

    /*修改商品表信息*/
    @GetMapping(value = "updateGoods")
    @ResponseBody
    public int updateFGoods(@RequestBody JSONObject jsonObject) {

        Goods goods = new Goods();

        /*获取传入数据插入goods*/
        goods.setGoods_id(jsonObject.getInteger("goods_id"));
        goods.setGoods_type(jsonObject.getString("goods_type"));
        goods.setGoods_name(jsonObject.getString("goods_name"));
        goods.setGoods_describe(jsonObject.getString("goods_describe"));
        goods.setGoods_price(jsonObject.getFloat("goods_price"));
        goods.setGoods_validity(jsonObject.getDate("goods_validity"));
        goods.setGoods_enable(jsonObject.getString("goods_enable"));
        goods.setGoods_browse(jsonObject.getInteger("goods_browse"));
        goods.setGoods_buy(jsonObject.getInteger("goods_buy"));
        goods.setGoods_picture_path(jsonObject.getString("goods_picture_path"));
        goods.setGoods_create_time(jsonObject.getDate("goods_create_time"));

        System.out.println(goods);
        int rows = this.goodsService.updateGoods(goods);
        return rows;
    }

    /*删除商品表信息*/
    @GetMapping(value = "deleteGoodsById")
    @ResponseBody
    public int deleteGoodsById(int id) {
        int rows = this.goodsService.deleteGoodsById(id);
        return rows;
    }


    /*上传静态文件*/
    public String putStatic(MultipartFile file) throws UniformInterfaceException, ClientHandlerException, IOException {

        //配置访问前缀
        //String path = "http://120.77.209.0:/usr/WSLL-static/goods/";
        String path = "http://120.77.209.0/img/";

        //设置文件名，时间+4个随机数
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        StringBuilder fileName = new StringBuilder(sdf.format(date));
        for (int i = 0; i < 4; i++) {
            Random r = new Random();
            String str = String.valueOf(r.nextInt(10));
            fileName.append(str);
        }
        fileName.append("." + FilenameUtils.getExtension(file.getOriginalFilename()));

        //合并路径
        String url = path + fileName.toString();

        //生成一个网络资源
        Client client = new Client();

        //生成web资源
        WebResource resource = client.resource(url);

        //通过网络资源往指定地址存放文件
        resource.put(String.class, file.getBytes());

        return fileName.toString();
    }

    /*上传文件，并修改数据库*/
    @PostMapping(value = "upload")
    @ResponseBody
    public Map<String, Object> doEdit(MultipartFile file, HttpServletRequest res, Integer id) throws UniformInterfaceException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("file:" + file);
        String fileName = putStatic(file);
        if (fileName == null) {
            map.put("code", 400);
            map.put("message", "图片上传失败！");
            return map;
        } else {
            map.put("code", 200);
            map.put("message", "图片上传成功!");
            map.put("img", fileName);
            return map;
        }
    }

    /*根据id删除订单表*/
    @RequestMapping(value = "deleteOrder")
    @ResponseBody
    public String deleteOrder(String order_id) {
        int result = ordersService.deleteOrder(order_id);
        if (result > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    //根据用户id和订单id查找订单
    @RequestMapping(value = "findOrdersByOpenid")
    @ResponseBody
    public List<Orders> findOrdersByOpenid(String openid, String order_id) {

        return ordersService.findOrdersByOpenid(openid, order_id);
    }
    //查找所有的订单
    @RequestMapping("/getAllOrdersAdmin")
    @ResponseBody
    public List getAllOrders(){
        List list = userService.getAllOrdersAdmin();
        return list;
    }
    //删除多个订单
    @RequestMapping(value = "deleteMultiOrders")
    @ResponseBody
    public String deleteMultiOrders(@RequestBody JSONObject jsonObject){
        int result = 0;
        String temp = jsonObject.getString("deleteList");
        String[] arr = temp.substring(1, temp.length() - 1).trim().split(",");
        for(String item : arr){
//            System.out.println(item.trim());
            result += ordersService.deleteOrder(item.trim());
        }
        if (result > 0) {
            return "success";
        }else{
            return "failed";
        }
    }

}
