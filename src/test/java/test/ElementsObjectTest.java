package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.oracle.tools.packager.Log;

import pageObjects.AlertsObject;
import pageObjects.ElementsObjects;
import pageObjects.FormsObjects;
import resources.Base;

@Listeners(test.listeners.class)
public class ElementsObjectTest extends Base

{
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void urlLogin() throws IOException {
		driver = browserInvocation();
		log.info("Driver is invoked");
		String url = prop.getProperty("URL");
		System.out.println(url);
		driver.get(url);
		log.info("Navigated to given URL");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(enabled = true)
	public void ElementsClick() throws IOException {

		ElementsObjects EO = new ElementsObjects(driver);

		EO.HomeElementclick().click();
		log.info("Element clicked");
		EO.Webclick().click();
		log.info("webelement clicked");
		EO.getDepartment();
		EO.AddBtnClick().click();
		EO.fillForm();
		EO.HomePagelink().click();
	}

	@Test(enabled = false)
	public void AlertsClick() {

		AlertsObject AO = new AlertsObject(driver);
		AO.sliderclick().click();
		AO.Webclick1();

	}

	@Test
	public void Forms() throws IOException {
		FormsObjects FO = new FormsObjects(driver);
		FO.HomeFormclick().click();
		Log.info("Navigated to Homescreen");
		FO.FormClick().click();
		Log.info("Clicked on form button on home screen");
		FO.PracticeFormClick().click();
		Log.info("Clicked on practice form");
		driver.manage().window().maximize();
		ArrayList<String> values = FO.getData("Name");
		FO.NameTextBox().sendKeys(values.get(1));
		Log.info("Added Name");
		ArrayList<String> values1 = FO.getData("Email");
		FO.EmailTextBox().sendKeys(values1.get(1));
		Log.info("Added Email");
		FO.radioBtn().click();
		Log.info("Radio Button Clicked");
		boolean Selected = FO.RadioSelectCheck().isSelected();
		log.info(Selected);
		ArrayList<String> values2 = FO.getData("Mobile");
		FO.MobileTextBox().sendKeys(values2.get(1));
		Log.info("Mobilenumber added");
		FO.dobTextBoxClick().click();
		Select s = new Select(FO.dateSelectClick());
		s.selectByValue("8");
		Log.info("Month Selected");
		Select s1 = new Select(FO.yearSelectClick());
		s1.selectByValue("1996");
		Log.info("Year Selected");
		int dayCount = FO.daySelectClick().size();
		List<WebElement> days = FO.daySelectClick();
		for (int i = 0; i < dayCount; i++) {
			if (days.get(i).getText().equalsIgnoreCase("9")) {
				System.out.println(days.get(i).getText());
				days.get(i).click();
				break;
			}
		}
		Log.info("Date Selected");
		ArrayList<String> values3 = FO.getData("Subjects");
		WebDriverWait ww = new WebDriverWait(driver, 20);
		ww.until(ExpectedConditions.elementToBeClickable(FO.SubjectBox()));
		FO.SubjectBox().sendKeys(values3.get(1), Keys.ENTER);
		Log.info("Subjects Entered");
		int CheckboxCount = FO.checkSelect().size();
		List<WebElement> Checkboxes = FO.checkSelect();
		for (int i = 0; i < CheckboxCount; i++) {
			Checkboxes.get(i).click();
		}
		Log.info("Checkboxes selected");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		ArrayList<String> values4 = FO.getData("Address");
		FO.Addressclick().sendKeys(values4.get(1)+" , "+values4.get(2));
		log.info("Address entered");
	}

	@AfterTest
	public void browserquit() {
		// driver.quit();
		log.info("Browser is closed");
	}

}
