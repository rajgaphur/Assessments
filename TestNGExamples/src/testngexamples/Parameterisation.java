package testngexamples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Parameterisation {
	

  @Test(dataProvider = "getData")
  public void testApplication(String first, String second) {
	  System.out.println(first);
	  System.out.println(second);
	  

  }
  
  @DataProvider
  public Object[][] getData(){
	  Object[][] data  = new Object[3][3];
	  
	  data[0][0] = "1";
	  data[0][1] = "2";
	  
	  data[1][0] = "3";
	  data[1][1] = "4";
	  
	  data[2][0] = "5";
	  data[2][1] = "6";
	  
	  return data;
  }
}
