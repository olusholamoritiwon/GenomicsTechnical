package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultsPage extends BasePage {

	private By searchresultList = By
			.xpath("//div[@class='cell small-12 medium-auto medium-order-1 toolbar-module_count-cell_2wrNQ']");

	public ResultsPage(WebDriver driver) {
		super(driver);

	}

	public boolean isSearchResultListdisplayed() {
		return isdisplayed(searchresultList);
	}

}
