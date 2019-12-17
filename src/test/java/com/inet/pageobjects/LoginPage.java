package com.inet.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="uid") WebElement userName;
	@FindBy(name="password") WebElement userPassword;
	@FindBy(name="btnLogin") WebElement loginButton;
	@FindBy(linkText="Log out") WebElement logoutLink;
	
	public void enterUserName(String uname) {
		userName.sendKeys(uname);
	}
	
	public void enterUserPassword(String pwd) {
		userPassword.sendKeys(pwd);
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickLogoutButton() {
		logoutLink.click();
	}

}
