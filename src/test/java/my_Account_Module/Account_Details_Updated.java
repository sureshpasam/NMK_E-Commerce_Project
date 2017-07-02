package my_Account_Module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Account_Details_Updated {
	FirefoxDriver dr;
  @Test
  public void Updated_Account_Details() {
	  dr.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
	  dr.findElement(By.id("email")).sendKeys("psuresh.qatest@gmail.com");
	  dr.findElement(By.id("password")).sendKeys("suresh@123");  
	  dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/form/table/tbody/tr[5]/td/a/div")).click();
	  Actions action = new Actions(dr);
	  WebElement event= dr.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/div/ul/li[7]/a"));
	  action.moveToElement(event).build().perform();
	 // Sleeper.sleepTightInSeconds(2);
	  dr.findElement(By.linkText("Account Details")).click();
	  dr.findElement(By.id("fname")).clear();
	  dr.findElement(By.id("fname")).sendKeys("suresh123");
	  dr.findElement(By.id("lname")).clear();
	  dr.findElement(By.id("lname")).sendKeys("pasam321");
	  dr.findElement(By.id("dob")).clear();
	  dr.findElement(By.id("dob")).sendKeys("09-02-1991");
	  //dr.findElement(By.id("email")).clear();
	  //dr.findElement(By.id("email")).sendKeys("sureshpasam94@gmail.com");
	  dr.findElement(By.id("phone")).clear();
	  dr.findElement(By.id("phone")).sendKeys("9703533395");
	  dr.findElement(By.id("fax")).clear();
	  dr.findElement(By.id("fax")).sendKeys("9703533393");
	  dr.findElement(By.id("street")).clear();
	  dr.findElement(By.id("street")).sendKeys("Sivalayam Street");
	  dr.findElement(By.id("city")).clear();
	  dr.findElement(By.id("city")).sendKeys("Hyd");
	  dr.findElement(By.id("state")).clear();
	  dr.findElement(By.id("state")).sendKeys("Tamilnaidu");
	  dr.findElement(By.id("country")).clear();
	  dr.findElement(By.id("country")).sendKeys("India");
	  dr.findElement(By.id("postcode")).clear();
	  dr.findElement(By.id("postcode")).sendKeys("524315");
	  String update=dr.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[15]/td/input")).getText();
	  if(update.contains(update))
	  {
		  dr.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[15]/td/input")).click();
		  System.out.println("PASSED: Successully Updated All the Fields");  
	  }
	  else
	  {
		  dr.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[15]/td/input")).click();
		  System.out.println("FAILED: Updation not Successfully");
	  }  
  }
  @BeforeMethod
  public void Browser_Setup() {
	  
	  dr=new FirefoxDriver();
	  dr.get("http://saipratap.net/ecommerce/customerlogin.php");
  }

  @AfterMethod
  public void close() {
	  dr.close();

  }

}
