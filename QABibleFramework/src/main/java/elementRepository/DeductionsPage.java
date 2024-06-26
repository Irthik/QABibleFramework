package elementRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;

public class DeductionsPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public DeductionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Add Deduction")
	WebElement addDeduction;

	@FindBy(xpath="//span[@id='select2-deduction-worker_id-container']")
	WebElement worker;
	
	@FindBy(xpath="//input[@tabindex='0']")
	WebElement searchBox;

	@FindBy(xpath="//select[@name='Deduction[type]']")
	WebElement type;

	@FindBy(id = "deduction-amount")
	WebElement amount;

	@FindBy(id = "deduction-effective_from")
	WebElement date;
	
	@FindBy(xpath="//i[@class='glyphicon glyphicon-remove']")
	WebElement clear;

	@FindBy(xpath="//button[@type='submit']")
	WebElement save;

	public void clickAddDeduction() {
		addDeduction.click();
	}

	public void selectWorker(String name) throws AWTException {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofMillis(30000));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("select2-deduction-worker_id-container")));
		gu.getSelectedOptionFromDropDownSearch(worker,searchBox, name);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void selectType(String item) {
		gu.getOnlySelectedOptionFromDropDown(type, item);
	}

	public void enterAmount(String price) {
		amount.sendKeys(price);
	}

	public void enterDate(String dateis) {
		clear.click();
		date.sendKeys(dateis);
		
	}

	public void saveButton() {
		save.click();
	}

}
