package org.example.test;

import org.example.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;
    protected int cartProductsAmount = 5; // Not more than 6!

    public int getCartProductsAmount() {
        return cartProductsAmount;
    }

    @BeforeTest(alwaysRun = true)
    public void startBrowser() {
        driver = DriverSingleton.getInstance().getDriver();
    }

    @AfterTest
    public void stopBrowser() {
        DriverSingleton.getInstance().closeDriver();
    }
}
