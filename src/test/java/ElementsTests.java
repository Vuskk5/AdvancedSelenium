import io.github.bonigarcia.wdm.WebDriverManager;
import net.bsmch.pages.SauceLabsSalesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class ElementsTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    void setup() {
        this.driver = WebDriverManager.chromedriver().create();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    // Add test without checkbox?
    @Test
    void testCheckbox() {
        this.driver.get("https://saucelabs.com/sales");

        var page = new SauceLabsSalesPage();

        page.errorReporting().check();
        page.apiTesting().check();
        page.apiTesting().uncheck();
        page.errorReporting().uncheck();
    }
}
