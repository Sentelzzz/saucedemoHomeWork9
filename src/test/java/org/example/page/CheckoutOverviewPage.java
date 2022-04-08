package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends Page {

    @FindBy (xpath = "//span[@class='title']")
    private WebElement pageTitleSpan;

    @FindBy (xpath = "//div[@class='inventory_item_price']")
    private WebElement productsPrice;

    @FindBy (xpath = "//div[@class='summary_subtotal_label']")
    private WebElement totalPrice;

    @FindBy (xpath = "//button[@id='finish']")
    private WebElement finishButton;

    public void clickFinishButton() {
        finishButton.click();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    public String getTextOfPageName() {
        return pageTitleSpan.getText();
    }
}
