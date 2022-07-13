import io.github.bonigarcia.wdm.WebDriverManager;
import net.bsmch.drivermanager.DriverManager;
import net.bsmch.pages.ClassicLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DriverManagerTests {
    // Worst - No management, driver is passed around
    @Test
    void testWithoutManager() {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        ClassicLoginPage page = new ClassicLoginPage(driver);
        page.open();
        page.login("standard_user", "secret_sauce");
    }


    // Good - Basic management
    @Test
    void testWithCustomManager() {
        ClassicLoginPage page = new ClassicLoginPage(DriverManager.getWebDriver());
        page.open();
        page.login("standard_user", "secret_sauce");
    }


    // Best - Using WebDriverManager, can use proxy, choose any driver we want...
    @Test
    void testWithWebDriverManager() {
        ClassicLoginPage page = new ClassicLoginPage(WebDriverManager.chromedriver().getWebDriver());
        page.open();
        page.login("standard_user", "secret_sauce");
    }
}
