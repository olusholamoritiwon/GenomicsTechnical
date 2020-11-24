package Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPageTests extends TestBase {

	@Test
	public void testAddToCartGarminWatchBlack() throws InterruptedException {

		driver.manage().timeouts().wait(3000);

		driver.findElement(By.xpath("//*[@class='search-product grid'][@id='68732665']")).click();

		driver.findElement(By.xpath(
				"//button[@class='button  expanded add-to-cart-button add-to-cart-button-module_add-to-cart-button_1a9gT']"))
				.click();

		String element = driver.findElement(By.xpath("//*[@class='search-product grid'][@id='68732665']")).getText();

		Assert.assertTrue(element.contains("garmin-forerunner-45s-sports-watch-black"));

	}

	@Test
	public void testAddToCartGarminWatchYellow() throws InterruptedException {

		driver.manage().timeouts().wait(3000);

		driver.findElement(By.xpath("//*[@class='search-product grid'][@id='46911722']")).clear();

		driver.findElement(By.xpath("//*[@class='search-product grid'][@id='46911722']")).click();

		driver.findElement(By.xpath(
				"//button[@class='button  expanded add-to-cart-button add-to-cart-button-module_add-to-cart-button_1a9gT']"))
				.click();

		String element = driver.findElement(By.xpath("//*[@class='search-product grid'][@id='46911722']")).getText();

		Assert.assertTrue(element.contains("garmin-quickfit-22mm-silicone-watch-band-amp-yellow"));

	}

	@Test
	public void searchResults() throws InterruptedException {

		driver.manage().timeouts().wait(3000);

		driver.findElement(By.xpath("//[@name='search']")).clear();

		driver.findElement(By.xpath("//[@name='search']")).sendKeys("watches");

		driver.findElement(By.xpath("//button[@type='Submit']")).click();

		String result = driver.findElement(By.xpath(
				"//div[@class='search-count toolbar-module_search-count_P0ViI search-count-module_search-count_1oyVQ']"))
				.getText();

		Assert.assertTrue(result.contains("1000 + results for 'watches')"));
	}

}
