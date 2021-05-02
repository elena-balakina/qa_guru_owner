package io.github.ebalakina.owner.config;

import org.aeonbits.owner.Config;

import java.net.URL;

public interface WebDriverConfig extends Config {

    @DefaultValue("false")
    @Key("webdriver.remote")
    boolean isRemote();

    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub/")
    @Key("webdriver.url")
    URL getURL();

    @DefaultValue("CHROME")
    @Key("webdriver.browser")
    BROWSER getBrowser();

    @DefaultValue("86.0")
    @Key("webdriver.browser.version")
    String getBrowserVersion();

    enum BROWSER {
        CHROME,
        FIREFOX,
        OPERA
    }
}
