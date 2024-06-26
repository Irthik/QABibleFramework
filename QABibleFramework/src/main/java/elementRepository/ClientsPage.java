package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ClientsPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

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

}
