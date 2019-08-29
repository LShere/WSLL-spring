package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring.service.GoodsTypeService;

@Controller
public class GoodsTypeController {

    @Autowired
    GoodsTypeService goodsTypeService;



}