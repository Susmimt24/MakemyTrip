package webpages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PrintDatesInFormat {
	WebDriver driver;
	
	@FindBy(id = "datepicker")
	WebElement dateInput;
	@FindBy(className = "demo-frame")
	WebElement dateframe;
	
	public PrintDatesInFormat(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterDate()
	{
		LocalDate currentDate = LocalDate.now();
		System.out.println(currentDate);
		driver.switchTo().frame(dateframe);
		dateInput.click();
		 DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d");
         DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMM");
         DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yy");

         String day = currentDate.format(dayFormatter);
         String month = currentDate.format(monthFormatter);
         String year = currentDate.format(yearFormatter);
         System.out.println(day);
         System.out.println(month);
         System.out.println(year);
         DateTimeFormatter fullFormatter = DateTimeFormatter.ofPattern("d MMM yyyy");
         String fulldate = currentDate.format(fullFormatter);
         System.out.println(fulldate);
		dateInput.sendKeys(fulldate);
		List<WebElement> dates = driver.findElements(By.className("ui-datepicker-week-end"));
		int size = dates.size() - 1;
		for (int i =3;i < size; i++)
		{
			if(i%2 == 0)
			{
				String sunday = dates.get(i).getText();
				System.out.println("Sunday : " + dates.get(i).getText());
			}
			else
			{
                String getSaturdaytxt = dates.get(i).getText();
                System.out.println("Saterday : " + dates.get(i).getText());
               
			}
		}
		 driver.switchTo().defaultContent();
		
		
	}
	
	public void selectCurrentDate() {

        try {
           // WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
            driver.switchTo().frame(dateframe);

            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d");
            DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM");
            DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");

            String day = currentDate.format(dayFormatter);
            String month = currentDate.format(monthFormatter);
            String year = currentDate.format(yearFormatter);

            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='ui-datepicker-title']//span[text()='" + month + "']")));

            WebElement monthElement = driver
                    .findElement(By.xpath("//div[@class='ui-datepicker-title']//span[text()='" + month + "']"));
            String monthtext = monthElement.getText();
            Assert.assertEquals(monthtext, month);

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[@class='ui-datepicker-title']//span[text()='" + year + "']")));

            WebElement yearElement = driver
                    .findElement(By.xpath("//div[@class='ui-datepicker-title']//span[text()='" + year + "']"));
            String yearText = yearElement.getText();
            Assert.assertEquals(yearText, year);

            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath("//td[@data-handler='selectDay']//a[text()='" + day + "']")));

            WebElement dayElement = driver
                    .findElement(By.xpath("//td[@data-handler='selectDay']//a[text()='" + day + "']"));
            String dayText = dayElement.getText();
            Assert.assertEquals(dayText, day);

            dayElement.click();

            System.out.println("Date: " + day + " " + month + " " + year);

            driver.switchTo().defaultContent();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
	public void selectAnyDate() {

        try {
          //  WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
           driver.switchTo().frame(dateframe);

            String currentDate = "10/01/2024";
            

            

            driver.switchTo().defaultContent();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
	
	
}
