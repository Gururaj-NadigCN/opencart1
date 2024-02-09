package testClass;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistration;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups= {"regression","master"})
	public void accountRegister() {
		
		logger.info("**** TC_001_AccountRegistrationTest ****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Click on MyAccount");
		hp.clickRegister();
		logger.info("Click on Registration");
		
		logger.info("Entering the registration details");
		AccountRegistration acc_register=new AccountRegistration(driver);
		acc_register.setFirstName(randomString().toUpperCase());
		acc_register.setLastName(randomString().toUpperCase());
		acc_register.setEmail(randomString()+"@gmail.com");
		acc_register.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		acc_register.setPassword(password);
		acc_register.confirmPwd(password);
		
		acc_register.clickAgree();
		acc_register.buttonContinue();
		logger.info("Click on Continue Button");
		
		String cnfmsg=acc_register.confirmationMessage();
		Assert.assertEquals(cnfmsg, "Your Account Has Been Created!");
		logger.info("Validating the Message");
		}catch(Exception e) {
			logger.error("Test Failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
		logger.debug("application logs end...");
		logger.info("**** TC_001_AccountRegistrationTest ****");
	}
	
	
	
	

}
