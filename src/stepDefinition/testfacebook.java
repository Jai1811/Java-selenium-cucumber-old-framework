package stepDefinition;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.*;

import Commonfunctions.commonfunction;
import TestRunner.TestRunner;

import java.io.IOException;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


import allocator.properties;
import pageobjects.PageObjects;
import stepDefinition.*;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import TestRunner.AbstractTestNGCucumberTests1;
import allocator.Allocator;
import allocator.Reports;


public class testfacebook extends commonfunction {

	ExtentTest Test;
	ExtentReports report;

	@Given("^invokebrowser$")
	public void invokebrowser() throws IOException {
		System.out.println("inside invoke browser");
		//		String Path = properties.Getproperties("Reportpath");

//		report = new ExtentReports("D:\\java\\Selenuim\\Reports\\test.html");

	//	Test = report.startTest("Navigation to profile");
		System.setProperty("webdriver.chrome.driver", properties.Getproperties("chromedriverpath"));
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		//Test.log(LogStatus.INFO, "Invoking the browser",
		//Test.addScreenCapture(commonfunction.takeScreenshot("Invoking the browser")));

	}
	

	@And("^navigate to facebook$")
	public void navigate_to_facebook() throws IOException {
		driver.get(properties.Getproperties("URL").replaceAll("\"", ""));
		driver.manage().window().maximize();
	//	Test.log(LogStatus.PASS, "Sucessfully navigated to URL",
				//Test.addScreenCapture(commonfunction.takeScreenshot("navigate")));
	}

	@When("^enter Credentials$")
	public void enter_Credentials() throws IOException, InterruptedException {
		commonfunction.highlightclickentertakescreenshot((properties.Getproperties("username")), "Enter",
				commonfunction.getwebElement(PageObjects.emailIdtextBox.getxpath()), "enteredemailid");
		commonfunction.highlightclickentertakescreenshot((properties.Getproperties("password")), "Enter",
				commonfunction.getwebElement(PageObjects.passtextBox.getxpath()), "enterpassword");
		commonfunction.highlightclickentertakescreenshot("", "Click",
				commonfunction.getwebElement(PageObjects.loginbutton.getxpath()), "login");
		//Test.log(LogStatus.PASS, "To verify if the user is able to login or not", "User is able to login successfully");
	}

	@Then("^navigate to home$")
	public void navigate_to_home() throws IOException, InterruptedException {
		try {
			Assert.assertEquals(driver.findElement(By.xpath(PageObjects.Homebutton.getxpath())).isDisplayed(), true);
			//Test.log(LogStatus.PASS, "To verify if user is able to navigate to home page",
					//"User is able to navigate to home page succesfully");
		} catch (Exception e) {
			//Test.log(LogStatus.FAIL, "To verify if user is able to navigate to home page",
//					"User is not able to navigate to home page succesfully");
		}
		commonfunction.takeScreenshot("home");
		driver.close();

	}

	@Then("^navigate to profile$")
	public void navigate_to_profile() throws IOException, InterruptedException {
		try {
			commonfunction.highlightclickentertakescreenshot("", "Click",
					commonfunction.getwebElement(PageObjects.profilebutton.getxpath()), "clickprofilebutton");
			//Test.log(LogStatus.PASS, "To verify if user is able to navigate to profile page",
					//"User is able to navigate to profile page succesfully");
			commonfunction.takeScreenshot("profilepage");
		} catch (Exception e) {
			//Test.log(LogStatus.FAIL, "To verify if user is able to navigate to home page",
					//"User is not able to navigate to home page succesfully");
		}
		//driver.close();
		//report.endTest(Test);
		//report.flush();
	}
	@And("^navigate to google$")
	public void navigate_to_google() throws IOException {
		driver.get(properties.Getproperties("URLgoogle").replaceAll("\"", ""));
		driver.manage().window().maximize();
	//	Test.log(LogStatus.PASS, "Sucessfully navigated to URL",
				//Test.addScreenCapture(commonfunction.takeScreenshot("navigate")));
	}
	@Then("^collecthyperlinks$")
	public void collect_hyperlinks() {
		List<WebElement> profilepagehyperlinks=null;
		try 
		{
			profilepagehyperlinks=commonfunction.getwebElements("*//a");


		}
		catch (Exception e) {
			System.out.println("hyperlink not found");
		}

		Iterator<WebElement> linkitr=  profilepagehyperlinks.iterator();
		int i=0;
		while(linkitr.hasNext()) 
		{	
			String attribute=profilepagehyperlinks.get(i).getAttribute("href");
			System.out.println("href tag attribute");
			i=i++;
		}

	}


	// @When("")
	// public void dbvalidation() throws SQLException {
	// Dbvalidations.extractsqldata("air_flight_details","");

}