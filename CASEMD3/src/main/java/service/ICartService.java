package service;

import model.Cart;

public interface ICartService {
    Cart getCartById(long idUser);
    Cart createCart(Cart cart);

//    Cart updateCart(Cart cart);

    void addToCart(int idProduct, long quantity, long id);


    Cart updateCartInfo(long idUser, long idProduct, long quantity);

    Cart updateTotalCart(Cart cart);
    void remote(long id);
}