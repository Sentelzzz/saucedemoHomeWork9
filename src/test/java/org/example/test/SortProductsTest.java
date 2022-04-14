package org.example.test;

import org.example.service.InventoryPageService;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class SortProductsTest extends BaseTest {

    private InventoryPageService inventoryPageService = new InventoryPageService();
    private List<String> actualListNameOfProducts;
    private List<String> expectedListNameOfProducts;
    private List<Double> actualListPriceOfProducts;
    private List<Double> expectedListPriceOfProducts;

    @BeforeClass
    public void setUp() {
        inventoryPageService = new InventoryPageService();
    }

    @Test
    public void sortAtoZTest() {
        inventoryPageService.login();
        expectedListNameOfProducts = inventoryPageService.getProductNameList();
        Collections.sort(expectedListNameOfProducts);
        inventoryPageService.sortByAtoZ();
        actualListNameOfProducts = inventoryPageService.getProductNameList();
        Assert.assertEquals(actualListNameOfProducts, expectedListNameOfProducts, "Sorting from A to Z doesn't work!");
    }

    @Test (dependsOnMethods = "sortAtoZTest")
    public void sortZtoATest() {
        expectedListNameOfProducts = inventoryPageService.getProductNameList();
        Collections.sort(expectedListNameOfProducts, Collections.<String>reverseOrder());
        inventoryPageService.sortByZtoA();
        actualListNameOfProducts = inventoryPageService.getProductNameList();
        Assert.assertEquals(actualListNameOfProducts, expectedListNameOfProducts, "Sorting from Z to A doesn't work!");
    }

    @Test (dependsOnMethods = "sortZtoATest")
    public void sortLowToHighTest() {
        expectedListPriceOfProducts = inventoryPageService.getProductsPriceList();
        Collections.sort(expectedListPriceOfProducts);
        inventoryPageService.sortByLowToHigh();
        actualListPriceOfProducts = inventoryPageService.getProductsPriceList();
        Assert.assertEquals(actualListPriceOfProducts, expectedListPriceOfProducts, "Sorting from low to high doesn't work!");
    }

    @Test (dependsOnMethods = "sortLowToHighTest")
    public void sortHighToLowTest() {
        expectedListPriceOfProducts = inventoryPageService.getProductsPriceList();
        Collections.sort(expectedListPriceOfProducts, Collections.<Double>reverseOrder());
        inventoryPageService.sortByHighToLow();
        actualListPriceOfProducts = inventoryPageService.getProductsPriceList();
        Assert.assertEquals(actualListPriceOfProducts, expectedListPriceOfProducts, "Sorting from high to low doesn't work!");
    }
}
