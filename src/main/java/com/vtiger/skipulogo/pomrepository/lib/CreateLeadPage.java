package com.vtiger.skipulogo.pomrepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeadPage 
{
	public CreateLeadPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "company")
	private WebElement companyEdt;
	
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	
	@FindBy(name = "button")
	private WebElement saveBtn;
	
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCompanyEdt() {
		return companyEdt;
	}

	public WebElement getLastnameEdt() {
		return lastnameEdt;
	}
	
	public void createLead(String lastname,String company)
	{
		getLastnameEdt().sendKeys(lastname);
		getCompanyEdt().sendKeys(company);
		getSaveBtn().click();
		
	}
	
}
