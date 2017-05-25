/**
 * 
 */
package net.sourceforge.cruisecontrol.sampleproject.connectfour.selenium;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * @author sreenivasrao.m
 *
 */
public class DemoSelenium {
	
	private WebDriver driver;
	
	@Test				
	public void testEasy() {	
		driver.get("https://www.google.com/");  
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Free Selenium Tutorials")); 		
	}	
	@BeforeTest
	public void beforeTest() {	
	    driver = new FirefoxDriver();  
	}		
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
