package net.bsmch.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bsmch.elements.Checkbox;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceLabsSalesPage {
    @FindBy(css = "[value='Error Reporting']")
    private WebElement errorReportingElement;

    @FindBy(css = "[value='API Testing']")
    private WebElement apiTestingElement;

    public SauceLabsSalesPage() {
        var driver = WebDriverManager.chromedriver().getWebDriver();
        PageFactory.initElements(driver, this);
    }

    public Checkbox errorReporting() {
        return new Checkbox(errorReportingElement);
    }

    public Checkbox apiTesting() {
        return new Checkbox(apiTestingElement);
    }
}
