package testngexamples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAutocomplete {
 
	WebDriver driver;
	  @BeforeClass
	  public void setUp() throws InterruptedException {
			 
		  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		  driver = new ChromeDriver();
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		  driver.get("https://jqueryui.com/autocomplete/");
		 // Thread.sleep(5000);
		    	  
	  }
	
	
  @Test
  public void autocompleteTest() {
	  
	  driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='content']/iframe")));
	  char key = 'J';
	  
	  driver.findElement(By.cssSelector("input#tags")).sendKeys("a");
	  WebElement ele = driver.findElement(By.cssSelector("ul#ui-id-1"));
	  
	  List<WebElement> elements = ele.findElements(By.tagName("li"));
	  int elementsLength = elements.size();
	  for(int i=0;i<elementsLength;i++){
		 
		  String text = elements.get(i).findElement(By.tagName("div")).getText();
		  if(text.charAt(0)==key){
			  System.out.println(text);
		  }
		  System.out.println(text);//will print all the listed autocomplete data
		  
	  }
  }
  
  @AfterClass
  public void tearDown() {
	  driver.close();
	  
  }
  

}
