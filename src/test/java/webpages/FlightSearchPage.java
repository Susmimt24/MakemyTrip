package webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonProperties.BaseClass;

public class FlightSearchPage {
	WebDriver driver;
	
	
	//private By 
	
	public FlightSearchPage(WebDriver driver)
	{
		this.driver =driver;
		
	}
	
	public void selectPlace(String FromCity, String ToCity)
	{
		WebDriverWait wait = new WebDriverWait(driver,20000);
		driver.findElement(By.id("fromCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(FromCity);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='SUGGESTIONS ']")));
		driver.findElement(By.xpath("//li[@class='react-autosuggest__suggestion react-autosuggest__suggestion--first']")).click();
		driver.findElement(By.id("toCity")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(ToCity);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='SUGGESTIONS ']")));
		driver.findElement(By.xpath("//li[@role='option']")).click();
	}
	
	public void selectDates(String FromDate, String ToDate)
	{
	//	String months = "5 January 2025";
		String months = FromDate;
		String day = months.substring(0, 1);
		System.out.println(day);
		String month = months.substring(2);
		System.out.println(month);
		Boolean flag = false;
	   String firstmonth="",secondmonth="";
		for(int i =0;i<12;i++)
		{
		firstmonth = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")).getText();
		secondmonth = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[2]")).getText();
        if((month.equals(firstmonth)) || (month.equals(secondmonth)))
		{
        flag = true;
		break;		
		}
		else
		{ driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		}
	}
			if(flag)
			{if(month.equals(secondmonth))
						{ driver.findElement(By.xpath("(//div[@class='DayPicker-Month']//div[@class='DayPicker-Day']/div/p[text()='"+day+"'])[2]")).click();
					
						}
			}
			
			//String arrivalmonths = "10 April2025";
			String arrivalmonths = ToDate;
			String arrivalday = arrivalmonths.substring(0, 2);
			System.out.println(arrivalday);
			String arrivalmonth = arrivalmonths.substring(3);
			System.out.println(arrivalmonth);	
			
	driver.findElement(By.xpath("//div[@data-cy = 'returnArea']")).click();		
	flag = false;		
	for(int i =0;i<12;i++)
	{
	firstmonth = driver.findElement(By.xpath("//div[@class='DayPicker-Caption']/div")).getText();
	secondmonth = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption']/div)[2]")).getText();
	System.out.println(secondmonth);
    if((arrivalmonth.equals(firstmonth)) || (arrivalmonth.equals(secondmonth)))
	{
    flag = true;
	break;		
	}
	else
	{ driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
	}
}
		if(flag)
		{if(arrivalmonth.equals(secondmonth))
					{ driver.findElement(By.xpath("(//div[@class='DayPicker-Month']//div[@class='DayPicker-Day']/div/p[text()='"+arrivalday+"'])[2]")).click();
				
					}
		}

	
}
	
	
	public void enterPassengers(Integer Travellers,String travellerClass) throws InterruptedException
	{
		//driver.findElement(By.xpath("//label[@for='travellers']")).click();
		driver.findElement(By.xpath("//div[@data-cy='flightTraveller']")).click();
		
		driver.findElement(By.xpath("//p[@data-cy='adultRange']/following-sibling::ul/li[text()='"+Travellers+"']")).click();		
		driver.findElement(By.xpath("//p[@data-cy='childrenRange']/following-sibling::ul/li[text()='"+Travellers+"']")).click();
		driver.findElement(By.xpath("//p[@data-cy='infantRange']/following-sibling::ul/li[text()='"+Travellers+"']")).click();
		driver.findElement(By.xpath("//p[@data-cy='chooseTravelClass']/following-sibling::ul/li[text()='"+travellerClass+"']")).click();
		
		WebElement element = driver.findElement(By.xpath("//button[@data-cy='travellerApplyBtn']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,550)", "");
		
		//element.sendKeys(Keys.DOWN);

	}
	
	public void search()
	{
		driver.findElement(By.xpath("//a[text()='Search']")).click();
	}
}
