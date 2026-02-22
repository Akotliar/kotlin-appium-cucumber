package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

open class BaseScreen(protected val driver: AppiumDriver) {
    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }
}