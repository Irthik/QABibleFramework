package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.CaptureScreenshotforFailedTestCases;

public class BaseClass {
	public WebDriver driver;

	public static Properties prop;// prop is the ref variable of class Properties

	public static void readFromPropertiesFile() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//Properties//Config.properties");
		prop.load(ip);
	}

	@BeforeMethod(alwaysRun = true)
	@Parameters("Browser")
	public void beforeMethod(String b) throws IOException {
		readFromPropertiesFile();
		
		if(b.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(b.equals("Edge")) {
			driver= new EdgeDriver();
		}
		driver.get(prop.getProperty("baseURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult itestResult) throws IOException {
		if (itestResult.getStatus() == ITestResult.FAILURE) {
			CaptureScreenshotforFailedTestCases ss = new CaptureScreenshotforFailedTestCases();
			ss.captureScreenShotForFailedTestcase(driver, itestResult.getName());
		}
		driver.close();
	}

}
