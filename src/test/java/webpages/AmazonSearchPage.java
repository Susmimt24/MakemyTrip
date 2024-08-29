package webpages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;
import org.openqa.selenium.Keys;

//import org.openqa.selenium.WebDriver;

public class Login {
	
	WebDriver driver;
	public Login(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements( driver, this); 
		System.out.println("Inside constructor for setting driver");
	}
	
	@FindBy(id="twotabsearchtextbox")
	static WebElement searchbox;
	
	@FindBy(xpath = "//*[@id='search']//h2/a/span")
	static List<WebElement> li;
	
	public  void navigatetoUrl()
	{
		driver.navigate().to("https://www.amazon.in/");
			
	}
	public void search(String searchitem)
	{
		searchbox.sendKeys(searchitem);
		searchbox.sendKeys(Keys.ENTER);
			
	}
	
	public void iphonelist()
	{
		for(WebElement element : li)
		  {
			 System.out.println("All mobile names " + element.getText());
		  }
	}
	
	public void specificIphone(String gb)
	{
		System.out.println("Iphone with only 128 GB");
		for(WebElement element : li)
	  {
		 if(element.getText().contains(gb))
		 {
			 System.out.println(element.getText());
		 }
	  }
		
	}
}
