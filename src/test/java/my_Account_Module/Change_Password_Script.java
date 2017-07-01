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

public class Change_Password_Script {
	FirefoxDriver dr;
  @Test(priority=0)
  public void update_Pwd() {
	  dr.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
	  dr.findElement(By.id("email")).sendKeys("psuresh.qatest@gmail.com");
	  dr.findElement(By.id("password")).sendKeys("suresh@123");  
	  dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/form/table/tbody/tr[5]/td/a/div")).click();
	  Actions action = new Actions(dr);
	  WebElement event= dr.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/div/ul/li[7]/a"));
	  action.moveToElement(event).build().perform();
	  Sleeper.sleepTightInSeconds(2);	
	 // dr.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/ul/li[7]/ul/li[3]/a")).click();
	  dr.findElement(By.linkText("Change Password")).click();
	  dr.findElement(By.id("old_password")).sendKeys("suresh@123");
	  dr.findElement(By.id("new_password")).sendKeys("suresh@123");
	  String np=dr.findElement(By.id("new_password")).getText();
	  dr.findElement(By.id("confirm_password")).sendKeys("suresh@123");
	  String cp= dr.findElement(By.id("confirm_password")).getText();
	  if(np.equals(cp))
	  {
		  dr.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/input[1]")).click();
		  System.out.println("PASSED: Password change in successfully");
	  }
	  else{
		  dr.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/input[1]")).click();
		  System.out.println("FAILED: Password IS NOT Successfully Changed");
	  }  
  }
  @Test(priority=1)
  public void Rest_clear()
  {  
  dr.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
  dr.findElement(By.id("email")).sendKeys("psuresh.qatest@gmail.com");
  dr.findElement(By.id("password")).sendKeys("suresh@123");  
  dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/form/table/tbody/tr[5]/td/a/div")).click();
  Actions action = new Actions(dr);
  WebElement event= dr.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/div/ul/li[7]/a"));
  action.moveToElement(event).build().perform();
  Sleeper.sleepTightInSeconds(2);	
 // dr.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/ul/li[7]/ul/li[3]/a")).click();
  dr.findElement(By.linkText("Change Password")).click();
	  dr.findElement(By.id("old_password")).sendKeys("suresh@123");
	  dr.findElement(By.id("new_password")).sendKeys("suresh@123");
	  dr.findElement(By.id("confirm_password")).sendKeys("suresh@123");
	  String reset1=dr.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/input[2]")).getText();
	  
	  if(reset1.equals("rest"))
	 {
		 dr.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/input[2]")).click();
		 System.out.println("PASSED: Sucessfully reset the all fields");
	 }else
	 {
	  dr.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/input[2]")).click();
		 System.out.println("PASSED: Sucessfully reset the all fields");
	  }
	  }
  @BeforeMethod
  public void setup() {
	  dr=new FirefoxDriver();
	  dr.get("http://saipratap.net/ecommerce/customerlogin.php");
  }
  @AfterMethod
  public void close() {
	  dr.close();
  }

}
