package org.example.test;

import org.example.service.InventoryPageService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReactMenuTest extends BaseTest {

    private InventoryPageService inventoryPageService = new InventoryPageService();
    private String expectedFieldsReactMenu;
    private String actualFieldsReactMenu;

    @Test
    public void reactMenuFieldsTest() {
        inventoryPageService.login();
        inventoryPageService.openReactMenu();
        expectedFieldsReactMenu = "ALL ITEMS\nABOUT\nLOGOUT\nRESET APP STATE\nClose Menu";
        actualFieldsReactMenu = inventoryPageService.getTextOfFieldsReactMenu();
        Assert.assertEquals(actualFieldsReactMenu, expectedFieldsReactMenu, "Fields don't match!" );
    }

    @Test (dependsOnMethods = "reactMenuFieldsTest")
    public void reactMenuCloseTest() {
        inventoryPageService.closeReactMenu();
        expectedFieldsReactMenu = "true";
        actualFieldsReactMenu = inventoryPageService.checkOpenOrCloseReactMenu();
        Assert.assertEquals(actualFieldsReactMenu, expectedFieldsReactMenu, "React menu doesn't close!");
    }
}
