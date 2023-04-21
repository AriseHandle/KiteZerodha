package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.KiteHomePage;
import pom.KiteLoginPage;

public class SearchStockTest extends BaseTest {

	@BeforeMethod
	public void launchBrowser() {
		driver =Browser.launchBrowser("Chrome");
	}
	
	@Test
	public void verifyIfUserIsAbleToSearchStock() throws InterruptedException {
		KiteLoginPage kiteLoginPage = new KiteLoginPage(driver);
		kiteLoginPage.enterUserId("YS0328");
		kiteLoginPage.enterPassword("Himalayan@6123");
		kiteLoginPage.clickOnLogin();
		Thread.sleep(10000);
		
		KiteHomePage kiteHomePage = new KiteHomePage(driver);
		kiteHomePage.enterStockToSearch("Tata");
		Assert.assertTrue(kiteHomePage.getStockListSizePostSearch()>0);
		
	}
	
	@Test
	public void verifyIfUserIsAbleToSelectBuyOptionOnStockSearch() throws InterruptedException {
		KiteLoginPage kiteLoginPage = new KiteLoginPage(driver);
		kiteLoginPage.enterUserId("YS0328");
		kiteLoginPage.enterPassword("Himalayan@6123");
		kiteLoginPage.clickOnLogin();
		Thread.sleep(10000);
		
		KiteHomePage kiteHomePage = new KiteHomePage(driver);
		kiteHomePage.enterStockToSearch("rel");
		kiteHomePage.moveToRequiredStock(driver, "reliance");
		kiteHomePage.clickOnBuyPostSearch();
	}
	
	@Test
	public void verifyIfUserIsAbleToAddStockToWatchlist() throws InterruptedException {
		KiteLoginPage kiteLoginPage = new KiteLoginPage(driver);
		kiteLoginPage.enterUserId("YS0328");
		kiteLoginPage.enterPassword("Himalayan@6123");
		kiteLoginPage.clickOnLogin();
		Thread.sleep(10000);
		
		KiteHomePage kiteHomePage = new KiteHomePage(driver);
		kiteHomePage.enterStockToSearch("tata");
		kiteHomePage.moveToRequiredStock(driver, "tatamotors");
		kiteHomePage.addStockToWatchList();
		kiteHomePage.clickOnDashboard();
		Assert.assertTrue(kiteHomePage.isRequiredStockPresentInWatchList("tatamotors"));
	}
}
