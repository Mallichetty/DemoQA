package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementsObjects {
	WebDriver driver;

	By Elementclick = By.xpath("//div[@class='category-cards']/div[1]");
	By WebTableClick = By.xpath("//span[text()='Web Tables']");
	By addrecordclick = By.id("addNewRecordButton");
	By columnNameDep = By.xpath("//div[@class='rt-tr']/div[6]"); 
	By columnNameAge = By.xpath("//div[@class='rt-tbody']/div/div/div[3]");
	By homescreenLink = By.xpath("//a[@href= 'https://demoqa.com']");

	public ElementsObjects(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement HomeElementclick() {

		return driver.findElement(Elementclick);
	} 

	public WebElement Webclick() {

		return driver.findElement(WebTableClick);
	}

	public ArrayList<String> getDepartment() {
		ArrayList<String> alist = new ArrayList<String>();
		WebElement value = driver.findElement(columnNameDep);
		List<WebElement> columnspy = value.findElements(By.xpath("//div[@class='rt-tbody']/div/div/div[6]"));
		for (WebElement i : columnspy) {
			alist.add(i.getText());
		}
		System.out.println(alist);
		return alist;
	}

	public WebElement AddBtnClick() {

		return driver.findElement(addrecordclick);
	}

	public ArrayList<String> getAge() {
		ArrayList<String> a = new ArrayList<String>();
		List<WebElement> listAge = driver.findElements(columnNameAge);
		for (WebElement j : listAge) {
			a.add(j.getText());
		}
		return a;
	}

	public void fillForm() {

		ElementsObjects eo = new ElementsObjects(driver);
		ArrayList<String> finale = eo.getDepartment();
		ArrayList<String> age = eo.getAge();
		// String[] strArr = new String[finale.size()];
		// finale.toArray(strArr);
		// System.out.println(strArr);
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(finale.get(0));
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(finale.get(1));
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(finale.get(2) + "@gmail.com");
		driver.findElement(By.xpath("//input[@id='age']")).sendKeys(age.get(0));
		driver.findElement(By.xpath("//input[@id='salary']")).sendKeys(age.get(1));
		driver.findElement(By.xpath("//input[@id='department']")).sendKeys(age.get(2));
		driver.findElement(By.xpath("//button[@id='submit']")).click();
	
	}
	
	public WebElement HomePagelink()
	{
		return driver.findElement(homescreenLink);
	}

}
