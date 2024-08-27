package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MakeMyTripLoginPage {
	WebDriver driver;
	//private By 
	
	public MakeMyTripLoginPage(WebDriver driver)
	{
		this.driver =driver;
	}

	public  void navigatetoUrl()
	{
		driver.navigate().to("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
			
	}
}
