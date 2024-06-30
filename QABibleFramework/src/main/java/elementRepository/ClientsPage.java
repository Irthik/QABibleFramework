package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtility;

public class ClientsPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtility wu = new WaitUtility();

	public ClientsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement clientSearchButton;

	@FindBy(xpath = "//a[@href='/payrollapp/client/update?id=1']")
	WebElement edit;

	@FindBy(linkText = "Create Client")
	WebElement addClient;

	@FindBy(id = "client-require_po")
	WebElement requirePO;

	@FindBy(id = "clientsearch-client_name")
	WebElement searchName;

	@FindBy(id = "clientsearch-id")
	WebElement searchId;

	@FindBy(xpath = "//a[@aria-label='Update']")
	WebElement editC;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;

	public String getBackgroundColourOfSearchButon() {
		return gu.getStylePropertyValue(clientSearchButton, "background-color");
	}

	public String getTooltipValueOfEditIcon() {
		return gu.getTooltipvalue(edit, "title");
	}

	public void clickAddClient() {
		addClient.click();
	}

	public boolean isCheckBoxSelected() {
		return gu.isCheckBoxRadioButtonSelected(requirePO);
	}

	public String checkAddressOfParticularClient() {
		return gu.dynamicTableWithNameAndAddress(driver, "Dennis");
	}

	public void enterNameAndIdToBeSearched(String name, String id) {
		searchName.sendKeys(name);
		searchId.sendKeys(id);
		clientSearchButton.click();
	}

	public void clickEditIcon() {
		Actions actions = new Actions(driver);
		actions.moveToElement(editC).perform();
		actions.doubleClick(editC).perform();

	}

	public boolean isElementPresent() {
		boolean buttonCheck = save.isDisplayed();
		return buttonCheck;

	}

}
