package org.example.service;

import org.example.page.CheckoutCompletePage;

public class CheckoutCompletePageService {

    CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage();

    public String getNameOfPage() {
        return checkoutCompletePage.getTextOfNameOfPage();
    }
}
