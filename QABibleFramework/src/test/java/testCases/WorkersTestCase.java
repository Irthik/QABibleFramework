package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import constatnt.Constant;
import elementRepository.DashBoard;
import elementRepository.LoginPage;
import elementRepository.WorkersPage;

public class WorkersTestCase extends BaseClass {
	@Test
	public void verifyTextOfSearchButton() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName("carol");
		lp.inputPassword("1q2w3e4r");
		lp.clickLoginButton();

		DashBoard db = new DashBoard(driver);
		db.clickWorkersTab();

		WorkersPage wp = new WorkersPage(driver);
		String actualText = wp.getTextOfSearchButton();
		String expectedText = "Search";
		Assert.assertEquals(actualText, expectedText, "Text of search button is not matching");
	}

	@Test
	public void verifyTitleValueSelected() {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName("carol");
		lp.inputPassword("1q2w3e4r");
		lp.clickLoginButton();

		DashBoard db = new DashBoard(driver);
		db.clickWorkersTab();

		WorkersPage wp = new WorkersPage(driver);
		wp.clickAddWorker();
		String actualTitle = wp.getValueOfSelectedTitle();
		String ecpectedTitle = "Ms";
		Assert.assertEquals(actualTitle, ecpectedTitle, Constant.errorMessage);
	}
}
