package flipkartDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Data.ConfigurationClass;

public class LoginPage {

	WebDriver driver;
  @Test
  public void loginFlipkart(WebDriver driver) throws InterruptedException {
	  ConfigurationClass config= new ConfigurationClass();
	  this.driver=driver;
	  //Clicking on Login link on home Page
	  WebElement loginLink= driver.findElement(By.xpath(".//*[@id='container']/div/header/div[1]/div[1]/div/ul/li[8]/a"));
	  System.out.println("Clicking on Login link");
      loginLink.click();
      Thread.sleep(3000);
      
      WebElement username= driver.findElement(By.xpath("html/body/div[3]/div/div/div/div/div[2]/div/form/div[1]/input"));
	  String phoneNo = config.getuserName();
      username.sendKeys(phoneNo);
      Thread.sleep(2000);
      
      WebElement pwd= driver.findElement(By.xpath("html/body/div[3]/div/div/div/div/div[2]/div/form/div[2]/input"));
      String password = config.getpassword();
      pwd.sendKeys(password);
      
      WebElement loginButton= driver.findElement(By.xpath("html/body/div[3]/div/div/div/div/div[2]/div/form/div[3]/button"));
      loginButton.click();
   

	  
  }
}
