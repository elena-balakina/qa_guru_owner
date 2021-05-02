package io.github.ebalakina.owner.tests;

import io.github.ebalakina.owner.config.TestDataConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeEach;

import static io.github.ebalakina.owner.helpers.WebDriverHelper.configureDriver;

public class BaseTest {

    public static final TestDataConfig testDataConfig = ConfigFactory.create(TestDataConfig.class, System.getProperties());

    @BeforeEach
    void setup() {
        configureDriver(testDataConfig.baseUrl());
    }
}
