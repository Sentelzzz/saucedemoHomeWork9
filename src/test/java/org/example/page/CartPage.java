package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends Page {

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private WebElement productPrice;

    @FindBy(xpath = "//button[@class='btn btn_action btn_medium checkout_button']")
    private WebElement checkoutCartButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement productName;

    public String getTextOfProductName() {
        return productName.getText();
    }

    public void clickOnCheckoutButton() {
        checkoutCartButton.click();
    }

    public String getTextOfProductPrice() {
        return productPrice.getAttribute("innerText");
    }
}
