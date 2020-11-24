package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.RegisterPage;

public class RegisterPageTests extends TestBase {

	// Registration with all valid data

	@Test
	public void validRegistrationTest() throws InterruptedException {

		RegisterPage registerPage = new RegisterPage(driver);

		registerPage.setfirstName("firstname");
		registerPage.setlastName("lastname");
		registerPage.setEmail("email");
		registerPage.setretypeEmail("retypeemail");
		registerPage.setPassword("password");
		registerPage.setRetypePassword("retypepassword");
		registerPage.setMobilePhoneNo("mobilephoneno");
		registerPage.setDayBirthday("daybirthday");
		registerPage.setMonthBirthday("monthbirthday");
		registerPage.setYearBirthday("yearbirthday");

		registerPage.clickregisternowButton();

		WebElement expectedTitle = driver.findElement(By.xpath("//div[@id='welcome']"));

		Thread.sleep(3000);

		String actualTitle = driver.getTitle();

		Assert.assertEquals(actualTitle, expectedTitle);

	}

	// Registration without providing first Name field

	@Test
	public void validateEmptyFirstNameTest() throws InterruptedException {

		WebElement expectedErrorMsg = driver.findElement(By.xpath("//span[@id='first-name-not-specified')]"));

		Thread.sleep(3000);

		String actualErrorMsg = expectedErrorMsg.getText();

		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

	}

	// Registration without providing Last Name field

	@Test
	public void validatingemptylastNameFieldTest() throws InterruptedException {

		WebElement expectedErrorMsg = driver.findElement(By.xpath("//span[@id='surname-not-specified')]"));

		Thread.sleep(3000);

		String actualErrorMsg = expectedErrorMsg.getText();

		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

	}

	// Registration without providing user email field

	@Test
	public void emptyEmailTest() throws InterruptedException {

		WebElement expectedErrorMsg = driver.findElement(By.xpath("//span[@id='emails-not-matching']"));

		Thread.sleep(3000);

		String actualErrorMsg = expectedErrorMsg.getText();

		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

	}

	// Registration with email id which already have account

	@Test
	public void invalidEmailTest() throws InterruptedException {

		WebElement expectedErrorMsg = driver.findElement(By.xpath("//div[@class='inner-inner']"));

		Thread.sleep(3000);

		String actualErrorMsg = expectedErrorMsg.getText();

		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

	}

	// Registration without providing password field

	@Test
	public void emptyPasswordTest() throws InterruptedException {

		WebElement expectedErrorMsg = driver.findElement(By.xpath("//span[@id='no-password']"));

		String actualErrorMsg = expectedErrorMsg.getText();

		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

	}

	// Registration with invalid password

	@Test
	public void inValidPasswordTest() throws InterruptedException {

		WebElement expectedErrorMsg = driver.findElement(By.xpath("//span[@id='password-too-short']"));

		String actualErrorMsg = expectedErrorMsg.getText();

		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

	}

	// Registration without providing user phone number field

	@Test
	public void emptyPhoneTest() throws InterruptedException {

		WebElement expectedErrorMsg = driver.findElement(By.xpath("//span[@id='phone-number-not-specified']"));

		String actualErrorMsg = expectedErrorMsg.getText();

		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

	}

	// Registration with providing invalid user phone number field

	@Test
	public void inValidPhoneNumberFieldTest() {

		WebElement expectedErrorMsg = driver.findElement(By.xpath("//span[@id='phone-number-too-short']"));

		String actualErrorMsg = expectedErrorMsg.getText();

		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);

	}

}