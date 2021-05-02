package io.github.ebalakina.owner.helpers;

import com.codeborne.selenide.Configuration;
import io.github.ebalakina.owner.config.WebDriverConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class WebDriverHelper {
    private static final WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public static boolean isRemote() {
        return config.isRemote();
    }

    public static String getSessionId() {
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString().replace("selenoid", "");
    }

    public static void configureDriver(String baseUrl) {
        Configuration.baseUrl = baseUrl;
        Configuration.browser = config.getBrowser().toString();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.timeout = 4000;

        if (isRemote()) {
            Configuration.remote = config.getURL().toString();
        }
    }
}
