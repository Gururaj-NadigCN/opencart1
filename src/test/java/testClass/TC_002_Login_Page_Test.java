package testClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginAccount;
import pageObjects.MyAccount;
import testBase.BaseClass;

public class TC_002_Login_Page_Test extends BaseClass {
	
	@Test(groups= {"sanity","master"})
	public void loginTest() {
		logger.info("**** Started TC_002_Login_Page_Test ****");
		logger.debug("Debug Logs");
		
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my account in home page");
		hp.clickLogin();
		logger.info("clicked on login in home page");
		
		//login
		LoginAccount lp=new LoginAccount(driver);
		lp.setEmail(p.getProperty("email"));
		logger.info("entering the email");
		lp.setPassword(p.getProperty("password"));
		logger.info("entering the password");
		lp.clickLoginbutton();
		
		//myaccount
		MyAccount macp=new MyAccount(driver);
		boolean myAccountHeading=macp.isMyAccountPageDisplayed();
		Assert.assertEquals(myAccountHeading, true,"Test Passed");
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished TC_002_Login_Page_Test ****");
		logger.debug("Debug Logs Ended");
	}

}
