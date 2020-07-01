package test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.ElementsObjects;
import resources.Base;

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

	}

	@Test
	public void ElementsClick() throws IOException {

		ElementsObjects EO = new ElementsObjects(driver);

		EO.HomeElementclick().click();
		log.info("Element clicked");

	}

	@AfterTest
	public void browserquit() {
		driver.quit();
		log.info("Browser is closed");
	}

}
