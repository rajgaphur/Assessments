package testngexamples;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUploadUsingAutoIt {

	WebDriver driver;

	@Test
	public void fileUploadUsingAutoIt() {
		try {

			driver.findElement(By.id("file-upload")).click();
			Runtime.getRuntime()
					.exec("C:\\Users\\m1022011\\Desktop\\Selenium\\AutoIT softs\\FileUpload.exe");
			driver.findElement(By.id("file-submit")).click();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("");
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
