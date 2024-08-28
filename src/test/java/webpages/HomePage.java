package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;	
		
		public HomePage(WebDriver driver)
		{
			this.driver =driver;
			
		}
		
		public void tabSelction(String tabname)
		{
			driver.findElement(By.xpath("//li[@data-cy = 'menu_"+tabname+"']//a")).click();
			 driver.navigate().refresh();
			 WebDriverWait wait = new WebDriverWait(driver,15);
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@data-cy = 'menu_"+tabname+"']//a[contains(@class,'active')]")));
		}
}
