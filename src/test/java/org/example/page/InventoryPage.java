package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends  Page {

    @FindBy (xpath = "//span[@class='title']")
    private WebElement nameOfProductPageSection;

    public String getTextOfNameOfProductPageSection() {
        return nameOfProductPageSection.getText();
    }
}
