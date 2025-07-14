package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_test extends Base_page{
	
	public Login_test(WebDriver driver){
		
		super(driver);
		
	}
	
	
	@FindBy(xpath="//input[@id='input-email']")WebElement TxtEmail;
	@FindBy(xpath="//input[@id='input-password']")WebElement TxtPassword;
	@FindBy(xpath="//input[@value='Login']")WebElement ClickLogin;
	
	public void txtEmail(String Email) {
		TxtEmail.sendKeys(Email);
	}
	
	public void txtPassword(String Password) {
		TxtPassword.sendKeys(Password);
	}
	public void Login() {
		ClickLogin.click();
	}

}
