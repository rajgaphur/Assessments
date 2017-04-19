package testngexamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AjaxExample {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		driver = new ChromeDriver(options );
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to("http://demo.guru99.com/selenium/ajax.html");
	}
  @Test
  public void callAjaxMethod() {
	  By container = By.cssSelector(".container");
	  wait = new WebDriverWait(driver, 5);
	  wait.until(ExpectedConditions.presenceOfElementLocated(container));
	  
   	//Get the text before performing an ajax call
	  WebElement noTextElement = driver.findElement(By.className("radiobutton"));
	  String textBeforeAjaxCall = noTextElement.getText().trim();
	  
	  
	  driver.findElement(By.id("yes")).click();	  
	  driver.findElement(By.id("buttoncheck")).click();
	  
	  //Get the text after ajax call
	  WebElement textElement = driver.findElement(By.className("radiobutton"));
	  wait.until(ExpectedConditions.visibilityOf(textElement));
	  String textAfterAjaxCall = textElement.getText().trim();
	  
	  //Verify both texts before ajax call and after ajax call text
	  Assert.assertNotEquals(textBeforeAjaxCall, textAfterAjaxCall);
	  System.out.println("Ajax call performed");	  
	  
	//Verify expected text with text updated after ajax call
	  String expectedText = "Radio button is checked and it's value is Yes";
	  Assert.assertEquals(expectedText, textAfterAjaxCall);
	  
	  
  }
  @AfterClass
  public void tearDown(){
	  driver.close();
  }
}
