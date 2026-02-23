package steps

import driver.DriverFactory
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import pages.HomeScreen
import pages.StopTimesScreen
import utils.waitForElementToBeVisible

class HomeScreenSteps {
    private val screen = HomeScreen(DriverFactory.driver)
    @Given("I am on the RideYR Homescreen")
    fun iAmOnTheRideYRHomeScreen() {
        assert(screen.isHomeScreenVisible())
    }

    @When("I search for the {string} stop code in the search input field")
    fun iShouldBeAbleToSearchForAStopCodeInTheSearchInputField(stopCode: String) {
        screen.inputStopCode(stopCode)
    }

    @Then("I should see the stop time screen for the stop at the stop number {string}")
    fun iShouldSeeTheStopTimeScreenForTheStop(stopCode: String) {
        val stopTimeScreen = StopTimesScreen(DriverFactory.driver)
        stopTimeScreen.isStopTimesScreenVisible()
        stopTimeScreen.stopTimeTitleContains(stopCode)
    }

    @When("I select an active service alert")
    fun iSelectActiveServiceAlert() {
        screen.clickServiceAlertsTab()
        screen.serviceListContainer.waitForElementToBeVisible { "service list container notvisible" }
        val alertItems = screen.getServiceAlertItems()
        assert(alertItems.isNotEmpty()) { "Expected at least one active service alert, but found none."}
        val randomAlert = alertItems.random()
        randomAlert.click()
    }
}