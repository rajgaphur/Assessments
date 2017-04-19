package testngexamples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TableExample {
	WebDriver driver;
	  @BeforeClass
	  public void setUp() throws InterruptedException {
			 
		  System.setProperty("webdriver.chrome.driver", "Utils\\chromedriver.exe"); //Amended the driver path
		  driver = new ChromeDriver();
		  
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		  driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_table_intro");
		 // Thread.sleep(5000);
		    	  
	  }
	  
	  @Test
	  public void tableDataTest(){
		  
		  driver.switchTo().frame("iframeResult");
		  WebElement tableElmt = driver.findElement(By.xpath("/html/body/table/tbody"));
		  
		  List<WebElement> rowElements = tableElmt.findElements(By.tagName("tr"));
		  int rowsize = rowElements.size();
		  
		  List<WebElement> colheader = rowElements.get(0).findElements(By.tagName("th"));
		  int colheadersize = colheader.size();
		  
		 
		  
		  for(int j=0;j<colheadersize;j++){
			  System.out.print(colheader.get(j).getText()+"            ");
			  
		  }
		  System.out.println();
		  
		  for(int i=1;i<rowsize;i++){
			  
			  List<WebElement> colElements = rowElements.get(i).findElements(By.tagName("td"));
			  int colsize = colElements.size();
			  
			  for(int j=0;j<colsize;j++){
				  System.out.print(colElements.get(j).getText()+"            ");
				  
			  }
			  System.out.println();
			  
		  }
		  
		  
		  
		  
		  
		  
	  }
	
	  @AfterClass
	  public void tearDown() {
		  driver.close();
		  
	  }

}
