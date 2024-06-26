package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	public String getStylePropertyValue(WebElement element, String propertyType) {
		String propertyValue = element.getCssValue(propertyType);
		return propertyValue;
	}

	public boolean isCheckBoxRadioButtonSelected(WebElement element) {
		element.click();
		boolean check = element.isSelected();
		return check;
	}

	public String getTooltipvalue(WebElement element, String attribute) {
		String tooltip = element.getAttribute(attribute);
		return tooltip;
	}

	public String getSelectedOptionFromDropDown(WebElement element, String text) {
		element.click();
		Select select = new Select(element);
		select.selectByVisibleText(text);
		WebElement selectedValue = select.getFirstSelectedOption();
		String optionText = selectedValue.getText();
		return optionText;

	}

	public boolean isElementPresent(WebElement element) {
		boolean check = element.isDisplayed();
		return check;
	}

	public void moveMousePointerAndClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element);
		action.click().perform();
	}

	public void addfile(String path) throws AWTException {
		StringSelection ss = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(1000);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
	public void getSelectedOptionFromDropDownSearch(WebElement element1, WebElement element2, String text) {
		element1.click();
		element2.click();
		element2.sendKeys(text);
		
		}
	
	public void getOnlySelectedOptionFromDropDown(WebElement element, String text) {
		element.click();
		Select select = new Select(element);
		select.selectByVisibleText(text);
		
		}
	
	public String dynamicTableWithNameAndAddress(WebDriver driver, String name) {
		String locator=null;
		
		List<WebElement> column=driver.findElements(By.xpath("//table[@class='table table-striped table-bordered']//tbody//tr//td[2]"));
		for(int i=0;i<column.size();i++)
		{
			if(column.get(i).getText().equals(name))
			{
				locator="//table[@class='table table-striped table-bordered']//tbody//tr["+(i+1)+"]//td[4]";
				break;
			}
		}
		
		WebElement row=driver.findElement(By.xpath(locator));
		String text=row.getText();
		System.out.println(text);
		return text;

	}
	

}
