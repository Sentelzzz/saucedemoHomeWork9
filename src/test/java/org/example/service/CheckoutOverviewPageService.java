package org.example.service;

import org.example.page.CheckoutOverviewPage;

public class CheckoutOverviewPageService {

    private CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();

    public String getTextNameOfPage() {
        return checkoutOverviewPage.getTextOfPageName();
    }

    public Double getTotalPrice() {
        return Double.parseDouble(checkoutOverviewPage.getTotalPrice().replaceAll("[^0-9.]", ""));
    }

    public void clickFinishButton() {
        checkoutOverviewPage.clickFinishButton();
    }
}
