package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

	private By firstnameField = By.xpath("//*[@id='firstname']");
	private By lastnameField = By.xpath("//*[@id='surname']");
	private By emailField = By.xpath("//*[@id='email']");
	private By retypeemailField = By.xpath("//*[@id='email2']");
	private By passwordField = By.xpath("//label[text()='Password']");
	private By retypepasswordField = By.xpath("//label[text()='password2']");
	private By mobilephonenoField = By.xpath("//input[@id='telno1']");
	private By daybirthdayField = By.xpath("//*[@id='day']");
	private By monthbirthdayField = By.xpath("//*[@id='month']");
	private By yearbirthdayField = By.xpath("//*[@id='year']");
	private By regsiternowButton = By.xpath("//input[@type='Submit']");
	private By welcomeMessage = By.xpath("//div[@id='welcome']");
	private By nofirstnamespecifiedMessage = By.xpath("//span[@id='first-name-not-specified')]");

	public RegisterPage(WebDriver driver) {
		super(driver);

	}

	public void setfirstName(String firstname) {
		type(firstname, firstnameField);
	}

	public void setlastName(String lastname) {
		type(lastname, lastnameField);
	}

	public void setEmail(String email) {
		type(email, emailField);
	}

	public void setretypeEmail(String retypeemail) {
		type(retypeemail, retypeemailField);

	}

	public void setPassword(String password) {
		type(password, passwordField);

	}

	public void setRetypePassword(String retypepassword) {
		type(retypepassword, retypepasswordField);

	}

	public void setMobilePhoneNo(String mobilephoneno) {
		type(mobilephoneno, mobilephonenoField);

	}

	public void setDayBirthday(String daybirthday) {
		type(daybirthday, daybirthdayField);
	}

	public void setMonthBirthday(String monthbirthday) {
		type(monthbirthday, monthbirthdayField);
	}

	public void setYearBirthday(String yearbirthday) {
		type(yearbirthday, yearbirthdayField);
	}

	public SearchPage clickregisternowButton() {
		click(regsiternowButton);
		return new SearchPage(driver);

	}

	public SearchPage registerWith(String firstname, String lastname, String email, String retypeemail, String password,
			String retypepassword, String mobilephoneno, String daybirthday, String monthbirthday,
			String yearbirthday) {

		setfirstName(firstname);
		setlastName(lastname);
		setEmail(email);
		setretypeEmail(retypeemail);
		setPassword(password);
		setRetypePassword(retypepassword);
		setMobilePhoneNo(mobilephoneno);

		setDayBirthday(daybirthday);
		setMonthBirthday(monthbirthday);
		setYearBirthday(yearbirthday);

		return clickregisternowButton();

	}

	public String getwelcomeMessage() {

		return find(welcomeMessage).getText();

	}

	public String nofirstnamespecifiedMessage() {

		return find(nofirstnamespecifiedMessage).getText();

	}
}
