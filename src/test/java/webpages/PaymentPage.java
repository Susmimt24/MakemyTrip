package webpages;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage {

	WebDriver driver;	
	WebDriverWait wait;

		public PaymentPage(WebDriver driver)
		{
			this.driver=driver;
			
		}
		
		public void paymentDetails() {	
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Credit/Debit/ATM Card']")));
			//driver.findElement(By.xpath("//span[text()='Credit/Debit/ATM Card']")).click();
			driver.findElement(By.cssSelector("input#cardNumber")).sendKeys("123456789");
			driver.findElement(By.cssSelector("input#nameOnCard")).sendKeys("123456789");
		    Select expMonth = new Select(driver.findElement(By.xpath("//select[@name ='expiryMonth']")));
			expMonth.selectByVisibleText("April (04)");
			Select expyear = new Select(driver.findElement(By.xpath("//select[@name ='Year']")));
			expyear.selectByIndex(3);
			driver.findElement(By.cssSelector("input#cardCvv")).sendKeys("980");
			
		}
}
