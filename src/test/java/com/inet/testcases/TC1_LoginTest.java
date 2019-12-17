package com.inet.testcases;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inet.pageobjects.LoginPage;

public class TC1_LoginTest extends BaseLine{
	
	@Test
	public void loginTest() throws IOException {
		//driver.get(url);
		//logger.info("URL Launched");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserName(username);
		logger.info("Username Entered");
		lp.enterUserPassword(password);
		logger.info("Password Entered");
		lp.clickLoginButton();
		logger.info("Clicked the loggin button");
		String actTitle="Guru99 Bank Manager HomePage";
		if(driver.getTitle().contains(actTitle)) {
			Assert.assertTrue(true);
			logger.info("Entered into home page");
		}else {
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
		}
	}
}
