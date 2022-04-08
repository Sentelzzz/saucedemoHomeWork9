package org.example.service;

import org.example.page.CartPage;

import java.util.ArrayList;
import java.util.List;

public class CartPageService {

    private CartPage cartPage = new CartPage();

    public List<String> getCartProductsNameList() {
        List<String> productsCartList = new ArrayList<>();
        for (int i = 0; i < cartPage.getProductsName().size(); i++) {
            productsCartList.add(cartPage.getProductsName().get(i).getText());
        }
        return productsCartList;
    }

    public List<Double> getCartProductsPriceList() {
        List<Double> productsPriceList = new ArrayList<>();
        for (int i = 0; i < cartPage.getProductsPrice().size(); i++) {
            productsPriceList.add(Double.parseDouble(cartPage.getProductsPrice().get(i).getText().replaceAll("[^0-9.]", "")));
        }
        return productsPriceList;
    }

}
