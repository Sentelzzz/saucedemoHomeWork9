package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends Page {

    @FindBy(xpath = "//span[@class='title']")
    private WebElement nameOfProductPageSection;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement buttonAddSauceBackpack;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement indicatorOfCart;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']")
    private WebElement buttonRemoveSauceBackpack;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement buttonAddSauceBikeLight;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")
    private WebElement buttonRemoveSauceBikeLight;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement buttonReactMenu;

    @FindBy (xpath = "//div[@class='bm-menu-wrap']")
    private WebElement reactMenu;

    @FindBy (xpath = "//nav[@class='bm-item-list']")
    private WebElement reactMenuList;

    @FindBy (xpath = "//button[@id='react-burger-cross-btn']")
    private WebElement crossButton;

    public String getTextOfNameOfProductPageSection() {
        return nameOfProductPageSection.getText();
    }

    public void clickButtonAddSauceBackPack() {
        buttonAddSauceBackpack.click();
    }

    public String getTextOfNumberThingsInCart() {
        return indicatorOfCart.getAttribute("innerText");
    }

    public void clickButtonRemoveSauceBackpack() {
        buttonRemoveSauceBackpack.click();
    }

    public void clickButtonAddSauceBikeLight() {
        buttonAddSauceBikeLight.click();
    }

    public void clickButtonRemoveSauceBikeLight() {
        buttonRemoveSauceBikeLight.click();
    }

    public void clickButtonReactMenu() {
        buttonReactMenu.click();
    }

    public String getAttributeReactMenu () {
        return reactMenu.getAttribute("ariaHidden");
    }

    public String getTextReactMenuList () {
        return reactMenuList.getAttribute("outerText");
    }

    public void clickCrossButtonReactMenu () {
        crossButton.click();
    }
    
    public void clickCartButton () {
        indicatorOfCart.click();
    }

}
