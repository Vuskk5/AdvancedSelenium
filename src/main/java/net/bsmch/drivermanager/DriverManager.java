package net.bsmch.drivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    static {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
    }

    private static final ThreadLocal<WebDriver> instance = new ThreadLocal<>();

    /**
     * Get the driver instance, a new instance will be created if current thread has no driver.
     * @return a WebDriver instance
     */
    public static WebDriver getWebDriver() {
        if (instance.get() == null) {
            instance.set(new ChromeDriver());
        }

        return instance.get();
    }
}
