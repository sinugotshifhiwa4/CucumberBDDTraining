package com.automation.steps.stepDefinations;

import com.automation.steps.components.ExtentReportConfiguration;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.junit.experimental.ParallelComputer;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class AllTestRunners {

    public static void main(String[] args) {
        // Initialize ExtentReports using the configuration
        ExtentReports extent = ExtentReportConfiguration.extentReportSetUp();

        // Run all test runners in parallel and generate reports
        runTestRunnersInParallel(extent, BookHotelTestRunner.class, SearchHotelTestRunner.class);

        // Flush the extent report after all tests are executed
        extent.flush();
    }

    private static void runTestRunnersInParallel(ExtentReports extent, Class<?>... testRunnerClasses) {
        // Create a JUnitCore instance
        JUnitCore junit = new JUnitCore();

        // Run test runners in parallel
        Result result = junit.run(new ParallelComputer(true, true), testRunnerClasses);

        // Generate report for each test runner
        for (Class<?> testRunnerClass : testRunnerClasses) {
            generateExtentReport(extent, result, testRunnerClass.getSimpleName());
        }
    }

    // Method to generate Extent report based on test results
    private static void generateExtentReport(ExtentReports extent, Result result, String testRunnerName) {
        // Create a test for the test runner
        ExtentTest test = extent.createTest(testRunnerName);

        // Add log statements based on test results
        if (result.wasSuccessful()) {
            test.pass("All tests passed");
        } else {
            for (Failure failure : result.getFailures()) {
                test.fail(failure.getTestHeader() + ": " + failure.getMessage());
            }
        }
    }
}
