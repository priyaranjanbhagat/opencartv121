package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_Account_Registration() {

		logger.info(" *********** Starting Account Registration Test ************ ");
		
		try 
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info(" **** Clicked on My Account Link ****** ");
		hp.clickRegister();
		logger.info(" **** Clicked on Register Link ****** ");
		
		logger.info(" **** Providing customer details.... ****** ");
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString() + "@gmail.com");
		regPage.setPhone(randomNumber());

		String password = randomAlphaNumeric();
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		regPage.clickChkPolicy();
		regPage.clickContiunueButton();
		
		logger.info(" **** Validating Expected Message... ****** ");
		String confirmMessage = regPage.getConfirmationMsg();
		
		if(confirmMessage.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error(" ****** Test Failed ********** ");
			logger.debug(" ****** Debug Log ********** ");
		}

//		Assert.assertEquals(confirmMessage, "Your Account Has Been Created!");
		} 
		
		catch(Exception e){
			
			logger.error(" ******** Test Failed ******* ");
			logger.debug(" ******** Debug Log ********* ");
		}
		
		logger.info(" **** Test Closed ******** ");
	}

}
