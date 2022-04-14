package org.example.test;

import org.example.service.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class OrderTest extends BaseTest {

    private InventoryPageService inventoryPageService = new InventoryPageService();
    private BaseTest baseTest = new BaseTest();
    private CartPageService cartPageService = new CartPageService();
    private CheckoutPageService checkoutPageService = new CheckoutPageService();
    private CheckoutOverviewPageService checkoutOverviewPageService = new CheckoutOverviewPageService();
    private CheckoutCompletePageService checkoutCompletePageService = new CheckoutCompletePageService();
    private final static String NAME_OF_CHECKOUT_OVERVIEW_PAGE = "CHECKOUT: OVERVIEW";
    private List<String> expectedProductInCart;
    private List<String> actualProductInCart;
    private List<Double> expectedProductPrice;
    private List<Double> actualProductPrice;
    private String actualNameOfPage;
    private Double actualTotalPrice;
    private Double expectedTotalPrice;
    private final static String NAME_OF_CHECKOUT_COMPLETE_PAGE = "CHECKOUT: COMPLETE!";

    @BeforeClass
    public void setUp() {
        inventoryPageService = new InventoryPageService();
    }

    @Test
    public void checkProductInCart() throws InterruptedException {
        inventoryPageService.login();
        for (int i = 0; i < baseTest.getCartProductsAmount(); i++) {
            inventoryPageService.addToCart(0);
        }
        expectedProductInCart = inventoryPageService.getAddedProducts();
        inventoryPageService.clickOnCartButton();
        Thread.sleep(5000);
        actualProductInCart = cartPageService.getCartProductsNameList();
        Assert.assertEquals(actualProductInCart, expectedProductInCart, "Products don't match!");
    }

    @Test(dependsOnMethods = "checkProductInCart")
    public void compareProductPrice() {
        expectedProductPrice = inventoryPageService.getProductsPriceList();
        actualProductPrice = cartPageService.getCartProductsPriceList();
        Assert.assertEquals(actualProductInCart, expectedProductInCart, "Prices don't match!");
    }

    @Test(dependsOnMethods = "compareProductPrice")
    public void fillCheckoutPageFieldsTest() {
        inventoryPageService.clickOnCheckoutButton();
        checkoutPageService.fillCheckoutFields();
        actualNameOfPage = checkoutOverviewPageService.getTextNameOfPage();
        Assert.assertEquals(actualNameOfPage, NAME_OF_CHECKOUT_OVERVIEW_PAGE, "Names of pages don't match!");
    }

    @Test(dependsOnMethods = "fillCheckoutPageFieldsTest")
    public void compareProductPriseWithTotalPriceTest() {
        expectedTotalPrice = 0.0;
        for (int i = 0; i < cartPageService.getCartProductsPriceList().size(); i++) {
            expectedTotalPrice += cartPageService.getCartProductsPriceList().get(i);
        }
        actualTotalPrice = checkoutOverviewPageService.getTotalPrice();
        Assert.assertEquals(actualTotalPrice, expectedTotalPrice, "Total prices don't match!");
    }

    @Test(dependsOnMethods = "compareProductPriseWithTotalPriceTest")
    public void finishTest() {
        checkoutOverviewPageService.clickFinishButton();
        actualNameOfPage = checkoutCompletePageService.getNameOfPage();
        Assert.assertEquals(actualNameOfPage, NAME_OF_CHECKOUT_COMPLETE_PAGE, "Names of pages don't match!");
    }

}
