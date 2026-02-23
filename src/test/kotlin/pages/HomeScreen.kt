package pages

import driver.DriverFactory
import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.nativekey.AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent
import io.appium.java_client.android.nativekey.PressesKey
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement
import utils.waitForElementToBeVisible

fun WebElement.pressEnterKey(platform: String) {
    if (platform == "android") {
        (DriverFactory.driver as PressesKey).pressKey(KeyEvent(AndroidKey.ENTER))
    } else {
        this.sendKeys(Keys.RETURN)
    }
}

class HomeScreen(driver: AppiumDriver) : BaseScreen(driver) {

    val platform: String = System.getProperty("platform", "android")

    @AndroidFindBy(id = "searchbar_input")
    @iOSXCUITFindBy(accessibility = "searchbar_input")
    lateinit var stopCodeInput : WebElement

    @AndroidFindBy(id = "service_alerts_tab_button")
    @iOSXCUITFindBy(accessibility = "service_alerts_tab_button")
    lateinit var serviceAlertsTab : WebElement

    @AndroidFindBy(id = "alerts_count_label")
    @iOSXCUITFindBy(accessibility = "alerts_count_label")
    lateinit var alertsCountLabel : WebElement

    @AndroidFindBy(id = "service_alerts_list")
    @iOSXCUITFindBy(accessibility = "service_alerts_list")
    lateinit var serviceListContainer : WebElement

    fun isHomeScreenVisible(): Boolean {
        return stopCodeInput.isDisplayed
    }

    fun inputStopCode(stopCode: String) {
        stopCodeInput.click()
        stopCodeInput.sendKeys(stopCode)
        stopCodeInput.pressEnterKey(platform)
    }

    fun isServiceAlertsTabVisible(): Boolean {
        return serviceAlertsTab.waitForElementToBeVisible() { "Service Alerts tab did not become visible within the expected time." }
    }

    fun isServiceAlertsCountVisible(): Boolean {
        return alertsCountLabel.waitForElementToBeVisible() { "Alerts count label did not become visible within the expected time." }
    }

    fun clickServiceAlertsTab() {
        serviceAlertsTab.click()
    }

    fun getServiceAlertItems() : List<WebElement> {
        return if (platform == "android") {
            driver.findElements( AppiumBy.androidUIAutomator(
                "new UiSelector().resourceIdMatches(\".*alert_item_.*\")"
            ))
        } else {
            driver.findElements(AppiumBy.iOSNsPredicateString("name CONTAINS 'alert_item_'"));
        }
    }
}