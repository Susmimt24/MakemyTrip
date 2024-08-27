package stepDefinitions;

import CommonProperties.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webpages.FlightSearchPage;

public class FlightSearchStepdef  extends BaseClass{
	FlightSearchPage FS = new FlightSearchPage(driver);
	
	@When("user entered \"([^\"]*)\" and \"([^\"]*)\" places$")
	public void user_entered_and_places(String from, String to) {
		System.out.println("Inside the setp def function");
		FS.selectPlace(from,to);
	  
	}

	@Then("user entered \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_entered_and(String fromDate, String toDate) {
	   
		FS.selectDates(fromDate,toDate);
	}
	
	@Then("select the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_entered_and(Integer travellers, String travellerClass) throws InterruptedException {
	   
		FS.enterPassengers(travellers,travellerClass);
	}
	@Then("click on Search")
	public void click_search() throws InterruptedException {
	   
		FS.search();
	}
}
