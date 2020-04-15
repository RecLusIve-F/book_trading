package com.servlet.Info;
import com.entity.Cart;


/**
 *购物车信息
 * @author dwaneZhou
 * @create --\
 */
public class CartInfo {

    private Cart cart;
    private boolean isPromo;

    public CartInfo(Cart cart, boolean isPromo) {
        this.cart = cart;
        this.isPromo = isPromo;
    }

}
