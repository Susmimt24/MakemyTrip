package webpages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DisplayHotelDetails {
	WebDriver driver;	
	Map <String, String> hotelDetails = new HashMap<>();

		public DisplayHotelDetails(WebDriver driver)
		{
			this.driver =driver;
			
		}
public void AllHotelDetails() {
		
		//List<WebElement> li = driver.findElements(By.xpath("//div//div/p[@id='hlistpg_hotel_name']/span[contains(@id,'htl_id')]"));
		List<WebElement> hotelname = driver.findElements(By.cssSelector("div>div>p#hlistpg_hotel_name>span:first-child"));
		
		for(WebElement element : hotelname)
		  {
			 System.out.println("All Hotel names " + element.getText());
		  }
		  
		List<WebElement> hotelprice = driver.findElements(By.cssSelector("div>div>p#hlistpg_hotel_shown_price"));
		for(WebElement element : hotelprice)
		  {
			 System.out.println("All Hotel prices " + element.getText().substring(2));
		  }
		
		
		
		for (int k = 0; k < hotelname.size(); k++)
	    {
			hotelDetails.put(hotelname.get(k).getText(), hotelprice.get(k).getText().substring(2));
	    }
		 System.out.println(hotelDetails);
		 
		 for(Map.Entry<String, String> set : hotelDetails.entrySet())
		 {
			 System.out.println(set.getKey() + " - " + set.getValue());
		 }
	}

	public void selectHotel(Integer lowerprice, Integer higherprice) {
		
		for (String key : hotelDetails.keySet())
	    {
			int hotelPrice = Integer.parseInt(hotelDetails.get(key).replaceAll(",",""));
			if(hotelPrice > lowerprice && hotelPrice < higherprice)
			{
				driver.findElement(By.xpath("//div//div//p[text()='"+hotelDetails.get(key)+"']")).click();
				break;
			}  }   }
}
