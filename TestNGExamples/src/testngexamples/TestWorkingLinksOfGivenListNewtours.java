package testngexamples;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestWorkingLinksOfGivenListNewtours {
	
	WebDriver driver;
  @BeforeClass
  public void setUp() throws InterruptedException {
		 
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	  driver = new ChromeDriver();
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  
	  driver.get("http://newtours.demoaut.com/");
	  Thread.sleep(5000);
	    
		  
  }
  @Test
  public void TestWorkingLinks() throws ClientProtocolException, IOException {
	  int invalidlinks = 0;
	  WebElement alllinksInGroup = driver.findElement(By.xpath("html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table"));
	  
	 List<WebElement> rowElements = alllinksInGroup.findElements(By.tagName("td"));
	 int rowsSize = rowElements.size();
	 	 String url ="";
	
		
		 for(int rnum=0; rnum<rowsSize;rnum++){
			 WebElement link = rowElements.get(rnum).findElement(By.tagName("a"));
			 url = link.getAttribute("href");
			 System.out.println("URL : "+url);
			if(url!=null){
				 HttpClient client = HttpClientBuilder.create().build();
				 HttpGet request = new HttpGet(url);
				 HttpResponse response = client.execute(request);
				 if(response.getStatusLine().getStatusCode()!=200){
					invalidlinks++;
					System.out.println("Invalid link : "+url);
				 }
				 
				 
			 }
			 else
				 invalidlinks++;
			 
			}
		
	 System.out.println("Number of Invalid Links: "+invalidlinks);
 }


  @AfterClass
  public void tearDown() {
	  driver.close();
	  
  }

}
