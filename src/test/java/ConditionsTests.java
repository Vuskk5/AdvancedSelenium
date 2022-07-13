import io.github.bonigarcia.wdm.WebDriverManager;
import net.bsmch.pages.SauceLabsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static net.bsmch.conditions.NewConditions.textNumberToBeMoreThan;

public class ConditionsTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    void setup() {
        this.driver = WebDriverManager.chromedriver().create();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    @Test
    void testWithoutCondition() {
        this.driver.get("https://saucelabs.com/");

        var page = new SauceLabsPage(this.driver);
        var testCount = page.testCount();

        System.out.println("Test count: " + testCount);

        // Use lambda function
        this.wait.until((driver) -> {
            var text = driver.findElement(By.className("ticker")).getText();
            var count = Long.parseLong(text.replace(",", ""));
            return count >= testCount + 50;
        });
    }









    @Test
    void testNewCondition() {
        this.driver.get("https://saucelabs.com/");

        var page = new SauceLabsPage(this.driver);
        var count = page.testCount();

        System.out.println("Test count: " + count);

        this.wait.until(textNumberToBeMoreThan(By.className("ticker"), count + 50));
    }
}
