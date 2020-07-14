package test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

import pageObjects.AlertsObject;
import pageObjects.ElementsObjects;
import pageObjects.FormsObjects;
import resources.Base;

@Listeners(test.listeners.class)
public class ElementsObjectTest extends Base

{
	public static Logger log = LogManager.getLogger(ElementsObjectTest.class.getName());

	

	@BeforeTest
	public void urlLogin() throws IOException {
		driver = browserInvocation();
		log.info("Driver is invoked");
		// driver.manage().window().maximize();
		String url = prop.getProperty("URL");
		System.out.println(url);
		driver.get(url);
		log.info("Navigated to given URL");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
	}

	@Test(enabled = true, priority = 1)
	public void ElementsClick() throws IOException {
		ElementsObjects EO = new ElementsObjects(driver);
		EO.HomeElementclick().click();
		log.info("Element clicked");
		Actions A = new Actions(driver);
		WebElement element = EO.Webclick();
		A.moveToElement(element);
		A.click();
		A.build().perform();
		log.info("webelement clicked");
		EO.getDepartment();
		EO.AddBtnClick().click();
		EO.fillForm();
		EO.HomePagelink().click();
	}

	@Test(enabled = true, priority = 2)
	public void AlertsClick() {
		AlertsObject AO = new AlertsObject(driver);
		AO.HomeAlertclick().click();
		AO.bWindowClick().click();
		AO.NewTabCLick().click();
		String current = driver.getWindowHandle();
		Set<String> handle = driver.getWindowHandles();
		for (String i : handle) {
			if (!i.equalsIgnoreCase(current))
				driver.switchTo().window(i);
		}
		System.out.println(AO.sampleTabOpen().getText());
		driver.close();
		driver.switchTo().window(current);
		AO.NewWindowClick();
		Set<String> handle1 = driver.getWindowHandles();
		for (String j : handle1) {
			if (!j.equalsIgnoreCase(current)) {
				driver.switchTo().window(j);
				driver.manage().window().maximize();
				// driver.close();
			}
		}
		System.out.println(AO.sampleTabOpen().getText());
		driver.switchTo().window(current);
		AO.NewWindowMessageClick();
		// driver.close();
		driver.switchTo().window(current);
	}

	@Test(enabled = true, priority = 4)
	public void Forms() throws IOException {
		
		FormsObjects FO = new FormsObjects(driver);
		driver.manage().window().maximize();
		FO.HomePagelink().click();
		FO.HomeFormclick().click();
		log.info("Navigated to Homescreen");
		FO.FormClick().click();
		log.info("Clicked on form button on home screen");
		FO.PracticeFormClick().click();
		log.info("Clicked on practice form");
		ArrayList<String> values = FO.getData("Name");
		FO.FirstNameTextBox().sendKeys(values.get(1));
		log.info("Added First Name");
		FO.LastNameTextBox().sendKeys(values.get(2));
		log.info("Added Last Name");
		ArrayList<String> values1 = FO.getData("Email");
		FO.EmailTextBox().sendKeys(values1.get(1));
		log.info("Added Email");
		FO.radioBtn().click();
		log.info("Radio Button Clicked");
		boolean Selected = FO.RadioSelectCheck().isSelected();
		log.info(Selected);
		ArrayList<String> values2 = FO.getData("Mobile");
		FO.MobileTextBox().sendKeys(values2.get(1));
		log.info("Mobilenumber added");
		FO.dobTextBoxClick().click();
		Select s = new Select(FO.dateSelectClick());
		s.selectByValue("8");
		log.info("Month Selected");
		Select s1 = new Select(FO.yearSelectClick());
		s1.selectByValue("1996");
		log.info("Year Selected");
		int dayCount = FO.daySelectClick().size();
		List<WebElement> days = FO.daySelectClick();
		for (int i = 0; i < dayCount; i++) {
			if (days.get(i).getText().equalsIgnoreCase("9")) {
				System.out.println(days.get(i).getText());
				days.get(i).click();
				break;
			}
		}
		log.info("Date Selected");
		ArrayList<String> values3 = FO.getData("Subjects");
		WebDriverWait ww = new WebDriverWait(driver, 20);
		ww.until(ExpectedConditions.elementToBeClickable(FO.SubjectBox()));
		FO.SubjectBox().sendKeys(values3.get(1), Keys.ENTER);
		log.info("Subjects Entered");
		int CheckboxCount = FO.checkSelect().size();
		List<WebElement> Checkboxes = FO.checkSelect();
		for (int i = 0; i < CheckboxCount; i++) {
			Checkboxes.get(i).click();
		}
		log.info("Checkboxes selected");
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_DOWN).build().perform();
		ArrayList<String> values4 = FO.getData("Address");
		FO.Addressclick().sendKeys(values4.get(1) + " , " + values4.get(2));
		log.info("Address entered");
		FO.DDClick().click();
		ww.until(ExpectedConditions.elementToBeClickable(FO.DynamicDDClick()));
		// FO.selectState();
		FO.DynamicDDClick().sendKeys("Uttar Pradesh", Keys.ENTER);
		ww.until(ExpectedConditions.elementToBeClickable(FO.DynamicDDCitySelect()));
		FO.DynamicDDCitySelect().sendKeys("Agra", Keys.ENTER);
		log.info("City Selected");
		FO.Submission().click();
		log.info("form Submitted");
	}

	@Test(enabled = true, priority = 3)
	public void Frames() throws Throwable {
		AlertsObject AO = new AlertsObject(driver);
		Actions a = new Actions(driver);
		AO.HomePagelink().click();
		a.moveToElement(AO.HomeAlertclick());
		AO.HomeAlertclick().click();
		Robot r = new Robot();
		r.mouseWheel(50);
		AO.FrameClick();
		log.info("Switched to Frames");
		AO.GetFrame1Text();
		driver.switchTo().defaultContent();
		r.mouseWheel(50);
		AO.GetFrame2text();
		r.keyPress(KeyEvent.VK_PAGE_UP);
		driver.switchTo().defaultContent();
	}

	@AfterTest
	public void browserquit() {
		// driver.quit();
		log.info("Browser is closed");
	}

}
