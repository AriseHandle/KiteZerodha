package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteHomePage {

	@FindBy (xpath = "//input[@icon='search']") private WebElement searchField;
	@FindBy (xpath = "//span[@class='tradingsymbol']")private List<WebElement> stockList;
	@FindBy (xpath = "//button[@data-balloon='Buy']")private WebElement searchBuy;
	@FindBy (xpath = "//button[@data-balloon='Add']") private WebElement add;
	@FindBy (xpath = "//span[@class='nice-name']") private List<WebElement> watchListStock;
	@FindBy (xpath = "//a[@href='/dashboard']") private WebElement dashboard;
	
	public KiteHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterStockToSearch(String stock) {
		searchField.sendKeys(stock);
	}
	
	public int getStockListSizePostSearch() {
		return stockList.size();
	}
	
	public void moveToRequiredStock(WebDriver driver, String requiredStock) {
		Actions actions = new Actions(driver);
		for(int i=0 ; i<stockList.size(); i++)
		{
			String stockName =stockList.get(i).getText();
			
			if(stockName.equalsIgnoreCase(requiredStock))
			{
				actions.moveToElement(stockList.get(i));
				actions.perform();
				break;
			}
		}	
	}
	
	public void clickOnBuyPostSearch() {
		searchBuy.click();
	}
	
	public void addStockToWatchList() {
		add.click();
	}
	
	public void clickOnDashboard() {
		dashboard.click();
	}
	
	public boolean isRequiredStockPresentInWatchList(String requiredStock)
	{
		boolean result = false;
		for(int i =0 ; i<watchListStock.size(); i++)
		{
			String stockName=watchListStock.get(i).getText();
			if(stockName.equalsIgnoreCase(requiredStock))
			{
				result = true;
				break;
			}
		}
		return result;
		
	}
	
}
