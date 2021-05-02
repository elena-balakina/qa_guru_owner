package io.github.ebalakina.owner.tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class GitHubTests extends BaseTest{

    @Test
    public void testWebDriver() {
        open("");
        Assertions.assertEquals("GitHub: Where the world builds software · GitHub", Selenide.title());
    }
}
