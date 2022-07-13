package net.bsmch.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {
    @FindBy(className = "product_sort_container")
    private WebElement inventorySort;

    public InventoryPage() {
        WebDriver driver = WebDriverManager.chromedriver().getWebDriver();
        PageFactory.initElements(driver, this.getClass());
    }

    public InventoryPage sortLowToHigh() {
        new Select(this.inventorySort).selectByValue("lohi");
        return this;
    }

    public InventoryPage sortHighToLow() {
        new Select(this.inventorySort).selectByValue("hilo");
        return this;
    }
}
