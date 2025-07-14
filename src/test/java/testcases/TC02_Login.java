package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.Home_page;
import PageObject.Login_test;
import PageObject.MyAccount;
import testbase.Base_class;

public class TC02_Login extends Base_class{

	@Test(groups={"Master","Regression"})
	public void setup() {
		logger.info("*************TC_02 started**********");
		try {
		Home_page hp=new Home_page(driver);
		hp.Account_Creation();
		hp.Account_Login();
		
		Login_test li=new Login_test(driver);
		li.txtEmail(p.getProperty("Email"));
		li.txtPassword(p.getProperty("Password"));
		li.Login();
		
		MyAccount acc=new MyAccount(driver);
		Boolean Account_Created=acc.Account();
		
		if(Account_Created.equals(true)) {
			acc.logout();
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		}catch(Exception e){
			logger.error("Error");
			logger.debug("Debug");
			Assert.fail();
		}
		logger.info("**************TC_02 Ended************");
		
		
		
		
	}
}
