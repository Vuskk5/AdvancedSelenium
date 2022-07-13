package net.bsmch;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.IExecutionListener;

public class DriverSetup implements IExecutionListener {
    @Override
    public void onExecutionStart() {
//        System.setProperty("webdriver.chrome.driver", "/path/to/.exe");
        WebDriverManager.chromedriver().setup();
    }
}
