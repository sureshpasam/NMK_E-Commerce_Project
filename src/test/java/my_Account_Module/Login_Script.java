package my_Account_Module;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
public class Login_Script {
	FirefoxDriver dr;	
  @Test
  
  // login test
  public void Validlogintest() {
	  dr.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	  dr.findElement(By.id("email")).sendKeys("psuresh.qatest@gmail.com");
	  dr.findElement(By.id("password")).sendKeys("suresh@123");  
	  // this is new line
	  dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/form/table/tbody/tr[5]/td/a/div")).click();
  }
  // launch the broswer
  @BeforeMethod
  public void setup() {
	  dr= new FirefoxDriver();
	  dr.get("http://saipratap.net/ecommerce/customerlogin.php");
  }
  @AfterMethod
  public void close() 
  {
	  dr.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/div/ul/li[10]/a")).click();
	  dr.close();
  }

}
