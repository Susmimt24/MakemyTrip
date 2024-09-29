package webpages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReviewBooking {
	WebDriver driver;	

		public ReviewBooking(WebDriver driver)
		{
			this.driver =driver;
			
		}
	
	public void review_booking()
	{
		driver.findElement(By.cssSelector("input#fName")).sendKeys("Test Fname");
		driver.findElement(By.cssSelector("input#lName")).sendKeys("Test Lname");
		driver.findElement(By.cssSelector("input#email")).sendKeys("nivya@gmail.com");
		driver.findElement(By.cssSelector("input#mNo")).sendKeys("9892423472");
		driver.findElement(By.cssSelector("span.checkboxWpr")).click();
		driver.findElement(By.xpath("//input[@id='tnc']//parent::div")).click();
		driver.findElement(By.xpath("//a[text()='Pay Now']")).click();
		
	}

}
