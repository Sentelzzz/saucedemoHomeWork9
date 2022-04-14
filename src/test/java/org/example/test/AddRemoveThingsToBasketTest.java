package org.example.test;

import org.example.service.InventoryPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.lang.Integer.parseInt;

public class AddRemoveThingsToBasketTest extends BaseTest {

    private InventoryPageService inventoryPageService = new InventoryPageService();
    private BaseTest baseTest = new BaseTest();
    private final static int indexProductInList = 0;
    private String initialNumberOfProductInCart;
    private String actualNumberOfProductInCart;
    private String expectedNumberOfProductInCart;

    @BeforeClass
    public void setUp() {
        inventoryPageService = new InventoryPageService();
    }

    @Test
    public void addToCartTest() {
        inventoryPageService.login();
        initialNumberOfProductInCart = inventoryPageService.getActualNumberInCart();
        for (int i = 0; i < baseTest.getCartProductsAmount(); i++) {
            inventoryPageService.addToCart(indexProductInList);
        }
        actualNumberOfProductInCart = inventoryPageService.getActualNumberInCart();
        expectedNumberOfProductInCart = initialNumberOfProductInCart + baseTest.getCartProductsAmount();
        Assert.assertEquals(actualNumberOfProductInCart, expectedNumberOfProductInCart, "Actual number of product doesn't " +
                "match with expected number in cart!");
    }

    @Test (dependsOnMethods = "addToCartTest")
    public void removeToCartTest() {
        initialNumberOfProductInCart = inventoryPageService.getActualNumberInCart();
        for (int i = 0; i < baseTest.getCartProductsAmount(); i++) {
            inventoryPageService.removeToCart(indexProductInList);
        }
        actualNumberOfProductInCart = correctNumberOfProductInCart(inventoryPageService.getActualNumberInCart());
        int numberOfProductInCart = (parseInt(initialNumberOfProductInCart) - baseTest.getCartProductsAmount());
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
