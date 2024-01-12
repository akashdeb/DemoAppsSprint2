package webElement.textbox;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import POM.LoginPage;
import POM.RegisterPage;
import genericUtils.BaseClass;
import genericUtils.FileUtility;

public class ToRegisterUserAndLoginTest extends BaseClass {

	@Test(priority = 1)
	public void toRegisterUserTest() throws EncryptedDocumentException, IOException, InterruptedException {

		String name = fUtils.fetchStringDataFromExcelSheet("Register", 1, 0);
		String email = fUtils.fetchStringDataFromExcelSheet("Register", 1, 1);
		String password = fUtils.fetchStringDataFromExcelSheet("Register", 1, 2);

		RegisterPage register = new RegisterPage(driver);
		LoginPage login = new LoginPage(driver);

		register.registerUser(name, email, password);
		Thread.sleep(2000);

		Assert.assertTrue(login.verifyRegisterSuccesfullMsg());
		System.out.println("Pass: the user has Registered");


	}

	@Test(priority = 2)
	public void loginUser() throws EncryptedDocumentException, IOException, InterruptedException {

		String email = fUtils.fetchStringDataFromExcelSheet("Register", 1, 1);
		String password = fUtils.fetchStringDataFromExcelSheet("Register", 1, 2);

		LoginPage login = new LoginPage(driver);

		login.loginUser(email, password);
		
		Thread.sleep(2000);
		Assert.assertTrue(login.verifySignInSuccesfullMsg());
		System.out.println("Pass: the user has Signed in");

	}

}