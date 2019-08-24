package spring.pojo;

import java.util.Date;

public class Goods {

    Integer goods_id;
    String  goods_type;
    String  goods_name;
    String  goods_describe;
    Integer goods_price;
    Date    goods_validity;
    String  goods_enable;
    Integer goods_browse;
    Integer goods_buy;
    String  goods_picture_path;

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public String getGoods_describe() {
        return goods_describe;
    }

    public void setGoods_describe(String goods_describe) {
        this.goods_describe = goods_describe;
    }

    public Integer getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Integer goods_price) {
        this.goods_price = goods_price;
    }

    public Date getGoods_validity() {
        return goods_validity;
    }

    public void setGoods_validity(Date goods_validity) {
        this.goods_validity = goods_validity;
    }

    public String getGoods_enable() {
        return goods_enable;
    }

    public void setGoods_enable(String goods_enable) {
        this.goods_enable = goods_enable;
    }

    public Integer getGoods_browse() {
        return goods_browse;
    }

    public void setGoods_browse(Integer goods_browse) {
        this.goods_browse = goods_browse;
    }

    public Integer getGoods_buy() {
        return goods_buy;
    }

    public void setGoods_buy(Integer goods_buy) {
        this.goods_buy = goods_buy;
    }

    public String getGoods_picture_path() {
        return goods_picture_path;
    }

    public void setGoods_picture_path(String goods_picture_path) {
        this.goods_picture_path = goods_picture_path;
    }
}