package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BasePage {

	private By searchField = By.xpath("//[@name='search']");
	private By searchboxButton = By.xpath("//button[@type='Submit']");

	public SearchPage(WebDriver driver) {
		super(driver);

	}

	public void setSearchField(String searchfield) {
		type(searchfield, searchField);

	}

	public ResultsPage clicksearchboxButton() {
		click(searchboxButton);
		return new ResultsPage(driver);

	}

}
