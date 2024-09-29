package webpages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelSearchPage {
WebDriver driver;	
WebDriverWait wait;
Map <String, String> hotelDetails = new HashMap<>();

	public HotelSearchPage(WebDriver driver)
	{
		this.driver =driver;
		
	}
 
	public void selectPlace(String City)
	{
		wait = new WebDriverWait(driver,20000);	
		driver.findElement(By.xpath("//span[@data-cy='hotelCityLabel']")).click();
		driver.findElement(By.xpath("//input[@title='Where do you want to stay?']")).sendKeys(City);		
		driver.findElement(By.xpath("//input[@title='Where do you want to stay?']")).sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//p[text()='Popular']")));
		driver.findElement(By.xpath("//li[@class='react-autosuggest__suggestion react-autosuggest__suggestion--first']")).click();
	}
	
	public void selectDates(String Dates)
	{
		String months = Dates;
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
		System.out.println(firstmonth);
		System.out.println(secondmonth);
        if((month.equals(firstmonth)) || (month.equals(secondmonth)))
		{
        flag = true;
		break;		
		}
		else{ driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
		}}
		if(flag){
		if(month.equals(secondmonth)){ 
		driver.findElement(By.xpath("(//div[@class='DayPicker-Month']//div[text()='"+day+"'])[2]")).click();				
		}}}
		
	public void search(){
		driver.findElement(By.xpath("//button[text()='Search']")).click();
	}

	public void Roomdetails(Integer rooms, Integer adults, Integer child) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='gstSlct']")));
		driver.findElement(By.xpath("//div[@class='gstSlct']")).click();			
		driver.findElement(By.xpath("//div[@class='gstSlct']/following-sibling::ul/li[text()='"+rooms+"']")).click();
		driver.findElement(By.xpath("(//div[@class='gstSlct'])[2]")).click();			
		driver.findElement(By.xpath("//div[@class='gstSlct']/following-sibling::ul/li[text()='"+adults+"']")).click();
		driver.findElement(By.xpath("(//div[@class='gstSlct'])[3]")).click();			
		driver.findElement(By.xpath("//div[@class='gstSlct']/following-sibling::ul/li[text()='"+child+"']")).click();
		JavascriptExecutor jss = (JavascriptExecutor)driver;
		int k =4;
	    for(int i=1;i<=child;i++) {
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='gstSlct'])[4]")));
	    	WebElement elements = driver.findElement(By.xpath("(//div[@class='gstSlct'])["+k+"]"));
	    	JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("arguments[0].click();", elements);	    	
	    	WebElement element = driver.findElement(By.xpath("//div[@class='gstSlct']/following-sibling::ul/li[text()='7']"));
			js.executeScript("arguments[0].click();", element);
			k++;
	    }
	    WebElement elementApply = driver.findElement(By.xpath("//button[text()='Apply']"));
	    jss.executeScript("arguments[0].click();", elementApply);
	}

	
}
