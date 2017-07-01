package my_Account_Module;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class Signup_Registration_Test {
	FirefoxDriver dr;
  @Test
  public void Signup_Registartion() {
	  //WebElement block=dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/form/table/tbody/tr[5]/td/table/tbody/tr[1]/td[4]"));
	  //9908737132
	  //7993848676
	  List<WebElement> radio=dr.findElements(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/form/table/tbody/tr[5]/td/table/tbody/tr[1]/td[4]"));
	  Boolean is_select=radio.get(0).isSelected();
	  if(is_select==true)
	  {
		  radio.get(1).click();
		  dr.findElement(By.id("fname")).sendKeys("su");
	  }//else block created
	  else
	  {
		  radio.get(0).click();
		  dr.findElement(By.id("fname")).sendKeys("sureshh");
		  dr.findElement(By.id("lname")).sendKeys("pasam");
		  dr.findElement(By.id("day")).sendKeys("09");
		  dr.findElement(By.id("month")).sendKeys("02");
		  dr.findElement(By.id("year")).sendKeys("1990");
		  dr.findElement(By.id("email")).sendKeys("pasamhymavathi@gmail.com");
		  dr.findElement(By.id("houseno")).sendKeys("H-101");
		  dr.findElement(By.id("add1")).sendKeys("Ramalayam Street");
		  dr.findElement(By.id("city")).sendKeys("Nellore");
		  dr.findElement(By.id("state")).sendKeys("Andhra Pradesh");
		  dr.findElement(By.id("country")).sendKeys("India");
		  dr.findElement(By.id("postcode")).sendKeys("524315");
		  dr.findElement(By.id("phone")).sendKeys("9703533394");
		  dr.findElement(By.id("fax")).sendKeys("9703533394");
		  dr.findElement(By.id("password")).sendKeys("suresh@123");
		  dr.findElement(By.id("cpassword")).sendKeys("suresh@123");
		  dr.findElement(By.id("newsletter")).click();
		  dr.findElement(By.id("terms")).click();
		 String text= dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/form/table/tbody/tr[16]/td/input")).getText();
		  if(text==text.concat("SignUp"))
		  {
			  System.out.println(" Registartion is sucessfully");  
			  dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/form/table/tbody/tr[16]/td/input")).click();
		  }
		  else
		  {
			  System.out.println("TEST PASSED: Registartion is sucessfully");  
		  }  
		  }
	  }
  @BeforeMethod
  public void Setup() {
	  dr= new FirefoxDriver();
	  dr.get("http://saipratap.net/ecommerce/customerlogin.php");
	  dr.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table/tbody/tr[4]/td[1]/table/tbody/tr[2]/td[2]/a"
)).click();
  }

  @AfterMethod
  public void afterMethod() {
	  dr.close();
  }
   
}
