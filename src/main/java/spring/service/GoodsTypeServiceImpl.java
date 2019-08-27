package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.GoodsTypeDao;
import spring.pojo.GoodsType;

import java.util.List;

@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Autowired
    private GoodsTypeDao goodsTypeDao;
    public GoodsType findAllGoodtype() {
        return goodsTypeDao.findAllGoodtype();
    }

    public List<GoodsType> findParaType() {
        return goodsTypeDao.findParaType();
    }

    public List<GoodsType> findParaTypeChildType(int type_sup) {
        return goodsTypeDao.findParaTypeChildType(type_sup);
    }
}
