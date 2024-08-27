package CommonProperties;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



import io.cucumber.java.Scenario;

public class BaseClass {
	
	public static WebDriver driver;
	
	public  void navigatetoUrl(String url)
	{
		driver.navigate().to(url);
			
	}
	public static void CaptureScreesnhot()
	{
            //File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            	//FileUtils.copyFile(src, new File("../Screenshots/"));
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        //scenario.attach(screenshot, "image/png", scenario.getName()); 
    }
	
	public static void scrollToBottom() throws InterruptedException {
		JavascriptExecutor jsDriver = (JavascriptExecutor)driver;
					
		try {
			long currentHeight = Long.parseLong(jsDriver.executeScript("return document.body.scrollHeight").toString());
			
			while(true) {
				jsDriver.executeScript("window.scrollTo(0,document.body.scrollHeight)");
				Thread.sleep(300);
				
				long newHeight = Long.parseLong(jsDriver.executeScript("return document.body.scrollHeight").toString());
				
				if(currentHeight==newHeight) break;
				currentHeight = newHeight;
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
	}
}