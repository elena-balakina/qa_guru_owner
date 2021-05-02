package io.github.ebalakina.owner.tests;

import io.github.ebalakina.owner.config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;

public class WebDriverTest {

    WebDriver driver;

    @BeforeEach
    public void initDriver() throws MalformedURLException {
        System.setProperty("webdriver.remote", "true");
        System.setProperty("webdriver.url", "https://user1:1234@selenoid.autotests.cloud/wd/hub/");
        System.setProperty("webdriver.browser", "CHROME");
//        System.setProperty("webdriver.browser", "FIREFOX");
//        System.setProperty("webdriver.browser", "OPERA");

        WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        initWebDriver(config);
    }

    @Test
    public void testWebDriver() {
        driver.get("https://github.com");
        Assertions.assertEquals("GitHub: Where the world builds software · GitHub", driver.getTitle());
        driver.quit();
    }

    private void initWebDriver(WebDriverConfig config) {
        if (config.isRemote()) {
            DesiredCapabilities capabilities;
            switch (config.getBrowser()) {
                case CHROME: {
                    capabilities = DesiredCapabilities.chrome();
                    break;
                }
                case FIREFOX: {
                    capabilities = DesiredCapabilities.firefox();
                    break;
                }
                case OPERA: {
                    capabilities = DesiredCapabilities.opera();
                    break;
                }
                default: {
                    capabilities = DesiredCapabilities.chrome();
                }
            }

            driver = new RemoteWebDriver(config.getURL(), capabilities);
        } else {
            driver = new ChromeDriver();
        }
    }
}
