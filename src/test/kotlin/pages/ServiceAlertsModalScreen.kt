package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AndroidFindBy
import io.appium.java_client.pagefactory.iOSXCUITFindBy
import org.openqa.selenium.WebElement

class ServiceAlertsModalScreen(driver: AppiumDriver): BaseScreen(driver) {
    @AndroidFindBy(id = "alert_details_modal_header")
    @iOSXCUITFindBy(accessibility = "alert_details_modal_header")
    lateinit var alertsModalHeader: WebElement

    @AndroidFindBy(id = "alert_details_modal_effect_label")
    @iOSXCUITFindBy(accessibility = "alert_details_modal_effect_label")
    lateinit var alertEffectLabel: WebElement


    fun isServiceAlertsModalVisible(): Boolean {
        return alertsModalHeader.isDisplayed
    }
    fun isAlertEffectLabelVisible(): Boolean {
        return alertEffectLabel.isDisplayed
    }
}


