package com.juaracoding.cucumber.stepdefinitions;

import org.openqa.selenium.WebDriver;



import com.aventstack.extentreports.Status;
import com.juaracoding.cucumber.driver.DriverManager;
import com.juaracoding.cucumber.pages.CartPage;
// import com.aventstack.extentreports.gherkin.model.When;
import com.juaracoding.cucumber.pages.InventoryPage;
import com.juaracoding.cucumber.reports.ExtentTestManager;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.testng.Assert;


public class AddToCartSteps {

    private final WebDriver driver = DriverManager.getDriver();
    private final InventoryPage inventoryPage = new InventoryPage(driver);
    private final CartPage cartPage = new CartPage(driver);
    
    @When("Pengguna memilih produk {string} untuk ditambahkan ke keranjang")
    public void userChooseProductName(String productName){
        inventoryPage.addProductToCart(productName);
        ExtentTestManager.getTest().log(Status.INFO, "Pengguna memilih produk" + productName + "untuk ditambahkan ke keranjang");
    }

    @When("Ikon keranjang belanja menampilkan angka {string}")
    public void cartIconShowBadgeCount(String expectedCount){
        String actualCount = inventoryPage.getCartItemCount();
        Assert.assertEquals(actualCount, expectedCount);
        ExtentTestManager.getTest().log(Status.INFO, "Ikon keranjang belanja menampilkan angka" + expectedCount);
    }

    @Then("Pengguna membuka halaman keranjang belanja")
    public void userVewCartPage(){
        inventoryPage.openCart();
        ExtentTestManager.getTest().log(Status.INFO, "Pengguna membuka halaman keranjang belanja");
    }

    @Then("Produk {string} terdaftar di dalam daftar keranjang belanja")
    public void listProduct(String expectedProductName){
        String actualCount = cartPage.getTxtProductName();
        Assert.assertEquals(actualCount, expectedProductName);
        ExtentTestManager.getTest().log(Status.INFO, "Produk" + expectedProductName + "terdaftar di dalam daftar keranjang belanja");
    }
}
