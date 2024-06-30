package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public void waitForPresenceOfElementLocated(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
	}
	
	public void waitForAlertToBePresent(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void waitForTextToBePresent(WebDriver driver, WebElement element, String textName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10000));
		wait.until(ExpectedConditions.textToBePresentInElement(element, textName));
	}

}
