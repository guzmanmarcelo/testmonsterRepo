package org.example.hooks;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Hooks {

    @Before(value = "@UI", order = 1)
    public void beforeScenario() {
        setBrowserConfiguration();
    }

    @After(value = "@UI", order = 1)
    public void afterScenario() {
        closeWebDriver();
    }

    /**
     * Sets the browser config value
     */
    private void setBrowserConfiguration() {
        Configuration.browser = "Chrome";
        Configuration.timeout = 20000;
        Configuration.pageLoadTimeout = 30000;
        Configuration.screenshots = true;
    }
}
