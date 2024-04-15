package com.automation.steps.stepDefinations;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/automation/steps/features"},
        glue = {"com/automation/steps/stepDefinations"},
        plugin = {"summary", "pretty", "html:target/cucumber-reports.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@searchForHotel",
        monochrome = true)

public class SearchHotelTestRunner {

}
