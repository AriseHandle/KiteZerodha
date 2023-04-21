package pojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	static WebDriver driver;
	
	public static WebDriver launchBrowser(String browser) {
		
	if(browser.equals("Chrome"))
	{
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions opt = new ChromeOptions();
		
		opt.addArguments("--remote-allow-origins=*");
		
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
	}	
	
	else if(browser.equals("Edge"))
	{
		WebDriverManager.edgedriver().setup();
		
		driver = new EdgeDriver();	
	}
		
	driver.manage().window().maximize();
	
	driver.get("https://kite.zerodha.com/");
	
	return driver;
}

}
