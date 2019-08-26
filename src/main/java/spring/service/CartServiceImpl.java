package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.dao.CartDao;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    CartDao cartDao;
    public int countCart(String openid){
        return  cartDao.countCart(openid);
    }
}
