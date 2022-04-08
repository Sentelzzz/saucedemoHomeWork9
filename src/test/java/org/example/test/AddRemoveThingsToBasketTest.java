package org.example.test;

import org.example.service.InventoryPageService;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Integer.parseInt;

public class AddRemoveThingsToBasketTest extends BaseTest {

    private InventoryPageService inventoryPageService = new InventoryPageService();
    private int indexAddToCartButton = 1;
    private final static int indexRemoveToCartButton = 0;
    private final Integer numberFordAddedProductToCart = 1;
    private String initialNumberOfProductInCart;
    private String actualNumberOfProductInCart;
    private String expectedNumberOfProductInCart;

    @Test
    public void addToCartTest() {
        inventoryPageService.login();
        initialNumberOfProductInCart = inventoryPageService.getActualNumberInCart();
        inventoryPageService.addToCart(indexAddToCartButton);
        actualNumberOfProductInCart = inventoryPageService.getActualNumberInCart();
        expectedNumberOfProductInCart = initialNumberOfProductInCart + numberFordAddedProductToCart;
        Assert.assertEquals(actualNumberOfProductInCart, expectedNumberOfProductInCart, "Actual number of product doesn't " +
                "match with expected number in cart!");
    }

    @Test (dependsOnMethods = "addToCartTest")
    public void removeToCartTest() {
        initialNumberOfProductInCart = inventoryPageService.getActualNumberInCart();
        inventoryPageService.removeToCart(indexRemoveToCartButton);
        actualNumberOfProductInCart = correctNumberOfProductInCart(inventoryPageService.getActualNumberInCart());
        int numberOfProductInCart = (parseInt(initialNumberOfProductInCart) - numberFordAddedProductToCart);
        expectedNumberOfProductInCart = Integer.toString(numberOfProductInCart);
        Assert.assertEquals(actualNumberOfProductInCart, expectedNumberOfProductInCart, "Actual number of product doesn't " +
                "match with expected number in cart!");
    }

    private String correctNumberOfProductInCart(String numberOfItemsInCart) {
        if (numberOfItemsInCart.equals("")) {
            return "0";
        } else return numberOfItemsInCart;
    }



}
