package elementRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelRead;
import utilities.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	ExcelRead ex=new ExcelRead();
	GeneralUtilities gu = new GeneralUtilities();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "loginform-username")
	WebElement userName;

	@FindBy(id = "loginform-password")
	WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//h1[text()='Login']")
	WebElement icon;

	public boolean isIconPresent() {
		boolean checkIcon = gu.isElementPresent(icon);
		return checkIcon;
	}

	public void inputUserName(String uName) throws IOException {
		userName.sendKeys(uName);
	}

	public void inputPassword(String uPassword) throws IOException {
		password.sendKeys(uPassword);
	}

	public void clickLoginButton() {
		loginButton.click();
	}
}