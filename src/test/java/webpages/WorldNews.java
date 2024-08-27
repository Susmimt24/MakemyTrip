package webpages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SwitchToWindow;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonProperties.BaseClass;

public class WorldNews extends BaseClass{


	WebDriver driver;
	public WorldNews(WebDriver driver)
	{
		this.driver = driver;
	}

	
	public void clickonTab(String tab)
	{
		driver.findElement(By.xpath("//div/div/a[text()='"+tab+"']")).click();
		 driver.navigate().refresh();
		 WebDriverWait wait = new WebDriverWait(driver,15);
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/h1[text()='"+tab+"']")));
	}
	
	public void displayNews(int sessions)
	{
		
		 
		 List<WebElement> source = driver.findElements(By.xpath("//div[@class='f9uzM']//div[@class='MCAGUe']//div[@class='a7P8l']//div[@class='vr1PYe']"));
		 List<WebElement> headline = driver.findElements(By.xpath("//article[@class='UwIKyb']//div[@class='XlKvRb']//a[@class='WwrzSb']"));
		 
		 System.out.println("News headlines and source Only");
		 for(int i =0;i<sessions;i++)
		 {
			 System.out.println(source.get(i).getText());
			 System.out.println(headline.get(i).getText());		 
		 }
		 System.out.println("News headlines and news");
		 for(int i =0;i<sessions;i++)
		 {
			 System.out.println(source.get(i).getText());
			 headline.get(i).click();
			 BaseClass.CaptureScreesnhot();
		 }
		 
		 System.out.println("To switch or display the entire news");
		 ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		 for(int i=1;i<=sessions;i++)
		 {
			
			 driver.switchTo().window(newTab.get(i));
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 System.out.println(i);
			 driver.close();
			 driver.switchTo().window(newTab.get(0));
			 
		 } 
		 
	}
}
