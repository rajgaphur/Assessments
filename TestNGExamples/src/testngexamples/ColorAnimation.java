package testngexamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ColorAnimation {
  
	
		
		WebDriver driver;
	  @BeforeClass
	  public void setUp() throws InterruptedException {
			 
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\m1022011\\Desktop\\Selenium\\drivers\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		  driver.get("https://jqueryui.com/widget/");
		 // Thread.sleep(5000);
		    	  
	  }
	  @Test
	  public void colorAnimationTest(){
		  
		  driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		  
		//  String strmsg = driver.findElement(By.xpath("//*[@id='effect']/p")).getText();
		  
		//  System.out.println("Content of the string is : "+strmsg);
		  
		  String colBeforeToggle = driver.findElement(By.cssSelector("div#my-widget1")).getAttribute("style");
		  
		  System.out.println("Color before toggling : "+colBeforeToggle);
		  
		  String[] bgcolor = colBeforeToggle.split(":");
		  String expectedColor = bgcolor[1].replace(';', ' ').trim();
		  
		  System.out.println(expectedColor);
		  WebElement button = driver.findElement(By.xpath("//*[@id='my-widget1']/button"));
		  for(int i=0;i<60;i++){
			  button.click();
			  String colAfterToggle = driver.findElement(By.cssSelector("div#my-widget1")).getAttribute("style");
			  if(colBeforeToggle.equalsIgnoreCase(colAfterToggle)){
				  System.out.println("Matched");
				  break;
			  }
			  
		  }
		  
	  }
	  
	  
	  
		
	
	
}
