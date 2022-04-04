package org.example.test;

import org.example.page.InventoryPage;
import org.example.service.LoginPageService;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTest extends BaseTest {

    private LoginPageService loginPageService = new LoginPageService();

    @Test
    public void loginTest() {
        InventoryPage inventoryPage = loginPageService.login();
        String actualTextOfNameOOfProductPageSections = inventoryPage.getTextOfNameOfProductPageSection();
        String expectedTextOfNameOfProductPageSections = "PRODUCTS";
        Assert.assertEquals(actualTextOfNameOOfProductPageSections, expectedTextOfNameOfProductPageSections, "The name of page sections doesn't match expected text!");
    }
}
