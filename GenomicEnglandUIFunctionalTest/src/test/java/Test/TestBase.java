package Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PageObjects.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	protected WebDriver driver;
	private final String AUT_URL = "https://www.takealot.com/";

	protected RegisterPage registerPage;

	@BeforeClass
	public void setUp() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(AUT_URL);

		registerPage = new RegisterPage(driver);

	}

	// Opening browser with the given URL and navigate to Registration Page
	@BeforeMethod
	public void openBrowser() throws ParseException {
		driver.manage().deleteAllCookies();

		driver.get("https://www.takealot.com/");

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//div[@class='modal-content modal-module_modal-content_3tE7B']")).click();

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	public static void main(String[] args) {

		File file = new File

		("/GenomicEnglandUIFunctionalTest/src/main/resources/ConfigFile/config.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Enumeration<Object> KeyValues = prop.keys();
		while (KeyValues.hasMoreElements()) {
			String key = (String) KeyValues.nextElement();
			String value = prop.getProperty(key);
			System.out.println(key + ":- " + value);
		}

	}

	@AfterClass
	public void teardown() {

		driver.quit();

	}

}
