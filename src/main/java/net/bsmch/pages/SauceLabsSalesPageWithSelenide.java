package net.bsmch.pages;

import net.bsmch.elements.SelenideCheckbox;
import org.openqa.selenium.support.FindBy;

public class SauceLabsSalesPageWithSelenide {
    @FindBy(css = "[value='Error Reporting']")
    public SelenideCheckbox errorReporting;

    @FindBy(css = "[value='API Testing']")
    public SelenideCheckbox apiTesting;
}