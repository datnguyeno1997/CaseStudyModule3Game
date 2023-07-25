package service;

import model.CartItem;

import java.util.List;

public interface ICartItemService {
    List<CartItem> getAllCartItems(long idCart);

    CartItem saveCartItem(CartItem cartItem);
    CartItem updateCartItem(CartItem cartItem);

    void deleteCartItem(long idCartItem);
    void deleteIdCart(long idCart);
    public CartItem findCartItemById(long cartId, long idProduct);
}