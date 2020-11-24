package Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartPageTest extends TestBase {

	// checking title of page with products added to cart
	@Test
	public void ViewShoppingCart() throws InterruptedException {

		WebElement expectedTitle = driver.findElement(By.xpath("//hi[text()='Shopping Cart']"));
		Thread.sleep(3000);

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

	}

	@Test
	public void ViewShoppingCartSnapshot() throws InterruptedException {

		WebElement ViewCart = driver.findElement(By.xpath("//hi[text()='Shopping Cart']"));
		ViewCart.click();
		Thread.sleep(3000);
		driver.manage().window().fullscreen();
		takeScreenShot(driver, "ViewCart");
	}

	@Test
	public void SelectedProductValidation() throws InterruptedException {

		WebElement SelectProduct = driver.findElement(By.xpath(("//*[@class='search-product grid'][@id='46911722']")));

		SelectProduct.click();

		takeScreenShot(driver, "Garmin Black Watch");

	}

	// checking products are available in cart

	private void takeScreenShot(WebDriver driver, String string) {

	}

	@Test
	public void shoppingCartTitle() throws InterruptedException {

		WebElement cartTitle = driver.findElement(By.xpath("//hi[text() ='Shopping Cart')]"));

		driver.getTitle();

		Assert.assertEquals("Shopping Cart", cartTitle.getText());
	}

	@Test
	public void AddedGarminBlackWatchToCart() throws InterruptedException {

		WebElement firstItemAdded = driver.findElement(By.xpath("//*[@class='search-product grid'][@id='68732665']"));

		firstItemAdded.click();

		String element = firstItemAdded.getText();

		Assert.assertEquals(element, firstItemAdded.getText());
	}

	@Test
	public void AddedGarminYellowWatchToCart() throws InterruptedException {

		WebElement secondItemAdded = driver.findElement(By.xpath("//*[@class='search-product grid'][@id='46911722']"));

		secondItemAdded.click();

		String element = secondItemAdded.getText();

		Assert.assertEquals(element, secondItemAdded.getText());

	}

	@Test
	public void CountProductsFromCart() throws InterruptedException {

		List<WebElement> numberOfItemsAddedToCart = driver
				.findElements(By.xpath("//div[@class='cart-products-box']/div[contains(@class, 'cart-product-box')]"));

		numberOfItemsAddedToCart.size();

		Assert.assertEquals(2, numberOfItemsAddedToCart.size());

	}

	@Test
	public void ValidationOfItemsAddedToCart() {

		driver.findElement(By.xpath(
				"//button[@class='button  expanded add-to-cart-button add-to-cart-button-module_add-to-cart-button_1a9gT']"))
				.click();

		List<WebElement> listofItems = driver.findElements(
				By.xpath("//div[@class='cart-item-container-module_item_3Vkqc transition-height-module_item_1ikpj']"));

		System.out.println("Number of listofItems:" + listofItems.size());

		for (int i = 0; i <= listofItems.size(); i++) {

			System.out.println("Name text:" + listofItems.get(i).getAttribute("value"));
		}

	}

}
