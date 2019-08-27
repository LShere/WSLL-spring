package spring.service;

import spring.pojo.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    public GoodsType findAllGoodtype();
    public List<GoodsType> findParaType();
    public List<GoodsType> findParaTypeChildType(int type_sup);
}
