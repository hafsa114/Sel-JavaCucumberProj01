package org.runnertest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        plugin = {"json:target/cucumber.json","pretty",
                "html:target/cucumber-pretty"

        },

        features = {"src/test/resources/features"},
        glue = {"StepDefinitions"},
        tags = "@CoinMarketAppTests"
)

public class TestRunner extends AbstractTestNGCucumberTests {

}