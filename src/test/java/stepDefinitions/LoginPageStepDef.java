package stepDefinitions;

import CommonProperties.BaseClass;
import io.cucumber.java.en.Given;
import webpages.MakeMyTripLoginPage;

public class LoginPageStepDef extends BaseClass{
	MakeMyTripLoginPage lg = new MakeMyTripLoginPage(driver);
	
	@Given("^User is navigated to MakemyTrip url$")
	public void user_is_on_home_page() {
		lg.navigatetoUrl();
	   System.out.println("User is navigated to the url");
	    
	}
	

}
