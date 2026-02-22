package hooks

import driver.DriverFactory
import io.cucumber.java.After
import io.cucumber.java.Before

class Hooks {
    @Before
    fun setUp() {
        val platform = System.getProperty("platform", "android")
        DriverFactory.init(platform)
    }

    @After
    fun tearDown() {
        DriverFactory.quit()
    }
}