package com.juaracoding.cucumber.pages;

import com.juaracoding.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Page Object Model dengan Selenium PageFactory untuk Halaman Katalog Produk.
 */
public class CartPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(className = "inventory_item_name")
    private WebElement txtProductName;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        // this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    public String getTxtProductName() {
        wait.until(ExpectedConditions.visibilityOf(txtProductName));
        return txtProductName.getText();
    }

    public void clickCheckoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}

// mvn clean test '-Dcucumber. filter.tags="@Smoke"'
// ecommerce sedang ada penambahan fitur dibagian checkout, buat gherkin dan tandai tags @Regression


