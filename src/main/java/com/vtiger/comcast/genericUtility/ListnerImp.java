package com.vtiger.comcast.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImp implements ITestListener
{
	public void onTestFailure(ITestResult result) 
	{
		String TestName=result.getMethod().getMethodName();
		EventFiringWebDriver evntFiring =new EventFiringWebDriver(BaseClass.sDriver);
		File srcFile= evntFiring.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File("./screenshots/"+TestName+".png"));
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
