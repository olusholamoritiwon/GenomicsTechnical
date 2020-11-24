package PageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {

		this.driver = driver;
	}

	protected WebElement find(By locator) {
		return driver.findElement(locator);

	}

	protected void type(String text, By locator) {
		find(locator).clear();
		find(locator).sendKeys(text);

	}

	protected void click(By string) {
		find(string).click();
	}

	protected boolean isdisplayed(By locator) {
		try {

			return find(locator).isDisplayed();

		} catch (NoSuchElementException exc) {
			return false;
		}
	}

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(
				"C:\\Users\\Shola\\AutomationClass-workspace\\GenomicEnglandUIFunctionalTest\\src\\main\\java\\PageObjects\\Screenshots.java"
						+ result + "screenshot.png"));

	}
}
