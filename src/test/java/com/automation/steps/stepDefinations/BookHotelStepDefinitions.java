package com.automation.steps.stepDefinations;

import com.automation.steps.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Test;

public class BookHotelStepDefinitions {

    LoginPage loginPage = new LoginPage();

    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        System.out.println("Navigating to the login page...");
    }

    @When("User enters username and password and clicks the login button")
    public void userEntersUsernameAndPasswordAndClicksTheLoginButton() {

        loginPage.logIn("tshifhiwalunah", "R38485");
    }

    @Then("User is navigated to the search hotel page")
    public void userIsNavigatedToTheSearchHotelPage() {
        System.out.println("Welcome to landing page");
    }

    @Given("User is on the search hotel page")
    public void userIsOnTheSearchHotelPage() {
    }

    @When("User fills in all required information and clicks the search button")
    public void userFillsInAllRequiredInformationAndClicksTheSearchButton() {
    }

    @And("user selects a hotel and clicks the continue button")
    public void userSelectsAHotelAndClicksTheContinueButton() {
    }

    @And("User enters all required billing information and clicks the book now button")
    public void userEntersAllRequiredBillingInformationAndClicksTheBookNowButton() {
    }

    @Then("User successfully books a hotel, and an order number is generated")
    public void userSuccessfullyBooksAHotelAndAnOrderNumberIsGenerated() {
    }
}
