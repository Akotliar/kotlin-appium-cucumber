

import driver.DriverFactory
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import pages.HomeScreen
import pages.ServiceAlertsModalScreen
import pages.StopTimesScreen
import utils.waitForElementToBeVisible

class ServiceAlertModalSteps {
    private val screen = ServiceAlertsModalScreen(DriverFactory.driver)

    @Then("I see the selected service alert details")
    fun iSelectActiveServiceAlert() {
        screen.isServiceAlertsModalVisible()
        screen.isAlertEffectLabelVisible()
    }
}