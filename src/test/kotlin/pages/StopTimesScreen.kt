package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement
import utils.waitForElementToBeVisible

class StopTimesScreen(driver: AppiumDriver) : BaseScreen(driver) {

    @AndroidFindBy(id = "stop_time_screen_title")
    @iOSXCUITFindBy(accessibility = "stop_time_screen_title")
    lateinit var stopTimesTitle: WebElement


    fun isStopTimesScreenVisible(): Boolean {
        return stopTimesTitle.waitForElementToBeVisible()
    }

    fun stopTimeTitleContains(stopCode: String): Boolean {
       return stopTimesTitle.text.contains(stopCode)
    }
}