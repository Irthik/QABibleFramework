package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DashBoard {
	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	public DashBoard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href='#']")
	WebElement user;

	@FindBy(linkText = "Workers")
	WebElement workersTab;

	@FindBy(linkText = "Clients")
	WebElement clientsTab;

	@FindBy(linkText = "TimeSheet")
	WebElement timeSheet;
	
	@FindBy(linkText="Deduction")
	WebElement deductionTab;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logout;

	public String getUserText() {
		return gu.getElementText(user);
	}

	public void clickWorkersTab() {
		workersTab.click();
	}

	public void clickClientsTab() {
		clientsTab.click();
	}

	public void clickLogout() {
		user.click();
		logout.click();
	}

	public void clickTimeSheet() {
		timeSheet.click();
	}
	
	public void clickDeductionsTab() {
		deductionTab.click();
	}
}
