package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class WorkersPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public WorkersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement search;

	@FindBy(linkText = "Create Worker")
	WebElement addWorker;

	@FindBy(id = "worker-title")
	WebElement title;

	public String getTextOfSearchButton() {
		return gu.getElementText(search);
	}

	public void clickAddWorker() {
		addWorker.click();
	}

	public String getValueOfSelectedTitle() {
		return gu.getSelectedOptionFromDropDown(title, "Mr");
	}

}
