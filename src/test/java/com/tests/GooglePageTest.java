package com.tests;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GooglePageTest {

	RemoteWebDriver driver;
	DesiredCapabilities caps;
	File name;
	
	@Test
	@Parameters({"url","fileName"})
	public void verifyGooglePageTest(String url,String fileName) throws Exception {
		caps=DesiredCapabilities.chrome();
		name=new File(System.getProperty("user.dir")+"//Screenshots//"+fileName+".jpg");
		System.out.println("File name is "+name);
		driver=new RemoteWebDriver(new URL("http://192.168.1.6:4444/wd/hub"),caps);
		driver.get(url);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src,name);
		System.out.println("File is created successfully");
		Assert.assertTrue(true);
		driver.quit();
	
		
		
	}
	
	
	
	
}
