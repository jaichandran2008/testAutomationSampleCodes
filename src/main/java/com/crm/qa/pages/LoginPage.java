package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name ="password")
		WebElement password;
		
		@FindBy(xpath=".//*[@id='loginForm']/div/div/input")
		WebElement loginBtn;
		
		@FindBy(xpath="//button[contains(text(), 'Sign Up')]")
		WebElement signUpBtn;
		
		@FindBy(xpath="//img[contains(@class,'img-responsive')]")
		WebElement crmLogo;
		
		//Initializing Page Objects
		public LoginPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return crmLogo.isDisplayed();
		}
		
		public HomePage login(String un, String pwd) throws InterruptedException{
			username.sendKeys(un);
			password.sendKeys(pwd);
			Thread.sleep(1000);
			loginBtn.click();
			
			return new HomePage();
		}
}
