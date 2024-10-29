package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test
	public void verify_Login() {

		logger.info(" ****************** Starting Test ******************* ");

		try {

			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmail(prop.getProperty("email"));
			lp.setPassword(prop.getProperty("password"));
			lp.clkLogin();

			MyAccountPage mcp = new MyAccountPage(driver);
			boolean targetPage = mcp.isMyAccountPageExists();

			Assert.assertEquals(targetPage, true, "Login failed");

		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info(" ********************* Test Finished ***************** ");
	}

}
