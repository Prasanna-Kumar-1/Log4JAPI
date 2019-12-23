package com.qa.test;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	
	
		//What is log? 			: capturing info/activities at the time of program execution. 
	
		// types of logs:
			//1. info
			//2. warn
			//3. debug
			//4. fatal
			
		//how to generate the logs? : use Apache log4j API (log4j jar)
		//How it works? : it reads log 4j configuration from log4j.properties file
		//where to create: create inside resources folder
		
		WebDriver driver;
		Logger log = Logger.getLogger(LoginTest.class.getName());
		

		@BeforeMethod
		public void setup(){
			log.info("****************************** Starting test cases execution  *****************************************");

			System.setProperty("webdriver.gecko.driver", "C:\\Work\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
			log.info("launching chrome broswer");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.get("https://freecrm.co.in/");
			log.info("entering application URL");
			log.warn("hey this is just fatal error message");
			
		}
		
		
		@Test(priority=1)
		public void freeCrmTitleTest(){
			log.info("****************************** starting freeCrmTitleTest test case *****************************************");
			String title = driver.getTitle();
			System.out.println(title);
			log.info("login page title is--->"+title);
			Assert.assertEquals("Free CRM #1 cloud software for any business large or small", title);
			
			log.info("****************************** ending freeCrmTitleTest test case *****************************************");
			
		}
		
		@Test(priority=2)
		public void freemCRMLogoTest(){
			log.info("****************************** starting freeCrmTitleTest test case *****************************************");
			
			boolean b = driver.findElement(By.xpath("//span[contains(.,'free')]")).isDisplayed();
			Assert.assertTrue(b);
			log.info("****************************** ending freeCrmTitleTest test case *****************************************");
			
		}
		
	
		@AfterMethod
		public void tearDown(){
			driver.quit();
			log.info("****************************** Browser is closed *****************************************");

			
		}
		
		
		
		
		
		
		

}
