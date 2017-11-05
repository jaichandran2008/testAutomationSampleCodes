package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	WebElement contactsLabel;

	@FindBy(xpath="//a[text()='a a']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")
	WebElement checkbox;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement companyname;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();;
	}
	
	public void createNewContact(String title, String ftName, String ltName, String company){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstname.sendKeys(ftName);
		lastname.sendKeys(ltName);
		companyname.sendKeys(company);
		saveBtn.click();
	}
}
