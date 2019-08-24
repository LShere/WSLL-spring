package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.pojo.Goods;
import spring.service.GoodsService;

import java.util.List;

@Controller
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @RequestMapping("/goods")
    @ResponseBody
    public List<Goods> findAllGoods(){
        List<Goods> goodsList=goodsService.findAllGoods();
        return goodsList;
    }

}