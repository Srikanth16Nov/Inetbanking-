package com.inet.testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inet.pageobjects.LoginPage;
import com.inet.utilities.XLUtils;

import junit.framework.Assert;

public class TC2_LoginTestTDD extends BaseLine{
	
	
	@Test(dataProvider="loginData")
	public void loginTDD(String user,String pwd) throws IOException {
		LoginPage lp = new LoginPage(driver);
		
		
		lp.enterUserName(user);
		logger.info("Username Entered");
		lp.enterUserPassword(pwd);
		logger.info("Password Entered");
		lp.clickLoginButton();
		
		if(alertStatus()==true) {
			captureScreen(driver, "loginTestTDD");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("Login Failed");
		}else if(alertStatus()==false) {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogoutButton();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	public boolean alertStatus(){
		
		try {
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException e){
			return false;
		}
		
	}
	
	@DataProvider(name="loginData")
	String[][] loginDataProvider() throws IOException{
		
		String path=System.getProperty("user.dir")+"/src/test/java/com/inet/testdata/LoginData.xlsx";
		int rowCount = XLUtils.getRowCount(path, "sheet1");
		int colCount = XLUtils.getCellCount(path, "sheet1", 1);
		
		String logindatasets[][] = new String[rowCount][colCount];
		
		for(int i=1;i<rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				logindatasets[i-1][j]=XLUtils.getCellData(path, "sheet1", i, j);
			}
		}
		return logindatasets;
	}
}
