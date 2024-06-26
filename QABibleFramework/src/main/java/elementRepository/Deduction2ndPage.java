package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Deduction2ndPage {
	WebDriver driver;
	public Deduction2ndPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String titleOfPage() {
		String title=driver.getTitle();
		return title;
	}

}
