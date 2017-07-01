package my_Account_Module;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Loginand_logout_Script {
	FirefoxDriver dr;
  @Test
  public void Login_LOGOU_Script() {
	  dr.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
	  dr.findElement(By.id("email")).sendKeys("psuresh.qatest@gmail.com");
	  dr.findElement(By.id("password")).sendKeys("suresh@123");  
	  dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/form/table/tbody/tr[5]/td/a/div")).click();  
	  }
  @BeforeMethod
  public void Setup_Browser() {
	  dr=new FirefoxDriver();
	  dr.get("http://saipratap.net/ecommerce/customerlogin.php");
  }
  @AfterMethod
  public void Logout_Closed() {
	  dr.findElement(By.linkText("LOGOUT")).click();
	  System.out.println("PASSED: Successully is done the logout");
	  dr.close();
  }

}
