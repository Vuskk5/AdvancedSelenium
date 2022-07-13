package net.bsmch.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * A better page object, no passing driver around, method chaining is available.
 */
public class FluentLoginPage {
    private static final String URL = "https://www.saucedemo.com/";
    private final WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public FluentLoginPage() {
        this.driver = WebDriverManager.chromedriver().getWebDriver();
        PageFactory.initElements(this.driver, this.getClass());
    }

    public FluentLoginPage open() {
        this.driver.get(URL);

        return this;
    }

    public InventoryPage login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();

        return new InventoryPage();
    }
}
