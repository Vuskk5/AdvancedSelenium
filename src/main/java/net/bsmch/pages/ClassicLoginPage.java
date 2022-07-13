package net.bsmch.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * A normal page object, driver is passed to constructor.
 */
public class ClassicLoginPage {
    private static final String URL = "https://www.saucedemo.com/";
    private final WebDriver driver;

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public ClassicLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this.getClass());
    }

    public void open() {
        this.driver.get(URL);
    }

    public void login(String username, String password) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }
}
