package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Page_Object_Factory.Object_Factory_FormsObjects;
import resources.Base;

public class FormsObject extends Base
{
	Object_Factory_FormsObjects FO = new Object_Factory_FormsObjects();
	public static Logger log = LogManager.getLogger(FormsObject.class.getName());
	
	
	public void HomeScreenClick()
	{
		
		//driver.manage().window().maximize();
		FO.HomePagelink().click();
		log.info("HomeScreen clicked");
	}
	
	public void HomeFormClick()
	{
		
		FO.HomeFormclick().click();
		log.info("Form clicked and navigated to the next screen");
	}
	
	public void FormLinkClick()
	{
		
		FO.FormClick().click();
		log.info("Clicked on form button on home screen");
	}
	
	public void PracticeFormLinkClick()
	{
		WebDriverWait ww = new WebDriverWait(driver, 15);
		ww.until(ExpectedConditions.elementToBeClickable(FO.PracticeFormClick()));
		FO.PracticeFormClick().click();
		log.info("Clicked on practice form");
	}
	
	public ArrayList<String> getData(String FieldNameValue) throws IOException {
		ArrayList<String> al = new ArrayList<String>();
		FileInputStream FIS = new FileInputStream("C:\\Users\\Admin\\Desktop\\DataDriven.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(FIS);
		int Sheets = wb.getNumberOfSheets();
		for (int i = 0; i < Sheets; i++) {
			if (wb.getSheetName(i).equalsIgnoreCase("testData")) {
				XSSFSheet workingSheet = wb.getSheetAt(i);
				Iterator<Row> row = workingSheet.iterator();
				Row firstrow = row.next();
				Iterator<Cell> ci = firstrow.cellIterator();
				int k = 0;
				int columnNumber = 0;
				while (ci.hasNext()) {
					Cell column = ci.next();
					if (column.getStringCellValue().equalsIgnoreCase("FieldName")) {
						k = columnNumber;
					}
					k++;
				}

				while (row.hasNext()) {
					Row rows = row.next();
					if (rows.getCell(columnNumber).getStringCellValue().equalsIgnoreCase(FieldNameValue)) {
						Iterator<Cell> NameField = rows.cellIterator();
						while (NameField.hasNext()) {
							al.add(NameField.next().getStringCellValue());
						}
						System.out.println(al);
					}

				}
			}

		}
		return al;

	}

	public void setFieldValues() throws IOException
	{
		
		FormsObject FO1 = new FormsObject();
		ArrayList<String> values = FO1.getData("Name");
		FO.FirstNameTextBox().sendKeys(values.get(1));
		log.info("Added First Name");
		FO.LastNameTextBox().sendKeys(values.get(2));
		log.info("Added Last Name");
		ArrayList<String> values1 = FO1.getData("Email");
		FO.EmailTextBox().sendKeys(values1.get(1));
		log.info("Added Email");
		FO.radioBtn().click();
		log.info("Gender Selected");
		boolean Selected = FO.RadioSelectCheck().isSelected();
		log.info(Selected);
		ArrayList<String> values2 = FO1.getData("Mobile");
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
		ArrayList<String> values3 = FO1.getData("Subjects");
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
		ArrayList<String> values4 = FO1.getData("Address");
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

}
