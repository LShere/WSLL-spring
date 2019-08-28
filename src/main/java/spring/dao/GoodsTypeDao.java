package spring.dao;

import spring.pojo.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    public GoodsType findAllGoodtype();
    public List<GoodsType> findParaType();
    public List<GoodsType> findParaTypeChildType(int type_sup);
}
