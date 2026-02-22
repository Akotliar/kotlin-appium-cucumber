package driver

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.ios.options.XCUITestOptions
import org.openqa.selenium.remote.DesiredCapabilities
import java.net.URL
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeUnit.*

object DriverFactory {
    lateinit var driver : AppiumDriver

        fun init(platform: String) {
            val testAppURL = URL("http://127.0.0.1:4723/wd/hub")
            println("Initializing driver for platform: $platform")
            when (platform.lowercase()) {
                "android" -> {
                    val options = UiAutomator2Options()
                        .setPlatformName("Android")
                        .setDeviceName("Pixel 6a")
                        .setUdid("adb-26251JEGR15039-zxVANS._adb-tls-connect._tcp")
                        .setApp("/Users/akotliar/AndroidStudioProjects/RideYRMP/composeApp/build/outputs/apk/debug/composeApp-debug.apk")
                        .setAutomationName("UiAutomator2")

                    options.setCapability("appium:disableIdLocatorAutocompletion", true)

                    driver = AndroidDriver(
                        testAppURL,
                        options
                    )
                }
                "ios" -> {
                    val options = XCUITestOptions()
                        .setPlatformName("iOS")
                        .setDeviceName("iPhone Simulator")
                        .setUdid("41544A07-87DA-4163-BAC8-2368B3B81B91")
                        .setApp("/Users/akotliar/AndroidStudioProjects/RideYRMP/uitests/src/test/resources/apps/RideYR.app")
                        .setAutomationName("XCUITest")

                    options.setCapability("appium:disableIdLocatorAutocompletion", true)


                    driver = IOSDriver(
                        testAppURL,
                        options
                    )
                }
                else -> throw IllegalArgumentException("Unsupported platform: $platform")
            }
        }

    fun quit() = driver.quit()
}