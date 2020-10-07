package ru.severotek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.severotek.ConfProperties;

import java.util.concurrent.TimeUnit;

public class DriverConfigurator {

    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("url") + "admin/");
    }

    public void goToUrl(String url) {
        driver.get(url);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
