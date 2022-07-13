package net.bsmch.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLabsPage {
    @FindBy(className = "ticker")
    private WebElement testCounter;

    public SauceLabsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public long testCount() {
        return Long.parseLong(testCounter.getText().replace(",", ""));
    }
}
