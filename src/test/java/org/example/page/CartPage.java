package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends Page {

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> productsPrice;

    @FindBy(xpath = "//button[@class='btn btn_action btn_medium checkout_button']")
    private WebElement checkoutCartButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> productsName;

    public List<WebElement> getProductsName() {
        return productsName;
    }

    public void clickOnCheckoutButton() {
        checkoutCartButton.click();
    }

    public List<WebElement> getProductsPrice() {
        return productsPrice;
    }
}
