package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class InventoryPage extends Page {

    @FindBy(xpath = "//span[@class='title']")
    private WebElement nameOfProductPageSection;

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    private List<WebElement> addToCartButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartLinkA;

    @FindBy(xpath = "//button[@class='btn btn_secondary btn_small btn_inventory']")
    private List<WebElement> removeToCartButton;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement reactMenuButton;

    @FindBy(xpath = "//div[@class='bm-menu-wrap']")
    private WebElement reactMenuDiv;

    @FindBy(xpath = "//button[@id='react-burger-cross-btn']")
    private WebElement reactMenuCrossButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> productsList;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement filterSelect;

    @FindBy (xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> productPriceList;

    public void clickOnCart() {
        cartLinkA.click();
    }

    public List<WebElement> getProductPriceList() {
        return productPriceList;
    }

    public WebElement getFilterSelect() {
        return filterSelect;
    }

    public List<WebElement> getProductsList() {
        return productsList;
    }

    public String getTextAboutReactMenuState() {
        return reactMenuDiv.getAttribute("aria-hidden");
    }

    public void clickOnReactMenuCrossButton() {
        reactMenuCrossButton.click();
    }

    public String getTextOfFieldsOfReactMenu() {
        return reactMenuDiv.getAttribute("innerText");
    }

    public void clickOnReactMenuButton() {
        reactMenuButton.click();
    }

    public void removeToCart(int number) {
        removeToCartButton.get(number).click();
    }

    public String getTextNumberOfThingsInCart() {
        return cartLinkA.getAttribute("innerText");
    }

    public void addToCart(int number) {
        addToCartButton.get(number).click();
    }

    public String getTextOfNameOfProductPageSection() {
        return nameOfProductPageSection.getText();
    }




}
