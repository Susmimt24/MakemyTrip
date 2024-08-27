package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonProperties.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass{
	
	@Before
	public void setup()
	{
		System.out.println("Opening the browser...");
		System.setProperty("webdriver.chrome.driver", "C:\\seleniumwebdriver\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		System.out.println("Chrome driver is set");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	@AfterStep
	public void stepteardown(Scenario scenario)
	{
		System.out.println("Screenshot before going to next step ");
            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName()); 
    }
	
	@After
	public void teardown(Scenario scenario)
	{
		
		
//		//validate if scenario has failed
//        if(!(scenario.isFailed())) {
//            final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screenshot, "image/png", scenario.getName()); 
//            System.out.println("Close browser");
//            driver.quit();
//        }   
        
        //HelperClass.tearDown();
    }
		
	}


