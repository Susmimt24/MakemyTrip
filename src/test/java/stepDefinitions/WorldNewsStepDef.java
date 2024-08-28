package stepDefinitions;

import CommonProperties.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webpages.Login;
import webpages.PrintDatesInFormat;
import webpages.WorldNews;

public class WorldNewsStepDef extends BaseClass {
	
	BaseClass b = new BaseClass();
	WorldNews w = new WorldNews(driver);
	PrintDatesInFormat df = new PrintDatesInFormat(driver);
	
	@Given("^User is navigated to url \"([^\"]*)\"$")
	public void navigateToUrl(String url)
	{
		b.navigatetoUrl(url);
	}
	
	@When("^Click on \"([^\"]*)\" Tab.$")
	public void click_on_tab(String tab) {
	 w.clickonTab(tab);
       
	}

	@Then("^Display News of first \"([^\"]*)\" sections$")
	public void display_news_of_first_sections(Integer session) {
	    w.displayNews(session);
	}

	
	@Then("^Print current month WeekEnd Dates.$")
	public void print_weekend() {
		df.enterDate();
	   
	}
	
	@Then("^Print the Current Date in format DD-MMMMM-YYYY$")
	public void print_ddmmyy() {
		df.selectCurrentDate();
	}
}
