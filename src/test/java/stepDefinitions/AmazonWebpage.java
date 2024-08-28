package stepDefinitions;

import CommonProperties.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import webpages.Login;


public class AmazonWebpage extends BaseClass{

	Login lg = new Login(driver);
	
	@Given("^User is navigated to url$")
	public void user_is_on_home_page() {
		lg.navigatetoUrl();
	   System.out.println("User is navigated to the url");
	    
	}

	@When("^search for \"([^\"]*)\"$")
	public void i_check_for_the_in_step(String searchItem) {
		lg.search(searchItem);
	}

	@Then("^display all iphones$")
	public void i_verify_the_success_in_step() {
		lg.iphonelist();
	   
	}
	
	@Then("^display only iphone with \"([^\"]*)\"$")
	public void display_only_iphone_with_GB(String arg1) {
	lg.specificIphone(arg1);
	}
}
