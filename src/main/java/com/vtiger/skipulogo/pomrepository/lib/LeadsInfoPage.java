package com.vtiger.skipulogo.pomrepository.lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsInfoPage 
{
	public LeadsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
		
	public WebElement getConvertLeadLnk() {
		return convertLeadLnk;
	}

	@FindBy(linkText = "Convert Lead")
	private WebElement convertLeadLnk;
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement successMsg;

	public WebElement getSuccessMsg() {
		return successMsg;
	}

	
	

}
