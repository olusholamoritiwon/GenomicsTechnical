package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps extends BasePage {

	WebDriver driver;
	RegisterPage registerPage;
	SearchPage searchPage;
	ResultsPage resultsPage;
	ProductsPage productsPage;
	AddToCartPage addtocartPage;

	private final String AUT_URL = "https://www.takealot.com/";

	public Steps(WebDriver driver) {
		super(driver);

	}

	@Given("^user is on Register Page$")
	public void user_is_on_Register_Page() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(AUT_URL);

		registerPage = new RegisterPage(driver);

	}

	@When("^User clicks the register link$")
	public void user_clicks_the_register_link() throws Throwable {

	}

	@And("^User completes the registration form$")
	public void user_completes_the_registration_form() throws Throwable {

	}

	@When("^User clicks the register now button$")
	public void user_clicks_the_sign_in_button() throws Throwable {

	}

	@Then("^User is successgully logged on to search page$")
	public void user_successfully_logged_into_search_page() throws Throwable {

	}

	@When("^User search for Watches $")
	public void user_search_for_watches() throws Throwable {

		searchPage.setSearchField("watches");
	}

	@When("^Result for search is displayed $")
	public void result_for_search_displayed() throws Throwable {

		searchPage.setSearchField("watches");
	}

	@When("^User selects the GarminBlackWatch$")
	public void user_selects_the_garmin_forerunner_45s_sports_watchblack() {

		productsPage.addGarminWatchBlack();
	}

	@When("^choose to buy the GarminYellowWatch$")
	public void choose_to_buy_the_Garmin_quickfit_22mm_silicone_watchband_amp_yellow() {

		productsPage.addGarminWatchYellow();
	}

	@When("^User clicks Garmin Black watch to add to cart$")
	public void user_clicks_Garmin_Black_Watch_toAddToCartButton() throws Throwable {

		productsPage.getButtonName();
	}

	@When("^User clicks Garmin Yellow Watch to add to cart$")
	public void user_clicks_Garmin_Yellow_Watch_toAddToCartbutton() throws Throwable {

		productsPage.getButtonName();

	}

	@Then("User should see both products added to Shopping cart")
	public void User_should_see_both_products_added_to_shopping_cart() throws IOException {

		addtocartPage.getScreenshot("result");

	}

}
