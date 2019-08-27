package spring.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.pojo.Goods;
import spring.pojo.Page;
import spring.service.GoodsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @GetMapping(value = "/getGoods")
    @ResponseBody
    public Map<String, Object> findAllGoods() {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Goods> goodsList = goodsService.findAllGoods();
        if (goodsList == null) {
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

    @GetMapping(value = "/findGoodsbyId")
    @ResponseBody
    public Map<String, Object> findGoodsbyId(@Param("id")int id) {
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
    @GetMapping(value = "/getGoodsByRand")
    @ResponseBody
    public Map<String, Object> findGoodsByRand(int num) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Goods> goodsList = goodsService.findGoodsByRand(num);
        if (goodsList == null) {
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

}