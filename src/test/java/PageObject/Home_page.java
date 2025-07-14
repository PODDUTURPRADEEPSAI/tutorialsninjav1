package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_page extends Base_page  {
	
//	Extends the constructor from base page
	WebDriver driver;
	public Home_page(WebDriver driver){
		super(driver);
	}
	
	
//	Locators
	@FindBy(xpath="//span[@class='caret']") WebElement My_account;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement Register ;
	@FindBy(xpath="//a[normalize-space()='Login']")WebElement Login;
	
	
	
//	Actions
	public void Account_Creation() {
		My_account.click();
		
	}
	public void Account_Registration() {
		Register.click();
		
	}	
	public void Account_Login() {
		Login.click();
	}

}
