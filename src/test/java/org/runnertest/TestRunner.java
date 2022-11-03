package org.runnertest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"StepDefinitions"}
        ,plugin = {"pretty",
        "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/cucumber.json"
        },
        publish = true,
        monochrome = true
)

public class TestRunner extends AbstractTestNGCucumberTests {

}