package testngexamples;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void openBrowser(String browser) throws InterruptedException{
		
		if(browser.equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver", "Utils\\chromedriver.exe"); //Amended the driver path
			driver = new ChromeDriver();
			
		}else if(browser.equalsIgnoreCase("Firefox")){
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("Internet Explorer")){
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
		Thread.sleep(10000);
	}
	
	@Test
	public void verifyTitle(){
		boolean expectedResult = true;
		boolean actualResult = driver.getPageSource().contains("Mercury Tours");
		File fileName = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(fileName, new File("C:\\Users\\m1022011\\Desktop\\Selenium\\screenshots\\"+(new Random().nextInt())+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(expectedResult, actualResult);
	}
	@Test
	public void verifyTest1(){
		String expectedTitle = "Welcome: Mercury Tours";
		String actulaTitle = driver.getTitle();
		Assert.assertEquals(actulaTitle, expectedTitle);
		
	}
	@AfterTest
	public void closeBrowser(){
		driver.close();
	}
}
