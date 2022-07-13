import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static net.bsmch.locators.NewLocators.dataTestId;

public class LocatorsTests {
    private WebDriver driver;
    private WebDriverWait wait;

    // https://stackoverflow.com/a/49913957/11758880
    public String getFile(String fileName) {
        String filePath = null;
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            filePath= classLoader.getResource(fileName).getPath();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  "file://"+filePath;
    }

    @BeforeClass
    void setup() {
        this.driver = WebDriverManager.chromedriver().create();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(8));
    }

    @Test
    void testLocators() {
        // Open html file from project
        this.driver.get(getFile("page.html"));

        // Find the element using Selenium
        var element = this.driver.findElement(By.cssSelector("[data-test-id='TestData']"));
        assert "Hello World".equals(element.getText());
    }











    @Test
    void testNewLocators() {
        // Open html file from project
        this.driver.get(getFile("page.html"));

        // Using the new expected condition
        var element = this.driver.findElement(dataTestId("TestData"));
        assert "Hello World".equals(element.getText());
    }
}
