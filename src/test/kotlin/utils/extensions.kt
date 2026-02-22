package utils

import org.openqa.selenium.WebElement

fun WebElement.waitForElementToBeVisible(
    timeout: Long = 5000,
    message: (() -> String)? = null
): Boolean {
    val endTime = System.currentTimeMillis() + timeout
    while (System.currentTimeMillis() < endTime) {
        try {
            if (this.isDisplayed) {
                return true
            }
        } catch (e: Exception) {
            // Element not found, continue waiting
        }
        Thread.sleep(500) // Wait before trying again
    }
    val custom = message?.invoke()
    return if (custom != null) {
        throw AssertionError(custom)
    } else {
        false // Element not visible within timeout
    }
}