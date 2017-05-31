package flipkartDemo;

import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


public class FlipkartHomePage {
	
	 WebDriver driver;
	 Properties properties;
	 LoginPage login = new LoginPage();
	 ElectronicMobile elcMobile = new ElectronicMobile();
	 
	 @Parameters("browserType")
		@BeforeClass
		public void beforeClass(String browser) throws InterruptedException {
			if (browser.equalsIgnoreCase("firefox")) {
				  System.setProperty("webdriver.gecko.driver", "/Users/pallavisingh/Downloads/geckodriver");
					driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", "/Users/pallavisingh/Downloads/chromedriver");
				driver = new ChromeDriver();
			}
			
			String baseUrl="https://www.flipkart.com";
			driver.get(baseUrl);
			driver.manage().window().maximize();
			Thread.sleep(2000);
		}


  @Test
	  public void flipkartDriver() {
			// calling Login page object and login
					try {

					login.loginFlipkart(driver);
					System.out.println("Login Successful!!!");
					} catch (Exception e) {
						System.out.println("The exception occured during login: "+e);
					}
			//calling Mobile Section page to perform operations
					try {
						System.out.println("Going to click on Mobiles and land on Mobiles page");
						elcMobile.mobileSection(driver);
						System.out.println("Performed actions on Mobile Page and added the item  to the cart");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("The exception occured during mobile page operation: "+e);
					}
}

   @AfterMethod
  public void afterMethod() {
  }

}
