package stepDefinitions;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Page_Object_Factory.Object_Factory_ElementsObjects;
import Pages.AlertsObject;
import Pages.ElementsObject;
import Pages.FormsObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import resources.Base;
import test.ElementsObjectTest;

@RunWith(Cucumber.class)

public class StepDefinitions  {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = LogManager.getLogger(StepDefinitions.class.getName());

	ElementsObjectTest E1T = new ElementsObjectTest();
	ElementsObject 	E1 = new ElementsObject();
	AlertsObject AO = new AlertsObject();
	FormsObject FO = new FormsObject();

	@Given("^User is in HomeScreen$")
	public void user_is_in_homescreen() throws Throwable {
		
		ElementsObject 	E1 = new ElementsObject();
		E1T.urlLogin();
		System.out.println("navigated to url mentioned");
		E1.HomeScreenElementClick();
		System.out.println("HomeSreenElementClicked");
	}

	@When("^User navigated to Elements Objects$")
	public void user_navigated_to_elements_objects() throws Throwable {
		E1.WebTableClick();
		System.out.println("webTable clicked");
	}

	@Then("^User should fetch the webTable values and store it in a array$")
	public void user_should_fetch_the_webtable_values_and_store_it_in_a_array() throws Throwable {
		E1.getDepartment();
		System.out.println("Department Details retrived");
		E1.getAge();
		System.out.println("Age Details retrived");
	}

	@Then("^User should use the same array values to add the new User$")
	public void user_should_use_the_same_array_values_to_add_the_new_user() throws Throwable {
		E1.addBtnClick();
		System.out.println("Add Button Clicked");
		E1.fillForm();
		System.out.println("Form filled");
	}
	

    @Given("^User is already on the DemoQA site$")
    public void user_is_already_on_the_demoqa_site() throws Throwable 
    {
    	E1.HomePageClick();
    	System.out.println("Navigated back to home screen");
    }

    @When("^User navigated to Alerts objects$")
    public void user_navigated_to_alerts_objects() throws Throwable {
    	AO.HomeAlertClick();
    	System.out.println("Navigated to Alerts object");
    	
    }

    @Then("^User should click the Browser window button$")
    public void user_should_click_the_browser_window_button() throws Throwable {
    	AO.BrowserWindowClick();
    	System.out.println("Clicked on Browser window button");
    }

    @And("^User should Open the New tab and close it$")
    public void user_should_open_the_new_tab_and_close_it() throws Throwable {
    	AO.NewTabButtonClick();
    	System.out.println("User opened and closed New Tab");
    }

    @And("^User should Open the New window and close it$")
    public void user_should_open_the_new_window_and_close_it() throws Throwable {
    	AO.NewWindowButtonClick();
    	System.out.println("User opened and closed New window");
    }

    @And("^User should Open the New Window Message and close it$")
    public void user_should_open_the_new_window_message_and_close_it() throws Throwable {
    	AO.newWindowMessageButtonClick();
    	System.out.println("User opened and closed New window message");
    }

    @When("^User is already on the Alerts objects$")
    public void user_is_already_on_the_alerts_objects() throws Throwable {
    	System.out.println("User opened and closed New window message");
    }

    @Then("^User should click on the Framelink Click$")
    public void user_should_click_on_the_framelink_click() throws Throwable {
    	AO.FrameLinkClick();
    	System.out.println("User clicked on Framelink");
    }

    @And("^User should switch to Frame1 and get the frame text1$")
    public void user_should_switch_to_frame1_and_get_the_frame_text1() throws Throwable {
    	AO.getFrame1text();
    	System.out.println("User got the Frame1 text");
    }

    @And("^User should switch to Frame2 and get the frame text2$")
    public void user_should_switch_to_frame2_and_get_the_frame_text2() throws Throwable {
    	AO.getFrame2text();
    	System.out.println("User got the Frame2 text");
    }
    
    @Given("^User is on Home Page$")
    public void user_is_on_home_page() throws Throwable 
    {
    	FO.HomeScreenClick();
    	System.out.println("User navigated back to Home page");
     
    }

    @When("^User Navigated to Forms Object$")
    public void user_navigated_to_forms_object() throws Throwable {
    	FO.HomeFormClick();
    	System.out.println("User clicked on Forms object Link from home Page");
    }

    @Then("^User should click on formlink$")
    public void user_should_click_on_formlink() throws Throwable {
    	FO.FormLinkClick();
    	
    	System.out.println("User clicked on forms Link  ");
    }

    @And("^User should click on PracticeForm link$")
    public void user_should_click_on_practiceformlink() throws Throwable
    {
    	FO.PracticeFormLinkClick();
    	System.out.println("User clicked on practice link");
    }

    @And("^User should set the field values$")
    public void user_should_set_the_field_values() throws Throwable {
    	FO.setFieldValues();
    	System.out.println("User entered the form and saved it");
    }
}

