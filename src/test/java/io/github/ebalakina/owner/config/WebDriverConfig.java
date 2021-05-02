package io.github.ebalakina.owner.config;

import org.aeonbits.owner.Config;

import java.net.URL;

import static org.aeonbits.owner.Config.LoadType.MERGE;

@Config.LoadPolicy(MERGE)
@Config.Sources({"system:properties",
        "classpath:${driver}_webdriver.properties",
        "classpath:remote_webdriver.properties"})
public interface WebDriverConfig extends Config {

    @Key("webdriver.remote")
    boolean isRemote();

    @Key("webdriver.url")
    URL getURL();

    @Key("webdriver.browser")
    BROWSER getBrowser();

    @Key("webdriver.browser.version")
    String getBrowserVersion();

    enum BROWSER {
        CHROME,
        FIREFOX,
        OPERA
    }
}
