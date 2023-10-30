package Utilities;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;

public class BaseClass {
 
  WebDriver driver;
  
  @Parameters({"browser", "website"})
  @BeforeMethod
  public void beforeMethod(String browserName, String url) {
	  
	    IBrowsers(browserName, url);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }
  public void IBrowsers(String NameOfBrowser, String url ) {
		
		if (NameOfBrowser.equalsIgnoreCase("Chrome")) {
			
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		}
		
		else if (NameOfBrowser.equalsIgnoreCase("Edge")) {
		
		WebDriverManager.edgedriver().setup();

		driver= new EdgeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		}
		}

}
