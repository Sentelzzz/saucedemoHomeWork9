package org.example.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends Page {

    @FindBy (xpath = "//input[@id='first-name']")
    private WebElement firstNameFieldInput;

    @FindBy (xpath = "//input[@id='last-name']")
    private WebElement lastNameFieldInput;

    @FindBy (xpath = "//input[@id='postal-code']")
    private WebElement postalCodeInput;

    @FindBy (xpath = "//input[@id='continue']")
    private WebElement continueButtonInput;

    public CheckoutPage fillFirstNameField(String firstname) {
        firstNameFieldInput.clear();
        firstNameFieldInput.sendKeys(firstname);
        return this;
    }

    public CheckoutPage fillLastNameField(String lastname) {
        lastNameFieldInput.clear();
        lastNameFieldInput.sendKeys(lastname);
        return this;
    }

    public CheckoutPage fillZipCodeField(String zipcode) {
        postalCodeInput.clear();
        postalCodeInput.sendKeys(zipcode);
        return this;
    }

    public void clickOnContinue() {
        continueButtonInput.click();
    }
}
