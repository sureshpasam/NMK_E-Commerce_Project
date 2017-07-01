package my_Account_Module;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class WishList_Script {
	FirefoxDriver dr;
  @Test
  public void Wishlist_Script() {
	  dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  dr.findElement(By.id("email")).sendKeys("psuresh.qatest@gmail.com");
	  dr.findElement(By.id("password")).sendKeys("suresh@123");  
	  dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/form/table/tbody/tr[5]/td/a/div")).click();
	  Actions action = new Actions(dr);
	  WebElement event= dr.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/div/ul/li[7]/a"));
	  action.moveToElement(event).build().perform();
	//  Sleeper.sleepTightInSeconds(1);
	  dr.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/div/ul/li[7]/ul/li[1]/a")).click();
	  dr.findElement(By.id("frndemail")).sendKeys("sureshpasam94@gmail.com");
	  dr.findElement(By.id("frndname")).sendKeys("suresh pasam");
	  String text=dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/form/table/tbody/tr[7]/td/input")).getText();
	  String title=dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/form/table/tbody/tr[7]/td/input")).getText();
	  if(text.contains(title))
	  {
		  dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/form/table/tbody/tr[7]/td/input")).click();
		  System.out.println("PASSED :Successully send mail WishLIST");
		  }
	  else
	  {
		  System.out.println("FAILED: In-Valid Email Id");  
	  }
  }
  @BeforeMethod
  public void setup() {
	  dr= new FirefoxDriver();
	  dr.get("http://saipratap.net/ecommerce/customerlogin.php");
	  }
  @AfterMethod
  public void Close() {
	  dr.close();
  }

}
