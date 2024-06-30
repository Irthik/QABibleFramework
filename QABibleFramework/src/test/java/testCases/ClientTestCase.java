package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import elementRepository.ClientsPage;
import elementRepository.DashBoard;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class ClientTestCase extends BaseClass {
	@Test(groups = "Critical")
	public void verifyBackGroundColourOfSearchButton() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName("carol");
		lp.inputPassword("1q2w3e4r");
		lp.clickLoginButton();

		DashBoard db = new DashBoard(driver);
		db.clickClientsTab();

		ClientsPage cp = new ClientsPage(driver);
		String actualColour = cp.getBackgroundColourOfSearchButon();
		String expectedColour = "rgba(51, 122, 183, 1)";
		Assert.assertEquals(actualColour, expectedColour, "Background colour is not same!");
	}

	@Test
	public void verifytooltipValueOfEditIcon() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName("carol");
		lp.inputPassword("1q2w3e4r");
		lp.clickLoginButton();

		DashBoard db = new DashBoard(driver);
		db.clickClientsTab();

		ClientsPage cp = new ClientsPage(driver);
		String actualTooltip = cp.getTooltipValueOfEditIcon();
		String expectedTooltip = "Update";
		Assert.assertEquals(actualTooltip, expectedTooltip, "Tooltip is not matching !!");
	}

	@Test(groups = "Critical")
	public void verifyCheckboxIsSelected() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName("carol");
		lp.inputPassword("1q2w3e4r");
		lp.clickLoginButton();

		DashBoard db = new DashBoard(driver);
		db.clickClientsTab();

		ClientsPage cp = new ClientsPage(driver);
		cp.clickAddClient();
		boolean actualCheck = cp.isCheckBoxSelected();
		boolean expectedCheck = true;
		Assert.assertEquals(actualCheck, expectedCheck, "Checkbox is not selected");
	}

	@Test
	public void getAddressOfClient() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName("carol");
		lp.inputPassword("1q2w3e4r");
		lp.clickLoginButton();

		DashBoard db = new DashBoard(driver);
		db.clickClientsTab();

		ClientsPage cp = new ClientsPage(driver);
		String actualAddress = cp.checkAddressOfParticularClient();
		String expectedAddress = ("Innhams Wood\n" + "Crowborough\n" + "East Sussex");
		Assert.assertEquals(actualAddress, expectedAddress, "Address is not matching");
	}

	@Test(groups = "High")
	public void getClientByNameAndId() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(ExcelRead.getStringData(1, 0));
		lp.inputPassword(ExcelRead.getStringData(1, 1));
		lp.clickLoginButton();

		DashBoard db = new DashBoard(driver);
		db.clickClientsTab();

		ClientsPage cp = new ClientsPage(driver);
		cp.enterNameAndIdToBeSearched("Sam", "3");
		cp.clickEditIcon();
		boolean actualResult = cp.isElementPresent();
		boolean expectedResult = true;
		Assert.assertEquals(actualResult, expectedResult, "Client not found!");
	}
}
