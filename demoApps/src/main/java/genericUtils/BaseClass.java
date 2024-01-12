package genericUtils;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import genericUtils.FileUtility;

public class BaseClass {
	
	public WebDriver driver;
	public FileUtility fUtils = new FileUtility();
	
	
	@BeforeSuite
	public void bs() {
		System.out.println("Data base connection is achieved");
	}
	
	@BeforeTest
	public void bt() {
		System.out.println("This Before Test");
	}
	
	@BeforeClass
	public void bc() throws IOException {
		String browser = fUtils.fetchDataFromPropertyFile("browser");
		String url = fUtils.fetchDataFromPropertyFile("url");

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();

		}

		else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}

		else if (browser.equals("edge")) {
			driver = new EdgeDriver();

		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(url);
		System.out.println("Launch the browser browser");
		System.out.println("Navigate tom the URL");

	}
	
	@BeforeMethod
	public void bm() {
		System.out.println("Login to the application");
	}
	
	@AfterMethod
	public void am() {
		System.out.println("Logout from the application");
	}
	
	@AfterClass
	public void ac() {
		driver.quit();
		System.out.println("Close the browser");
	}
	
	@AfterTest
	public void at() {
		System.out.println("This After Test");
	}
	
	@AfterSuite
	public void as() {
		System.out.println("Close the Data Base connectivity");
	}
	
	

}
