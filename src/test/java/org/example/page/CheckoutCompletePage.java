package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends Page {

    @FindBy(xpath = "//span[@class='title']")
    private WebElement nameOfPageSpan;

    public String getTextOfNameOfPage() {
        return nameOfPageSpan.getText();
    }
}
