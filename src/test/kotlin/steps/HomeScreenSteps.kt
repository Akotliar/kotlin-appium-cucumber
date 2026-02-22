package steps

import driver.DriverFactory
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import pages.HomeScreen
import pages.ServiceAlertsModalScreen
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

    @When("I select Service Alerts tab")
    fun iSelectServiceAlertsTab() {
        screen.clickServiceAlertsTab()
    }

    @Then("I should be able to view an active service alerts")
    fun iShouldBeAbleToViewActiveServiceAlerts() {
        screen.isServiceAlertsCountVisible()
        screen.serviceListContainer.waitForElementToBeVisible() { "Service alerts list did not become visible within the expected time." }
        val alertItems = screen.getServiceAlertItems()
        assert(alertItems.isNotEmpty()) { "Expected at least one active service alert, but found none."}
    }

    @When("I select an active service alert")
    fun iSelectActiveServiceAlert() {
        screen.clickServiceAlertsTab()
        val alertItems = screen.getServiceAlertItems()
        val randomAlert = alertItems.random()
        randomAlert.click()
    }
}