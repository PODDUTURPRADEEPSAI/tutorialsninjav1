package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.Home_page;
import PageObject.Reg_page;
import testbase.Base_class;

public class TC01_Register extends Base_class {
	
	
	@Test(groups={"Master","Sanity"})
	public void Register(){
		logger.info("********TC01_Register Starting************");
		try {
			Home_page hp=new Home_page(driver);
			hp.Account_Creation();
			hp.Account_Registration();
			logger.info("Account information");
			
			Reg_page register =new Reg_page(driver);
			register.Txtfirstname(randomAlphabit().toUpperCase());
			register.TxtLastname(randomAlphabit().toUpperCase());
			register.TxtEmail(randomAlphabit()+"@gmail.com");
			register.Txttelephone(randomNumeric());
			register.TxtPassword("xyz1234");
			register.TxtPasswordconf("xyz1234");
			
			register.BtnNewsletter();
			register.CheckboxAgree();
			
			register.Register();
			System.out.println(register.msg());
			if(register.msg().equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
				logger.info("Account Created Successfully");
			}
			else {
				logger.debug("Debug");
				logger.error("errors");
				Assert.assertTrue(false);
				}
			}catch(Exception e){
				Assert.fail();
				}
		logger.info("********TC01_Register Ending************");
		}
	}

