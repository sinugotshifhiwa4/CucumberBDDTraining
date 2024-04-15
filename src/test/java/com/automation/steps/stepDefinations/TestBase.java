package com.automation.steps.stepDefinations;

import com.automation.steps.components.HandleExceptions;
import com.automation.steps.components.PropertiesConfiguration;
import com.automation.steps.components.WebActions;
import com.automation.steps.utilities.BrowserFactory;
import com.automation.steps.utilities.DriverFactory;
import com.automation.steps.utilities.SeleniumGridBrowserFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

public class TestBase extends WebActions {

    @Before
    public void setUp(){

        System.out.println("Setting up test environment...");

        try{
            //BrowserFactory browserFactory = new BrowserFactory();
            SeleniumGridBrowserFactory seleniumGridBrowserFactory = new SeleniumGridBrowserFactory();

            String sBrowser = PropertiesConfiguration.getValueByKey("browser");
            String sUrl = PropertiesConfiguration.getValueByKey("browserUrl");

            //DriverFactory.getInstance().setDriver(browserFactory.createBrowserInstance(sBrowser));
            DriverFactory.getInstance().setDriver(seleniumGridBrowserFactory.createSeleniumGridBrowserInstance(sBrowser));
            WebDriver driver = DriverFactory.getInstance().getDriver();

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(sUrl);

            System.out.println("Setting is complete for test environment...");

        } catch (IOException e) {
            HandleExceptions.handleException("setUp", e);
        }
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date date = new Date();

        String formatDate = simpleDateFormat.format(date);

        final byte [] screenshot = ((TakesScreenshot) DriverFactory.getInstance().getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "screenshot-" + formatDate);
    }

    @After
    public void tearDown(){

        DriverFactory.getInstance().closeBrowser();
    }
}
