package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseClass;
import elementRepository.DashBoard;
import elementRepository.Deduction2ndPage;
import elementRepository.DeductionsPage;
import elementRepository.LoginPage;
import utilities.ExcelRead;

public class DeductionsTestCase extends BaseClass {
  @Test
  public void verifyDeductionsCanBeAdded() throws AWTException, IOException {
	  LoginPage lp=new LoginPage(driver);;
	  lp.inputUserName("carol");
	  lp.inputPassword("1q2w3e4r");
	  lp.clickLoginButton();
	  
	  DashBoard db=new DashBoard(driver);
	  db.clickDeductionsTab();
	  
	  DeductionsPage dp=new DeductionsPage(driver);
	  dp.clickAddDeduction();
	  dp.selectWorker("Dennis  Benny");
	  dp.selectType("Boots");
	  dp.enterAmount("1500");
	  dp.enterDate("21-06-2024");
	  dp.saveButton();
	  
	  Deduction2ndPage dp2=new Deduction2ndPage(driver);
	  String actualTitle=dp2.titleOfPage();
	  String expectedTitle="Create Deduction";
	  Assert.assertEquals(actualTitle, expectedTitle, "Deductions not saved!!");
  }
  
  @Test
  public void verifyBackgroundColorOfSaveButtonInDeductionsAddPage() throws IOException {
	  LoginPage lp=new LoginPage(driver);
	  lp.inputUserName(ExcelRead.getStringData(1, 0));
	  lp.inputPassword(ExcelRead.getStringData(1, 1));
	  lp.clickLoginButton();
	  
	  DashBoard db=new DashBoard(driver);
	  db.clickDeductionsTab();
	  
	  DeductionsPage dp=new DeductionsPage(driver);
	  dp.clickAddDeduction();
	  String actualColour=dp.colorOfSaveButton();
	  String expectedColour="rgba(92, 184, 92, 1)";
	  Assert.assertEquals(actualColour, expectedColour, "Background colour not as expected!");
	  
  }
}
