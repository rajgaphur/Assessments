package testngexamples;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parameterisation {
	

  @Test(dataProvider = "getData")
  public void testApplication(String first, String second, String third) {
	  System.out.println(first);
	  System.out.println(second);
	  

  }
  
  @DataProvider
  public Object[][] getData(){
	  Object[][] data  = new Object[2][3];
	  
	  data[0][0] = "1";
	  data[0][1] = "2";
	  data[0][2] = "3";
	  
	  data[1][0] = "3";
	  data[1][1] = "4";
	  data[1][2] = "5";
	  
	  
	  return data;
   }
	
  }

