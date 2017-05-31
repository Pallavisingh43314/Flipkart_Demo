package flipkartDemo;

import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElectronicMobile {
	WebDriver driver;
	  Actions actions;
	  Select select;

  @Test
  public void mobileSection(WebDriver driver) throws InterruptedException {
	  	actions = new Actions(driver);
	  	//Mouse Hover on Electronics
		WebElement electronicMenu = driver.findElement(By.xpath("//*[@id='container']/div/header/div[2]/div/ul/li[1]/a/span"));
		actions.moveToElement(electronicMenu).build().perform();
		Thread.sleep(3000);
		
		//moving to mobile and clicking it
		//WebElement electronicMobile = driver.findElement(By.xpath(".//*[@id='container']/div/header/div[2]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[1]/a"));
		//actions.moveToElement(electronicMenu).click(electronicMobile).build().perform();
		driver.navigate().to("https://www.flipkart.com/mobiles?otracker=nmenu_sub_Electronics_0_Mobiles");
		Thread.sleep(3000);
		
		//clicking on RAM drop down
		driver.findElement(By.xpath(".//*[@id='container']/div/header/div[2]/div/ul/li[1]/ul/li/ul/li[1]/ul/li[5]/a')]")).click();
		Thread.sleep(2000);
		
		//Click 4 GB Checkbox
		driver.findElement(By.xpath(".//*[@id='container']/div/div[2]/div/div[2]/div/div/div[4]/section/div[2]/div/div[6]/div/div/label/div[1]")).click();
		Thread.sleep(2000);
		
		//filtered item - first two have 4 GB in description
		if((driver.findElement(By.xpath(".//*[@id='container']/div/div[2]/div/div[2]/div/div/div[9]/section/div network type")).getText().equalsIgnoreCase("4 GB")) &&
		(driver.findElement(By.xpath(".//*[@id='container']/div/div[2]/div/div[2]/div/div/div[9]/section/div[2]/div/div[3]/div/div/label/div[1]")).getText().equalsIgnoreCase("4 GB")))
		{
			System.out.println("The first two elements slected have Ram as 4GB");
		}
		else
		{
			System.out.println("The first two elements dont have Ram as 4GB");
		}
		
		//Brand type moto - the checkbox motorola is there
		driver.findElement(By.xpath(".//*[@id='container']/div/div[2]/div/div[2]/div/div/div[5]/section/div[1]")).sendKeys("moto");
		if ( !driver.findElement(By.xpath("//*[@id='container']/div/div[2]/div/div[2]/div/div/div[5]/section/div[2]/div[1]/div[5]/div/div/label/div[1]")).isSelected() )
		{
		     driver.findElement(By.xpath(".//*[@id='container']/div/div[2]/div/div[2]/div/div/div[5]/section/div[2]/div[1]/div[5]/div/div/label/div[1]")).click();
		}
		
		//1st 2 items, look for “Moto” in tile text of the items)
		if((driver.findElement(By.id("Moto on title 1")).getText().equalsIgnoreCase("moto")) &&
				(driver.findElement(By.id("Moto on title 2")).getText().equalsIgnoreCase("moto")))
				{
					System.out.println("The first two elements slected have Moto in the title");
				}
				else
				{
					System.out.println("The first two elements slected dont have Moto in the title");
				}
		
		//Test if user clears all filters in “Brand” (“RAM” filter is still 4 GB), then the page should contain items from other “Brand” also
		
		select = new Select(driver.findElement(By.id("locator of drop dow")));
		select.deselectAll();
		
		//Test if user can click of view details of “Moto G5 Plus (Lunar Grey, 32 GB)” by clicking the item in list view and new tab opens.
		String NavigateUrl="https://www.flipkart.com/moto-g5-plus-lunar-grey-32-gb/p/itmes2zjvwfncxxr?pid=MOBEQHMGMAUXS5BF&srno=b_1_1&otracker=CLP_filters&lid=LSTMOBEQHMGMAUXS5BFVCF0ZO";
		driver.navigate().to(NavigateUrl);
		
		//input necessary info and add to cart
		driver.findElement(By.id("zip code text box xpath")).sendKeys("122001");
		driver.findElement(By.id("click on add to cart")).click();
}
  }
