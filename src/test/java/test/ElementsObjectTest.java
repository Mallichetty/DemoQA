package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pages.AlertsObject; 
import Pages.ElementsObject;
import Pages.FormsObject;
import resources.Base;

@Listeners(test.listeners.class)
public class ElementsObjectTest extends Base

{
	public static Logger log = LogManager.getLogger(ElementsObjectTest.class.getName());

	@BeforeTest
	public void urlLogin() throws IOException {
		driver = browserInvocation();
		log.info("Driver is invoked");
		//driver.manage().window().maximize();
		String url = prop.getProperty("URL");
		System.out.println(url);
		driver.get(url); 
		log.info("Navigated to given URL");
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}

	@Test(enabled = true, priority = 1)
	public void ElementsClick() throws IOException {
		ElementsObject eo = new ElementsObject();
		eo.HomeScreenElementClick();
		eo.WebTableClick();
		eo.getDepartment();
		eo.addBtnClick();
		eo.fillForm();
		eo.HomePageClick();
	}

	@Test(enabled = true, priority = 2)
	public void browserWindowClick() {
		AlertsObject AO = new AlertsObject();
		AO.HomeAlertClick();
		AO.BrowserWindowClick();
		AO.NewTabButtonClick();
		AO.NewWindowButtonClick();
		AO.newWindowMessageButtonClick(); 

	}

	@Test(enabled = true, priority = 4)
	public void Forms() throws IOException {
		
		FormsObject FO = new FormsObject();
		FO.HomeScreenClick();
		FO.HomeFormClick();
		FO.FormLinkClick();
		FO.PracticeFormLinkClick();
		FO.setFieldValues();
	}

	@Test(enabled = true, priority = 3)
	public void Frames() throws Throwable
	{
		
		AlertsObject AO = new AlertsObject();
		//AO.HomeScreenClick();
		//AO.HomeAlertClick();
		AO.FrameLinkClick();
		AO.getFrame1text();
		AO.getFrame2text();

	}

	@AfterTest
	public void browserquit() {
		driver.quit();
		log.info("Browser is closed");
	}

}
