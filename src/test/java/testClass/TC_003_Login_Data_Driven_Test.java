package testClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginAccount;
import pageObjects.MyAccount;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_Login_Data_Driven_Test extends BaseClass{
	
	@Test(dataProvider = "loginData",dataProviderClass =  DataProviders.class)
	public void loginTest(String email,String password,String exp) {
		logger.info("**** Started TC_003_Login_Data_Driven_Test ****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginAccount lp=new LoginAccount(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLoginbutton();
		
		MyAccount macp=new MyAccount(driver);
		boolean targetpage=macp.isMyAccountPageDisplayed();
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetpage==true) {
				macp.clickLogout();
				Assert.assertTrue(true);
				
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetpage==true) {
				macp.clickLogout();
				Assert.assertTrue(false);
			}else {
				Assert.assertTrue(true);
			}
		}
	}catch(Exception e) {
		Assert.fail("An exception occured"+e.getMessage());
	}
		logger.info("**** Finshed TC_003_Login_Data_Driven_Test ****");
	}
	
}
