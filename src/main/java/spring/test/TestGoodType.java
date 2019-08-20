package spring.test;

import org.apache.ibatis.session.SqlSession;
import spring.Utils.MybatisUtils;
import spring.bean.GoodType;

import java.util.List;

public class TestGoodType {
    private static SqlSession sqlSession = MybatisUtils.getSession();
    public static void main(String[] args) {
        List <GoodType> goodTypes = sqlSession.selectList("spring.mapper.good"+".findGoodsType");
        //sqlSession.selectList("spring.mapper"+".findGoodsByTypeId");

    }
}
