package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage extends BasePage {

	private By addedtocartField = By.xpath("//input[@id='firstname']");

	private By viewshoppingcartDetails = By.xpath("//input[@id='firstname']");

	public AddToCartPage(WebDriver driver) {
		super(driver);

	}

	public boolean isaddedtocartFielddisplayed() {
		return isdisplayed(addedtocartField);
	}

	public boolean isviewshoppingcartDetailsdisplayed() {
		return isdisplayed(viewshoppingcartDetails);
	}

}
