package org.example.goldcar.steps;

import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.goldcar.enums.VehicleType;
import org.example.goldcar.pages.CookieModalPage;
import org.example.goldcar.pages.HomePage;
import org.example.goldcar.pages.SelectVehiclePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.open;

public class VehicleSearchSteps {

    private static final Logger LOG = LoggerFactory.getLogger(VehicleSearchSteps.class);

    @Given("I open {string}")
    public void openUrl(String url) {
        open(url);
    }

    @Given("I accept the cookies")
    public void iAcceptTheCookies() {
        CookieModalPage.acceptCookies();
    }

    @When("I select the vehicle type {vehicleType}")
    public void selectVehicleType(VehicleType vehicleType) {
        LOG.info("Vehicle type = " + vehicleType);
        HomePage.selectVehicleType(vehicleType);
    }

    @When("I type {string}, picking the agency {string}")
    public void selectAgency(String inputText, String agency) {
        HomePage.selectAgency(inputText, agency);
    }

    @When("I select the pick up date {localDate} for any hour")
    public void selectPickUpDate(LocalDate pickUpLD) {
        HomePage.selectPickUpDate(pickUpLD);
        HomePage.selectFirstOpenHour();
    }

    @When("I select the return date {localDate} for any hour")
    public void selectReturnDate(LocalDate returnLD) {
        HomePage.selectReturnDate(returnLD);
        HomePage.selectFirstOpenHour();
    }

    @When("I click on Buscar")
    public void iSearch() {
        HomePage.clickOnSearch();
    }

    @Then("the text {string} is visible at the availability page")
    public void textIsVisible(String text) {
        SelectVehiclePage.getElementByText(text).should(Condition.exist, Condition.visible);
    }

}
