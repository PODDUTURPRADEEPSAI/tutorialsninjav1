package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends Base_page {
	
	public MyAccount(WebDriver driver){
		
		super(driver);
		
		
	}
	
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")WebElement Myaccount;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")WebElement Logout;
	
	public Boolean  Account() {
		return Myaccount.isDisplayed();
	}
	
	public void logout() {
		Logout.click();
	}
	
	
}
