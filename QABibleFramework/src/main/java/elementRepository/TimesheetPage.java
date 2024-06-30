package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class TimesheetPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public TimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Create Timesheet")
	WebElement createTimesheet;

	@FindBy(id = "file-logo")
	WebElement timesheetFile;

	@FindBy(xpath = "//button[@title='Upload selected files']")
	WebElement uploadButton;

	@FindBy(id = "timesheet-branch_id")
	WebElement branch;

	@FindBy(xpath = "//button[@value='playslip']")
	WebElement generatePlaySlip;

	public void clickCreateTimesheet() {
		createTimesheet.click();
	}

	public void addFile(String path) throws AWTException {
		gu.moveMousePointerAndClick(driver, timesheetFile);
		gu.addfile(path);
	}

	public void clickUpload() {
		uploadButton.click();
	}

	public boolean isElementPresent() {
		boolean check = gu.isElementPresent(branch);
		return check;
	}

	public void clickgeneratePlaySlip() {
		generatePlaySlip.click();
	}

	public void actionsOnAlert() {
		wu.waitForAlertToBePresent(driver);
		gu.acceptOnAlertBox(driver);
	}

	public String getMessageOnAlert() {
		wu.waitForAlertToBePresent(driver);
		String message=gu.messageOnAlertBox(driver);
		return message;
	}
	public void accept() {
		gu.acceptOnAlertBox(driver);

	}

}
