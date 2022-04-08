package org.example.test;

import org.example.page.CheckoutOverview;
import org.example.service.CartPageService;
import org.example.service.CheckoutPageService;
import org.example.service.InventoryPageService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrderTest extends BaseTest {

    private InventoryPageService inventoryPageService = new InventoryPageService();
    private CartPageService cartPageService = new CartPageService();
    private CheckoutPageService checkoutPageService = new CheckoutPageService();
    private CheckoutOverview checkoutOverview = new CheckoutOverview();
    private final String nameOfCheckoutOverviewPage = "Checkout: Overview";
    private final Integer numberForAddedProductToCart = 2;
    private final static  Integer numberOfProductInCart = 0;
    private String expectedProductInCart;
    private String actualProductInCart;
    private Double expectedProductPrice;
    private Double actualProductPrice;
    private String expectedNameOfPage;
    private String actualNameOfPage;

    @Test
    public void checkProductInCart() {
        inventoryPageService.login();
        inventoryPageService.addToCart(numberForAddedProductToCart);
        expectedProductInCart = inventoryPageService.getProductNameList().get(numberForAddedProductToCart);
        inventoryPageService.clickOnCartButton();
        actualProductInCart = cartPageService.getTextOfProductNameInCart();
        Assert.assertEquals(actualProductInCart, expectedProductInCart, "Products don't match!");
    }

    @Test (dependsOnMethods = "checkProductInCart")
    public void compareProductPrice() {
        expectedProductPrice = inventoryPageService.getProductsPriceList().get(numberOfProductInCart);
        actualProductPrice = (Double.parseDouble(cartPageService.getProductPrice().replaceAll("[^0-9.]", "")));
        Assert.assertEquals(actualProductInCart, expectedProductInCart, "Prices don't match!");
    }

    @Test (dependsOnMethods = "compareProductPrice")
    public void fillCheckoutPageFieldsTest() {
        inventoryPageService.clickOnCheckoutButton();
        checkoutPageService.fillCheckoutFields();
        expectedNameOfPage = nameOfCheckoutOverviewPage;
        actualNameOfPage = checkoutOverview.getTextOfPageName();
        Assert.assertEquals(actualProductInCart, expectedProductInCart, "Names of pages don't match!");
    }

    /*@Test (dependsOnMethods = "fillCheckoutPageFieldsTest")
    public void compareProductPriseWithTotalPriceTest() {

    }*/

}
