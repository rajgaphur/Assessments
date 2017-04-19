package testngexamples;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.worker.Worker;

public class ReadExcel {
	WebDriver driver;
 
  @BeforeClass
  public void setUp() throws InterruptedException {
		 
	  System.setProperty("webdriver.chrome.driver", "Utils\\chromedriver.exe"); //Amended the driver path
	  driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.get("http://newtours.demoaut.com/mercurysignon.php");
	  Thread.sleep(5000);
	    
		  
  }
  @Test
  public void ReadExcelSheet() {
	  File xlFile = new File("C:\\Users\\m1022011\\Desktop\\Selenium\\TestingSheet.xlsx");
	  
	  try {
		FileInputStream fis = new FileInputStream(xlFile);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
	  
	  
  }

  @AfterClass
  public void afterClass() {
  }

}
