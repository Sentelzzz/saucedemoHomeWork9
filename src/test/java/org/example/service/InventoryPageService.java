package org.example.service;

import org.example.page.CartPage;
import org.example.page.InventoryPage;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InventoryPageService extends LoginPageService {

    private InventoryPage inventoryPage = new InventoryPage();
    private CartPage cartPage = new CartPage();

    @Override
    public InventoryPage login() {
        return super.login();
    }

    public void addToCart(int number) {
        inventoryPage.addToCart(number);
    }

    public String getActualNumberInCart() {
        return inventoryPage.getTextNumberOfThingsInCart();
    }

    public void removeToCart(int number) {
        inventoryPage.removeToCart(number);
    }

    public void openReactMenu() {
        inventoryPage.clickOnReactMenuButton();
    }

    public String getTextOfFieldsReactMenu() {
        return inventoryPage.getTextOfFieldsOfReactMenu();
    }

    public void closeReactMenu() {
        inventoryPage.clickOnReactMenuCrossButton();
    }

    public String checkOpenOrCloseReactMenu() {
        return inventoryPage.getTextAboutReactMenuState();
    }

    public void sortByAtoZ() {
        Select select = new Select(inventoryPage.getFilterSelect());
        select.selectByVisibleText("Name (A to Z)");
    }

    public List<String> getProductNameList() {
        List<String> productsList = new ArrayList<>();
        for (int i = 0; i < inventoryPage.getProductsList().size(); i++) {
            productsList.add(inventoryPage.getProductsList().get(i).getText());
        }
        return productsList;
    }

    public void sortByZtoA() {
        Select select = new Select(inventoryPage.getFilterSelect());
        select.selectByVisibleText("Name (Z to A)");
    }

    public List<Double> getProductsPriceList() {
        List<Double> productsPriceList = new ArrayList<>();
        for (int i = 0; i < inventoryPage.getProductPriceList().size(); i++) {
            productsPriceList.add(Double.parseDouble(inventoryPage.getProductPriceList().get(i).getText().replaceAll("[^0-9.]", "")));
        }
        return productsPriceList;
    }

    public void sortByLowToHigh() {
        Select select = new Select(inventoryPage.getFilterSelect());
        select.selectByVisibleText("Price (low to high)");
    }

    public void sortByHighToLow() {
        Select select = new Select(inventoryPage.getFilterSelect());
        select.selectByVisibleText("Price (high to low)");
    }

    public void clickOnCartButton() {
        inventoryPage.clickOnCart();
    }

    public void clickOnCheckoutButton() {
        cartPage.clickOnCheckoutButton();
    }


}
