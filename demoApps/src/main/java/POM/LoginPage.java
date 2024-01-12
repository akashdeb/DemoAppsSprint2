package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(id = "email")
	private WebElement emailTextField;

	@FindBy(id = "password")
	private WebElement passwordTextField;

	@FindBy(tagName = "button")
	private WebElement loginButton;

	@FindBy(xpath = "//div[text()='Registered successfully']")
	private WebElement registeredSuccesfullMsg;

	@FindBy(xpath = "//div[text()='Signin successful']")
	private WebElement signinSuccessfulMsg;

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getRegisteredSuccesfullMsg() {
		return registeredSuccesfullMsg;
	}

	public WebElement getSigninSuccessfulMsg() {
		return signinSuccessfulMsg;
	}

	public void loginUser(String email, String password) {

		emailTextField.sendKeys(email);
		passwordTextField.sendKeys(password);
		loginButton.click();

	}

	public boolean verifyRegisterSuccesfullMsg() {

		return registeredSuccesfullMsg.isDisplayed();
	}

	public boolean verifySignInSuccesfullMsg() {

		return signinSuccessfulMsg.isDisplayed();
	}
	
	public boolean verifyDynamicRegistration(String name) {
		
		return driver.findElement(By.xpath("//div[text()='"+name+" Registered successfully']")).isDisplayed();
		
	}
	
	

}
