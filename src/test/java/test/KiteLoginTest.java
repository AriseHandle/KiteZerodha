package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.KiteLoginPage;

public class KiteLoginTest extends BaseTest{
	
	@BeforeMethod
	public void launchBrowser() {
		driver =Browser.launchBrowser("Chrome");
	}
	
	@Test
	public void verifyIfUserIsAbleToLoginKite() throws InterruptedException {
		KiteLoginPage kiteLoginPage = new KiteLoginPage(driver);
		kiteLoginPage.enterUserId("YS0328");
		kiteLoginPage.enterPassword("Himalayan@6123");
		kiteLoginPage.clickOnLogin();
		Thread.sleep(10000);
		Assert.assertEquals(driver.getTitle(), "Dashboard / Kite");
	}
}
