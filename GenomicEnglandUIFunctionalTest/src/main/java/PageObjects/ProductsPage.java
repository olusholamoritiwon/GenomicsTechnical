package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

	private By garminwatchblack = By.xpath("//*[@class='search-product grid'][@id=68732665']");
	private By garminwatchyellow = By.xpath("//*[@class='search-product grid'][@id='46911722']");
	private By addToCartButton = By.xpath(
			"//button[@class='button  expanded add-to-cart-button add-to-cart-button-module_add-to-cart-button_1a9gT']");

	public ProductsPage(WebDriver driver) {
		super(driver);

	}

	public void addGarminWatchBlack() {
		find(garminwatchblack).click();

		click(addToCartButton);

	}

	public void addGarminWatchYellow() {
		find(garminwatchyellow).click();

		click(addToCartButton);

	}

	public String getButtonName() {
		return find(addToCartButton).getText();

	}

}
