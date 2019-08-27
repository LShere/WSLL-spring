package spring.pojo;
import java.util.Date;
import java.util.List;

public class Orders {
    String order_id;
    String openid;
    String pay_status;//代付款 代发货
    Date create_time;
    float pay_price;
    List<GoodsOrders> goodsOrdersList;

    public List<GoodsOrders> getGoodsOrdersList() {
        return goodsOrdersList;
    }

    public void setGoodsOrdersList(List<GoodsOrders> goodsOrdersList) {
        this.goodsOrdersList = goodsOrdersList;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getPay_status() {
        return pay_status;
    }

    public void setPay_status(String pay_status) {
        this.pay_status = pay_status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public float getPay_price() {
        return pay_price;
    }

    public void setPay_price(float pay_price) {
        this.pay_price = pay_price;
    }
}
