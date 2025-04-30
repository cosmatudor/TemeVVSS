package org.example.saucedemo.scenario;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.example.pages.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CompletePurchaseTest {

    @Managed
    WebDriver driver;

    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OrderConfirmationPage orderConfirmationPage;

    @Test
    public void userShouldBeAbleToLoginAddProductCheckoutAndLogout() {
        // 1. LOGIN
        loginPage.open();
        loginPage.loginAs("standard_user", "secret_sauce");
        productsPage.shouldBeOnProductsPage(); // ✅ validare după login

        // 2. ADD PRODUCT TO CART
        productsPage.addFirstProductToCart();
        productsPage.cartBadgeShouldShow("1"); // ✅ validare că produsul a fost adăugat

        // 3. PROCEED TO CART
        productsPage.goToCart();
        cartPage.shouldContainOneProduct(); // ✅ validare că produsul e în coș

        // 4. CHECKOUT
        cartPage.proceedToCheckout();
        checkoutPage.shouldBeOnCheckoutPage(); // ✅ validare că s-a deschis formularul

        checkoutPage.enterCheckoutInfo("John", "Doe", "12345");
        checkoutPage.finishOrder();
        orderConfirmationPage.shouldSeeThankYouMessage(); // ✅ validare comandă plasată

        // 5. LOGOUT
        orderConfirmationPage.logout();
        loginPage.shouldBeOnLoginPage(); // ✅ validare că s-a revenit la login
    }

}
