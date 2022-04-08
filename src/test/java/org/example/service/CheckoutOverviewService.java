package org.example.service;

import org.example.page.CheckoutOverview;

public class CheckoutOverviewService {

    private CheckoutOverview checkoutOverview = new CheckoutOverview();

    public String getTextNameOfPage() {
        return checkoutOverview.getTextOfPageName();
    }
}
