package PageObjects;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshots {

	WebDriver driver;

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(
				"C:\\Users\\Shola\\AutomationClass-workspace\\GenomicEnglandUIFunctionalTest\\src\\main\\java\\PageObjects\\Screenshots.java"
						+ result + "screenshot.png"));

	}

}