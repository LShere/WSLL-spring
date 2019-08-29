package spring.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.io.FilenameUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import spring.pojo.Goods;
import spring.pojo.GoodsType;
import spring.pojo.Page;
import spring.service.GoodsService;
import spring.service.GoodsTypeService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;
    @Autowired
    GoodsTypeService goodsTypeService;

    /*查询商品表的所有数据*/
    @GetMapping(value = "/getGoods")
    @ResponseBody
    public Map<String, Object> findAllGoods() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Goods> goodsList = goodsService.findAllGoods();
        if (goodsList == null || goodsList.size() == 0) {
            map.put("code", 400);
            map.put("message", "不存在商品!");
            return map;
        } else {
            map.put("code", 200);
            map.put("message", "查找商品成功!");
            map.put("goods", goodsList);
            return map;
        }

    }

    /*
     *商品表的查询
     * 传入数据：
     * goods_type-商品类目名
     * goods_name-商品名字
     * goods_describe-商品描述
     * 返回数据json
     * */
    @GetMapping(value = "/findGoods")
    @ResponseBody
    public Map<String, Object> findGoods(String goods_type, String goods_name, String goods_describe) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Goods> goodsList = goodsService.findGoods(goods_type, goods_name, goods_describe);
        System.out.println(goodsList);
        if (goodsList == null || goodsList.size() == 0 ) {
            map.put("code", 400);
            map.put("message", "不存在商品!");
            return map;
        } else {
            map.put("code", 200);
            map.put("message", "查找商品成功!");
            map.put("goods", goodsList);
            return map;
        }
    }

    /*
     *商品表的分页查询
     * 传入数据：
     * currentPage-当前页数
     * goods_type-商品列表
     * goods_name-商品名字
     * goods_describe-商品描述
     * 返回数据json
     * */
    @GetMapping(value = "/findGoodsPage")
    @ResponseBody
    public Map<String, Object> findGoodPage(int currentPage, String goods_type, String goods_name, String goods_describe) {
        Map<String, Object> map = new HashMap<String, Object>();
        Page<Goods> goodsPage = goodsService.findGoodPage(currentPage, goods_type, goods_name, goods_describe);
        if (goodsPage == null) {
            map.put("code", 400);
            map.put("message", "不存在商品!");
            return map;
        } else {
            map.put("code", 200);
            map.put("message", "查找商品成功!");
            map.put("goods", goodsPage);
            return map;
        }
    }

    /*根据传入的商品ID查询商品表*/
    @GetMapping(value = "/findGoodsbyId")
    @ResponseBody
    public Map<String, Object> findGoodsbyId(@Param("id") int id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Goods goods = goodsService.findGoodsById(id);
        if (goods == null) {
            map.put("code", 400);
            map.put("message", "不存在商品!");
            return map;
        } else {
            map.put("code", 200);
            map.put("message", "查找商品成功!");
            map.put("goods", goods);
            return map;
        }
    }

    /*随机获取商品表num条记录*/
    @GetMapping(value = "/findGoodsByRand")
    @ResponseBody
    public Map<String, Object> findGoodsByRand(int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Goods> goodsList = goodsService.findGoodsByRand(num);
        if (goodsList == null || goodsList.size() == 0) {
            map.put("code", 400);
            map.put("message", "不存在商品!");
            return map;
        } else {
            map.put("code", 200);
            map.put("message", "查找商品成功!");
            map.put("goods", goodsList);
            return map;
        }

    }

    //获取商品分类
    @GetMapping(value = "/getGoodsType")
    @ResponseBody
    public Map<String, Object> getGoodsType() {
        //一级、二级分类
        List<GoodsType> typeListP = new ArrayList<GoodsType>();
        List<GoodsType> typeListC = new ArrayList<GoodsType>();
        Map<String, Object> map = new HashMap<String, Object>();
        //获取一级分类
        typeListP = goodsTypeService.findParaType();
        for (int i = 0; i < typeListP.size(); i++) {
            GoodsType goodsType = typeListP.get(i);
            goodsType.setSubGoodsTypes(goodsTypeService.findParaTypeChildType(Integer.parseInt(goodsType.getType_id())));
            typeListP.set(i, goodsType);
        }
        if (typeListP == null || typeListP.size() == 0) {
            map.put("code", 400);
            map.put("message", "不存在!");
            return map;
        } else {
            map.put("code", 200);
            map.put("message", "成功!");
            map.put("typeListP", typeListP);
            return map;
        }

    }

    /*查询添加时间最晚的n条记录
     * 传入数据 n*/
    @GetMapping(value = "/findNewGoods")
    @ResponseBody
    public Map<String, Object> findNewGoods(int n) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Goods> goodsList = goodsService.findNewGoods(n);
        if (goodsList == null || goodsList.size() == 0) {
            map.put("code", 400);
            map.put("message", "不存在商品!");
            return map;
        } else {
            map.put("code", 200);
            map.put("message", "查找商品成功!");
            map.put("goods", goodsList);
            return map;
        }
    }

    /*插入商品表*/
    @GetMapping(value = "/addGoods")
    @ResponseBody
    public int addGoods(@RequestBody JSONObject jsonObject) {
        Goods goods=new Goods();

        /*获取传入数据插入goods*/
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

        int rows = this.goodsService.addGoods(goods);
        return rows;
    }

    /*插入商品表的正确姿势*/
    @PostMapping(value = "/addGood")
    @ResponseBody
    public int addGood(Goods goods) {
        int rows = this.goodsService.addGoods(goods);
        return rows;
    }

    /*修改商品表信息*/
    @GetMapping(value = "/updateGoods")
    @ResponseBody
    public int updateFGoods(@RequestBody JSONObject jsonObject) {

        Goods goods=new Goods();

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
    @GetMapping(value = "/deleteGoodsById")
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
        fileName.append("."+FilenameUtils.getExtension(file.getOriginalFilename()));

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
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> doEdit(MultipartFile file, HttpServletRequest res,Integer id) throws UniformInterfaceException, IOException {
        Map<String, Object> map = new HashMap<String, Object>();

        String fileName = putStatic(file);



        if (fileName == null ) {
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


}