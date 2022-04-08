package org.example.service;

import org.example.model.User;
import org.example.page.CheckoutPage;

public class CheckoutPageService {

    private User user = new User();
    private CheckoutPage checkoutPage = new CheckoutPage();

    public void fillCheckoutFields() {
        checkoutPage.fillFirstNameField(user.getFirstName())
                .fillLastNameField(user.getLastName())
                .fillZipCodeField(user.getUserZipCode());
        checkoutPage.clickOnContinue();
    }

}
