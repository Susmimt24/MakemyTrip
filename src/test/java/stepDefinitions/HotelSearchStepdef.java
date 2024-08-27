package stepDefinitions;

import CommonProperties.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webpages.HomePage;
import webpages.HotelSearchPage;

public class HotelSearchStepdef  extends BaseClass{
	HotelSearchPage HS = new HotelSearchPage(driver);
	HomePage H = new HomePage(driver);

	@When("user click on \"([^\"]*)\" Tab$")
	public void user_click_on_hos_tab(String tabname) {
		H.tabSelction(tabname);
	}
	
	@When("user entered \"([^\"]*)\"$")
	public void enter_destination(String from) {
		HS.selectPlace(from);
	  
	}

	@Then("user entered \"([^\"]*)\" and \"([^\"]*)\" dates$")
	public void enter_dates(String fromDate, String toDate) {
	   
		HS.selectDates(fromDate);
		HS.selectDates(toDate);
	}
	
	@Then("select the \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void hotel_rooms(Integer rooms, Integer adults, Integer child) throws InterruptedException {
	HS.Roomdetails(rooms,adults,child);   
	
	}
	
	@Then("click on Hotel Search")
	public void click_hotel_search() throws InterruptedException {
	   
		HS.search();
	}
	
	@Then("Print all hotels and its price")
	public void print_hotels() throws InterruptedException {
	   
		HS.displayHotelDetails();
	}
	
	@Then("select the hotel with price range \"([^\"]*)\" and \"([^\"]*)\"$")
	public void select_hotel(Integer lowerprice, Integer higherprice) throws InterruptedException {
	HS.selectHotel(lowerprice,higherprice);   
	
	}
	@Then("Select the room")
	public void select_room() throws InterruptedException {
	   
		HS.selectRoom();
	}
	@Then("Review Booking")
	public void review_booking() throws InterruptedException {
		 HS.review_booking();
		}

	@Then("Enter details in Payment Page")
	public void payment() throws InterruptedException {
		 HS.paymentDetails();
		}
}


