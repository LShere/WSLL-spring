package spring.test;

import org.apache.ibatis.session.SqlSession;
import spring.Utils.MybatisUtils;
import spring.bean.Good;

import java.util.List;

public class TestGoods {
    private static SqlSession sqlSession = MybatisUtils.getSession();

    public static void main(String[] args) {
        //findGoods();
        //findGoodsById(2);
        //findGoodsByName("电");
        //addGood();
        //deleteGoodById(4);
        //updateGoodById(7);
        sqlSession.close();
    }

    //查找全部商品
    private static void findGoods() {
        try {
            List<Good> goods = sqlSession.selectList("spring.mapper" + ".findGoods");
            for (Good good : goods) {
                System.out.println(good.getGoodsname());
            }
        } finally {

        }

    }

    //按ID号查询商品
    private static void findGoodsById(int id) {
        Good paragood = new Good();
        paragood.setId(id);
        try {
            List<Good> goods = sqlSession.selectList("spring.mapper" + ".findGoods", paragood);
            for (Good good : goods) {
                System.out.println(good.getGoodsname());
            }
        } finally {
        }
    }

    //根据商品名称 模糊查询
    private static void findGoodsByName(String name) {
        Good paragood = new Good();
        paragood.setGoodsname(name);
        try {
            List<Good> goods = sqlSession.selectList("spring.mapper" + ".findGoods", paragood);
            for (Good good : goods) {
                System.out.println(good.getGoodsname());
            }
        } finally {
        }
    }

    //添加一个新商品
    private static void addGood() {
        Good paragood = new Good();
        paragood.setGoodsname("吹风机");
        paragood.setPrice(100);
        paragood.setQuantity(50);
        try {
            int rows = sqlSession.insert("spring.mapper" + ".addGood", paragood);
            sqlSession.commit();
            System.out.println("插入商品，affected rows:" + rows);
        } finally {
        }
    }

    //按ID号删除一个商品
    private static void deleteGoodById(int id) {
        try {
            int rows = sqlSession.delete("spring.mapper" + ".deleteGoodById", id);
            sqlSession.commit();
            System.out.println("删除商品，affected rows:" + rows);
        } finally {
        }
    }

    //根据ID号更新一个商品
    private static void updateGoodById(int id) {
        Good paragood = new Good();
        paragood.setId(id);
        paragood.setGoodsname("电吹风啦");
        paragood.setPrice(200);
        paragood.setQuantity(100);
        try {
            int rows = sqlSession.update("spring.mapper" + ".updateGoodById", paragood);
            sqlSession.commit();
            System.out.println("更新商品，affected rows:" + rows);
        } finally {
        }
    }

    //多个条件为“商品名称、价格、数量”组合查询

}