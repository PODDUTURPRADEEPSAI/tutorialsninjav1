package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Reg_page extends Base_page {
	
	
//	Constructor
	WebDriver driver;
	public Reg_page(WebDriver driver){
		
		super(driver);
		
	}
	
//	Locators
	@FindBy(xpath="//input[@id='input-firstname']")WebElement txtFirstname;
	@FindBy(xpath="//input[@id='input-lastname']")WebElement txtLastname;
	@FindBy(xpath="//input[@id='input-email']")WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']")WebElement txtTelephone;
	@FindBy(xpath="//input[@id='input-password']")WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']")WebElement txtPassword1;
	@FindBy(xpath="//label[normalize-space()='Yes']")WebElement btnNewsletter;
	@FindBy(xpath="//input[@name='agree']")WebElement CheckAgree;
	@FindBy(xpath="//input[@value='Continue']")WebElement cliContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")WebElement compare; 
//	Actions
	
	public void Txtfirstname(String fname) {
		txtFirstname.sendKeys(fname);
	}
	public void TxtLastname(String lname) {
		txtLastname.sendKeys(lname);
	}
	public void TxtEmail(String mail) {
		txtEmail.sendKeys(mail);
	}
	public void Txttelephone(String telephone) {
		txtTelephone.sendKeys(telephone);
	}
	public void TxtPassword(String Password) {
		txtPassword.sendKeys(Password);
	}
	public void TxtPasswordconf(String Passwordconf) {
		txtPassword1.sendKeys(Passwordconf);
	}
	public void BtnNewsletter() {
		btnNewsletter.click();
	}
	public void CheckboxAgree() {
		CheckAgree.click();
	}
	public void Register() {
		cliContinue.click();
	}
	public String msg() {
		return compare.getText();
	}
	
}



