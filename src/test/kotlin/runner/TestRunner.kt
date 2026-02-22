package runner

import org.junit.platform.suite.api.ConfigurationParameter
import org.junit.platform.suite.api.IncludeEngines
import org.junit.platform.suite.api.SelectClasspathResource
import org.junit.platform.suite.api.Suite
import io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME
import io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME


//@RunWith(Cucumber::class)
//@CucumberOptions(
//    features = ["classpath:features"],
//    glue = ["steps", "hooks"],
//    plugin = ["pretty", "html:target/cucumber-reports.html"])
//public class TestRunner

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = "cucumber.glue", value = "hooks,steps")
class RunCucumberTest
