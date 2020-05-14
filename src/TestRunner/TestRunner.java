package TestRunner;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentTest;

import allocator.Reports;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import stepDefinition.*;
import net.serenitybdd.cucumber.CucumberWithSerenity;
//
//@RunWith(CucumberWithSerenity.class)
//@CucumberOptions(features={"Features"},
//glue = {"stepDefinition"})

@CucumberOptions(features = { "Features" }, glue = { "stepDefinition" }, tags = { "@navigatetoprofile" })

// @Test
// public class TestRunner {
//
//
// }

@Test
public class TestRunner extends AbstractTestNGCucumberTests1 {

}
