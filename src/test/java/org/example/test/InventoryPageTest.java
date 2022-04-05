package org.example.test;

import org.example.page.InventoryPage;
import org.example.service.InventoryPageService;
import org.example.service.LoginPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseTest {

    private InventoryPageService inventoryPageService;
    private InventoryPage inventoryPage = new InventoryPage();
    private LoginPageService loginPageService;


    @Test
    public void addToCartTest () {
        inventoryPageService = new InventoryPageService();
        inventoryPageService.addToCartBackPack();
        String expectedNumberAddedThingsInString = ((Integer)inventoryPageService.getNumberOfPositions()).toString();
        Assert.assertEquals (inventoryPageService.getText(), expectedNumberAddedThingsInString, "Number of added things doesn't match!");
    }

    @Test
    public void removeCartTest () {
        inventoryPageService = new InventoryPageService();
        inventoryPageService.addToCartBikeLight();
        inventoryPageService.removeBikeLight();
        String expectedNumberAddedThings = "";
        Assert.assertEquals (inventoryPageService.getText(), expectedNumberAddedThings, "Number of added things doesn't match!");
    }

    /*@Test
    public void addTwoAndRemoveOneThingTest () {
        inventoryPageService.addTwoThingsRemoveOne();
        String actualNumberAddedThingsInString = ((Integer)inventoryPageService.getNumberOfPositions()).toString();
        Assert.assertEquals (actualNumberAddedThingsInString, inventoryPageService.getText(), "Number of added things doesn't match!");
    }*/

    /*@Test (priority = 4)
    public void openReactMenuTest () {
        inventoryPageService.openReactMenu();
        String actualValue = inventoryPage.getAttributeReactMenu();
        String expectedValue = "false";
        Assert.assertEquals(actualValue, expectedValue, "Window doesn't open!");
    }

    @Test (priority = 5)
    public void getReactMenuListTest () {
        String actualReactMenuList = inventoryPage.getTextReactMenuList();
        String expectedReactMenuList = "ALL ITEMS\nABOUT\nLOGOUT\nRESET APP STATE";
        inventoryPage.clickCrossButtonReactMenu();
        Assert.assertEquals(actualReactMenuList, expectedReactMenuList, "React Menu list doesn't match!");
    }*/
}
