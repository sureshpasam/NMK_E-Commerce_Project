package my_Account_Module;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.server.browserlaunchers.Sleeper;
import org.testng.annotations.AfterMethod;

public class Tracking_Order_Script {
	FirefoxDriver dr;
  @Test
  public void Track_Order_Script() {
	  dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  dr.findElement(By.id("email")).sendKeys("psuresh.qatest@gmail.com");
	  dr.findElement(By.id("password")).sendKeys("suresh@123");  
	  dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/form/table/tbody/tr[5]/td/a/div")).click();
	  Actions action = new Actions(dr);
	  WebElement event= dr.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/div/ul/li[7]/a"));
	  action.moveToElement(event).build().perform();
	  Sleeper.sleepTightInSeconds(1);
	  dr.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/div/ul/li[7]/ul/li[2]/a")).click();
	  dr.findElement(By.name("search")).sendKeys("123123");
	  dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/form/div/input[2]")).click();
	  String text=dr.findElement(By.name("search")).getText();
	  String val=dr.findElement(By.name("search")).getAttribute("value");
	  if(text.contains(val)){
		  System.out.println("PASSED: Tacking the order Sucessfully: "+val);
	  }
	  else{
		  System.out.println("FAILED: Invalid order Number:" +val); 
	  }
	  }
  @BeforeMethod
  public void setup() {
	  dr= new FirefoxDriver();
	  dr.get("http://saipratap.net/ecommerce/customerlogin.php");
  }
  @AfterMethod
  public void close() {
	  dr.close();
  }

}
