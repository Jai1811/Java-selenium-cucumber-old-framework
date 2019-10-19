package Commonfunctions;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mysql.cj.x.protobuf.MysqlxDatatypes;

import io.appium.java_client.functions.ExpectedCondition;
import java.util.Set;
import pageobjects.PageObjects;

public class commonfunction {
	public static WebDriver driver;

	// function to return a webelement reference, refering to xpath
	public static WebElement getwebElement(String enumxpath) {
		WebElement ele = driver.findElement(By.xpath(enumxpath));
		return ele;
	}

	public static List<WebElement> getwebElements(String enumxpath) {
		List<WebElement> ele = driver.findElements(By.xpath(enumxpath));

		return ele;
	}

	public static String takeScreenshot(String filename) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = null;
		try {
			FileUtils.copyFile(src, new File("D:/java/Selenuim/" + filename + ".jpeg"));
			return path = "D:/java/Selenuim/" + filename + ".jpeg";
		} catch (Exception e) {
			System.out.println("error taking screenshot");
			return null;
		}
	}

	public static void highlightelement(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: olive; border: 2px solid red;');", ele);
	}

	public static void highlightclickentertakescreenshot(String sendkeys, String command, WebElement ele,
			String filename) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: olive; border: 2px solid red;');", ele);
		if (command.equals("Enter")) {
			ele.sendKeys(sendkeys);
			takeScreenshot(filename);
		}
		if (command.equals("Click")) {
			ele.click();
			takeScreenshot(filename);

		}
	}

	public void navigatetoURl(String URL) {
		driver.get(URL);
	}

	public void pagenavigationRefresh(String Navigation) {
		if (Navigation.equals("Back"))
			driver.navigate().back();
		else if (Navigation.equals("forward"))
			driver.navigate().forward();
		else if (Navigation.contains("www"))
			driver.navigate().to(Navigation);
		else
			driver.navigate().refresh();
	}

	public void pagescrolling(String direction, PageObjects object) {
		if (direction.equals("UP")) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(500,0)");

		} else if (direction.equals("DOWN")) {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)");
		}

		else if (direction.equals("LEFT")) {
			WebElement ele = driver.findElement(By.xpath(object.getxpath()));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)");
		} else if (direction.equals("RIGHT")) {
			WebElement ele = driver.findElement(By.xpath(object.getxpath()));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)");
		}
		// else if ("scrollIntoview") {
		//
		// }
		//

	}

	public Set<String> browserfuntions(String function, Point p, Dimension d) throws InterruptedException {
		Set<String> windowHandles = null;
		if (function.equals("Close"))
			driver.close();
		if (function.equals("Maximize"))
			driver.manage().window().maximize();
		if (function.equals("fullscreen"))
			driver.manage().window().fullscreen();
		if (function.equals("setposition"))
			driver.manage().window().setPosition(p);
		if (function.equals("setsize"))
			driver.manage().window().setSize(d);
		if (function.equals("wait"))
			driver.manage().wait(5000);
		if (function.equals("Handles")) {
			windowHandles = driver.getWindowHandles();
		}
		return windowHandles;

	}

	public static List<WebElement> highlightselectfromdropdown(String by, WebElement ele, String option) {

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'background: olive; border: 2px solid red;');", ele);
		Select sle = new Select(ele);
		List<WebElement> options = sle.getOptions();
		if (by.equals("byvisibletext")) {
			sle.selectByVisibleText(option);
		}
		if (by.equals("byvalue")) {
			sle.selectByValue(option);
		}
		if (by.equals("byindex")) {
			sle.selectByValue(option);
		}
		return options;
	}

	public static void setwait(String waittype, ExpectedCondition<T> condition, int timeout)
			throws InterruptedException {

		if (waittype.equals("explicitwait")) {
			T wait = (new WebDriverWait(driver, timeout)).until(condition);
		} else
			driver.wait(2000);
	}

	public void datepicker(List<WebElement> dateoptions, String datetoselect) {

		for (WebElement date : dateoptions) {
			if (date.getText().equals(datetoselect))
				date.click();
			break;
		}

	}

	public void selecttextbypartialtext() {

	}

	public void keys(String keysfunction) {

	}

	public void switchingtoframes(String name) {
		driver.switchTo().frame(name);
	}

	public void actions(WebElement source, String Functionality, WebElement target, int xOffset, int yOffset) {
		Actions act = new Actions(driver);
		act.moveToElement(source).perform();
		if (Functionality.equals("draganddrop"))
			act.dragAndDrop(source, target).build().perform();
		if (Functionality.equals("clickandhold"))
			act.clickAndHold(target);
		if (Functionality.equals("slider"))
			act.dragAndDropBy(source, xOffset, yOffset);
	}

	public void switchtoalert(String response) {
		Alert alert = driver.switchTo().alert();
		if (response.equals("accept"))
			alert.accept();
		else if (response.equals("dismiss"))
			alert.dismiss();
	}
}
