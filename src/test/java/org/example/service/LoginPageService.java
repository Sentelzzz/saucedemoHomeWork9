package org.example.service;

import org.example.model.User;
import org.example.page.InventoryPage;
import org.example.page.LoginPage;

public class LoginPageService {

    private static final String LOGIN_PAGE_URL = "https://www.saucedemo.com/";
    private LoginPage loginPage = new LoginPage();
    private User user = new User();

    public InventoryPage login() {
        loginPage.openPage(LOGIN_PAGE_URL)
                .fillUsernameField(user.getName())
                .fillPasswordField(user.getPassword())
                .clickLoginButton();
        return new InventoryPage();
    }
}
