package org.example.service;

import org.example.page.CartPage;

public class CartPageService {

    private CartPage cartPage = new CartPage();

    public String getTextOfProductNameInCart() {
        return cartPage.getTextOfProductName();
    }

    public String getProductPrice() {
        return cartPage.getTextOfProductPrice();
    }
}
