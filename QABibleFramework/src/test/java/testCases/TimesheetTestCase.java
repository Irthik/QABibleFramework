package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import elementRepository.DashBoard;
import elementRepository.LoginPage;
import elementRepository.TimesheetPage;

public class TimesheetTestCase extends BaseClass {
	@Test
	public void verifyFileUploadInTimeSheetCreation() throws AWTException {
		LoginPage lp = new LoginPage(driver);
		lp.inputUserName("carol");
		lp.inputPassword("1q2w3e4r");
		lp.clickLoginButton();

		DashBoard db = new DashBoard(driver);
		db.clickTimeSheet();

		TimesheetPage ts = new TimesheetPage(driver);
		ts.clickCreateTimesheet();
		ts.addFile("C:\\Users\\1\\Pictures\\1gh.jpg");
		ts.clickUpload();
		boolean actual = ts.isElementPresent();
		boolean expected = true;
		Assert.assertEquals(actual, expected, "File is not uploaded");
	}
}
