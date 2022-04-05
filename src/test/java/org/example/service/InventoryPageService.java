package org.example.service;

import org.example.model.Inventory;
import org.example.page.InventoryPage;

public class InventoryPageService extends LoginPageService {

    private Inventory inventory = new Inventory();
    private InventoryPage inventoryPage = new InventoryPage();
    static Integer numberOfPositions;

    public int getNumberOfPositions() {
        return numberOfPositions;
    }


    public InventoryPage addToCartBackPack() {
        numberOfPositions = 0;
        inventoryPage = login();
        inventoryPage.clickButtonAddSauceBackPack();
        numberOfPositions++;
        return new InventoryPage();
    }

    public String getText() {
        return inventoryPage.getTextOfNumberThingsInCart();
    }

    public InventoryPage addToCartBikeLight() {
        inventoryPage = login();
        numberOfPositions = 0;
        inventoryPage.clickButtonAddSauceBikeLight();
        numberOfPositions++;
        return new InventoryPage();
    }

    public void removeBikeLight() {
        inventoryPage.clickButtonRemoveSauceBikeLight();
        numberOfPositions--;
    }

    public void addTwoThingsRemoveOne() {
        inventoryPage = login();
        numberOfPositions = 0;
        inventoryPage.clickButtonAddSauceBackPack();
        numberOfPositions++;
        inventoryPage.clickButtonAddSauceBikeLight();
        numberOfPositions++;
        inventoryPage.clickButtonRemoveSauceBikeLight();
        numberOfPositions--;
    }

    public InventoryPage openReactMenu() {
        inventoryPage.clickButtonReactMenu();
        return new InventoryPage();
    }


}
