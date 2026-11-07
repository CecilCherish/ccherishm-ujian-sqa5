package com.juaracoding.cucumber.stepdefinitions;

import com.aventstack.extentreports.Status;
import com.juaracoding.cucumber.driver.DriverManager;
import com.juaracoding.cucumber.pages.CartPage;
import com.juaracoding.cucumber.pages.CheckoutPage;
import com.juaracoding.cucumber.reports.ExtentTestManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutSteps {

    private final WebDriver driver = DriverManager.getDriver();
    private final CheckoutPage checkoutPage = new CheckoutPage(driver);
    private final CartPage cartPage = new CartPage(driver);

    @When("Pengguna mengklik tombol Checkout")
    public void penggunaMengklikTombolCheckout() {
        cartPage.clickCheckoutButton();
        ExtentTestManager.getTest().log(Status.INFO, "Mengklik tombol Checkout");
    }

    @When("Pengguna mengisi First Name {string}")
    public void penggunaMengisiFirstName(String firstName) {
        checkoutPage.enterFirstName(firstName);
        ExtentTestManager.getTest().log(Status.INFO, "Mengisi First Name: " + firstName);
    }

    @And("Pengguna mengisi Last Name {string}")
    public void penggunaMengisiLastName(String lastName) {
        checkoutPage.enterLastName(lastName);
        ExtentTestManager.getTest().log(Status.INFO, "Mengisi Last Name: " + lastName);
    }

    @And("Pengguna mengisi Postal Code {string}")
    public void penggunaMengisiPostalCode(String postalCode) {
        checkoutPage.enterPostalCode(postalCode);
        ExtentTestManager.getTest().log(Status.INFO, "Mengisi input Postal Code: " + postalCode);
    }

    @And("Pengguna mengosongkan Postal Code")
    public void penggunaMengosongkanPostalCode() {
        checkoutPage.enterPostalCode("");
        ExtentTestManager.getTest().log(Status.INFO, "Mengosongkan input Postal Code");
    }

    @And("Pengguna mengklik tombol Continue")
    public void penggunaMengklikTombolContinue() {
        checkoutPage.clickContinueButton();
        ExtentTestManager.getTest().log(Status.INFO, "Mengklik tombol Continue");
    }

    @Then("Pengguna berhasil diarahkan ke halaman checkout")
    public void penggunaBerhasilDiarahkanKeHalamanIkhtisarCheckout() {
        Assert.assertTrue(checkoutPage.isOverviewPageLoaded(), "Halaman ikhtisar checkout gagal dimuat");
        ExtentTestManager.getTest().log(Status.PASS, "Pengguna berhasil diarahkan ke halaman checkout: " + checkoutPage.getPageTitleText());
    }

    @Then("Sistem menampilkan pesan kesalahan checkout {string}")
    public void sistemMenampilkanPesanKesalahanCheckout(String expectedErrorMessage) {
        String actualError = checkoutPage.getErrorMessageText();
        Assert.assertTrue(actualError.contains(expectedErrorMessage),
                "Pesan error aktual '" + actualError + "' tidak memuat '" + expectedErrorMessage + "'");
        ExtentTestManager.getTest().log(Status.PASS, "Verifikasi pesan error checkout berhasil: " + actualError);
    }
}