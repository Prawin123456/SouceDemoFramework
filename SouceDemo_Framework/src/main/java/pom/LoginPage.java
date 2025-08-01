package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement usertextfield;

	public WebElement getUsertextfield() {
		return usertextfield;
	}

	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordtextfield;

	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}
	
	@FindBy(xpath = "//input[@id='login-button']")
	private WebElement loginbutton;

	public WebElement getLoginbutton() {
		return loginbutton;
	}
	
}
