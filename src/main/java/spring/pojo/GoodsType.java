package spring.pojo;

import java.util.List;

public class GoodsType {
    String type_id;
    String type_name;
    String type_describe;
    String type_enable;
    int type_sup;
    String type_level;
    String type_file_path;
    //存放子节点
    List<GoodsType> subGoodsTypes;

    public int getType_sup() {
        return type_sup;
    }

    public void setType_sup(int type_sup) {
        this.type_sup = type_sup;
    }

    public List<GoodsType> getSubGoodsTypes() {
        return subGoodsTypes;
    }

    public void setSubGoodsTypes(List<GoodsType> subGoodsTypes) {
        this.subGoodsTypes = subGoodsTypes;
    }

    public String getType_file_path() {
        return type_file_path;
    }

    public void setType_file_path(String type_file_path) {
        this.type_file_path = type_file_path;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getType_describe() {
        return type_describe;
    }

    public void setType_describe(String type_describe) {
        this.type_describe = type_describe;
    }

    public String getType_enable() {
        return type_enable;
    }

    public void setType_enable(String type_enable) {
        this.type_enable = type_enable;
    }

    public String getType_level() {
        return type_level;
    }

    public void setType_level(String type_level) {
        this.type_level = type_level;
    }
}