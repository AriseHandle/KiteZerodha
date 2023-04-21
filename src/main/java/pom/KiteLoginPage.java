package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLoginPage {

	@FindBy (xpath = "//input[@id='userid']")private WebElement userId;
	@FindBy (xpath = "//input[@id='password']")private WebElement password;
	@FindBy (xpath = "//button[@class='button-orange wide']")private WebElement login;
	
	public KiteLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserId(String id) {
		userId.sendKeys(id);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLogin() {
		login.click();
	}


}
