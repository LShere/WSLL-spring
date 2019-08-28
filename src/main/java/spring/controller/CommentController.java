package spring.controller;


import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.pojo.Comment;
import spring.pojo.Orders;
import spring.service.CommentService;
import spring.service.OrdersService;
import spring.service.UserService;

import java.util.List;
import java.util.Map;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private UserService userService;

    @RequestMapping("/addComment")
    public String addComment(@RequestBody JSONObject jsonObject){

        Comment commentShili = new Comment();

        String openid = jsonObject.getString("openid");
        String order_id = jsonObject.getString("order_id");
        Integer starIndex = jsonObject.getInteger("starIndex");
        String comment = jsonObject.getString("comment");

        commentShili.setOpenid(openid);
        commentShili.setOrder_id(order_id);
        commentShili.setStarIndex(starIndex);
        commentShili.setComment(comment);

        int result = commentService.addComment(commentShili);
        int result2 = ordersService.completeOrder(order_id);
        if(result > 0){
            System.out.println("添加评论成功");
            if(result2 > 0){
                System.out.println("订单已完成");
                return "发布成功";
            }
        }
        return "发布失败";
    }

    @RequestMapping("/getCommentList")
    public List getCommentList(){
        List list = userService.getCommentList();
        return list;
    }
}
