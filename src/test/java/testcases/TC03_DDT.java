package testcases;



import org.testng.Assert;

import org.testng.annotations.Test;

import PageObject.Home_page;
import PageObject.Login_test;
import PageObject.MyAccount;
import testbase.Base_class;
import utilities.DataProviders;



public class TC03_DDT extends Base_class{

	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify(String email,String password,String Res) {
		logger.info("*************TC_03 started**********");
		try {
			logger.info("home page login");
			Home_page hp=new Home_page(driver);
			hp.Account_Creation();
			hp.Account_Login();
			logger.info("creditionals provided");
			Login_test li=new Login_test(driver);
			li.txtEmail(email);
			li.txtPassword(password);
			li.Login();
			logger.info("checking account creation");
			MyAccount acc=new MyAccount(driver);
			Boolean Account_Created=acc.Account();
			
			if(Account_Created.equals(true)) {
				Assert.assertTrue(true);
				acc.logout();
				
			}
			else {
				Assert.assertTrue(false);
			}
			if(Res.equalsIgnoreCase("Valid")) {
				if(Account_Created==true){
					acc.logout();
					Assert.assertTrue(true);
					
				}
				else {
					Assert.assertTrue(false);
				}
				
			}
			if(Res.equalsIgnoreCase("Invalid")) {
				if(Account_Created==true){
					acc.logout();
					Assert.assertTrue(false);
					
				}
				else {
					Assert.assertTrue(true);
				}
				
			}
		
		}catch(Exception e){
			logger.error("Error");
			logger.debug("Debug");
			Assert.fail();
		}
		logger.info("**************TC_03 Ended************");
	}
}
	


	
		





