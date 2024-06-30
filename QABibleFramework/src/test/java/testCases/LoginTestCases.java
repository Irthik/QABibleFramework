package testCases;

import org.testng.annotations.Test;

import Base.BaseClass;
import elementRepository.DashBoard;
import elementRepository.LoginPage;
import utilities.ExcelRead;

import java.io.IOException;

import org.testng.Assert;

public class LoginTestCases extends BaseClass {

	@Test
	public void verifyLoginIsWorking() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(ExcelRead.getStringData(1, 0));
		lp.inputPassword(ExcelRead.getStringData(1, 1));
		lp.clickLoginButton();

		DashBoard db = new DashBoard(driver);
		String actual = db.getUserText();
		String expected = "CAROL THOMAS";
		Assert.assertEquals(actual, expected, "Username is not same");

	}

	@Test(groups = "Critical", retryAnalyzer = retry.Retry.class)
	public void verifyLogoutIsWorking() throws IOException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName(ExcelRead.getStringData(1, 0));
		lp.inputPassword(ExcelRead.getStringData(1, 1));
		//lp.inputUserName("carol");
		//lp.inputPassword("1q2w3e4r");
		lp.clickLoginButton();

		DashBoard db = new DashBoard(driver);
		db.clickLogout();

		boolean expected = lp.isIconPresent();
		boolean actual = true;
		Assert.assertEquals(actual, expected, "Logout page is not displayed");

	}

}
