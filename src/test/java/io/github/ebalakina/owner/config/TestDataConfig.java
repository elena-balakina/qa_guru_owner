package io.github.ebalakina.owner.config;

import org.aeonbits.owner.Config;

public interface TestDataConfig extends Config {

    @DefaultValue("https://github.com")
    @Key("base.url")
    String baseUrl();
}
