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

public class Newsletter_Subscription {
	FirefoxDriver dr;
  @Test
  public void Newsletter_Sub() {
	  dr.manage().timeouts().implicitlyWait(25,TimeUnit.SECONDS);
	  dr.findElement(By.id("email")).sendKeys("psuresh.qatest@gmail.com");
	  dr.findElement(By.id("password")).sendKeys("suresh@123");  
	  dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[2]/form/table/tbody/tr[5]/td/a/div")).click();
	  Actions action = new Actions(dr);
	  WebElement event= dr.findElement(By.xpath("/html/body/table/tbody/tr[1]/td/div/ul/li[7]/a"));
	  action.moveToElement(event).build().perform();
	  Sleeper.sleepTightInSeconds(2);
	  dr.findElement(By.linkText("Newsletters")).click();
	 // dr.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td/div/ul/li[7]/ul/li[4]/a")).click();
	  String news=dr.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/input")).getText();
	  if(news.contains(news))
	  {
		  dr.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/input")).click();
		  System.out.println("PASSED: Successfully subscribe the newsletterss");
	  }
	  else
	  {
		  dr.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/table/tbody/tr[4]/td/input")).click();
		  System.out.println("FAILED: UN-Successfully subscribe the newsletterss");
	 }
	  }
  @BeforeMethod
  public void Set_Browser() {
	  dr=new FirefoxDriver();
	  dr.get("http://saipratap.net/ecommerce/customerlogin.php"); 
  }
  @AfterMethod
  public void Close() {
	  dr.close();
  }

}
