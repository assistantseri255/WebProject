package Package1.Maven_Project1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Assert;
//import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.GetCurrentUrl;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
public class Amezon {
	WebDriver driver;
	Pom_signin obj;
	
		
	@BeforeSuite
	public void setup() {
		//System.setProperty("webdriver.chrome.driver","chromedriver.exefile path");
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	
	}
	
	@AfterSuite(enabled=false)
	public void teardown () {
		driver.close();
	}
		
  @Test(priority=0)
  public void f() throws InterruptedException {
	  
	  // create object for calling
	  obj= new Pom_signin(driver);
	  
	  // call to Clickonsignun method
	  obj.clickonSignin();

	  
	  // click on sign in
      obj.signinpage();
       
      //  click on submit button
       driver.findElement(By.id("signInSubmit")).click();	  
  }
  
  @Test(priority=1,enabled=true)
  public void h() throws InterruptedException, IOException {
	  Thread.sleep(2000);
	  // click on search button
	  driver.findElement(By.id("twotabsearchtextbox")).click();
	  
	  // enter product
	  driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile");
	  
	  // click on search symbol
	  driver.findElement(By.id("nav-search-submit-button")).click();
	  
	  // click on mobile name
	  driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[5]/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
	  
	  
	  // window handle because open other window
	  Set<String> windowhandle= driver.getWindowHandles();
	  int a= windowhandle.size();
	  System.out.println(a);
	  for(String str:windowhandle) {
		  driver.switchTo().window(str);
		  
	  }
	  
	  //add to wishlist
	  
	  driver.findElement(By.xpath("//*[@id=\"add-to-wishlist-button-submit\"]")).click();
	  
	  
	 //  view your list
	  driver.findElement(By.xpath("//*[@id=\"huc-view-your-list-button\"]/span/a")).click();
	 
	 // click on add to card 
	  
	  driver.findElement(By.xpath("//*[@id=\"pab-I3W48IUB52521O\"]/span/a")).click();
	  
	 // proceed to checkout
	  driver.findElement(By.xpath("//*[@id=\"itemAction_I3W48IUB52521O\"]/div[4]/span[1]/span/a/span")).click();
	  Thread.sleep(2000);
	  
	  // takes screenshot
	  obj.Screenshot();
	  
	     driver.close();
	  
	  	  Set<String> window1= driver.getWindowHandles();
	      for(String str1:window1) {
		  driver.switchTo().window(str1);
		  String currenturl=driver.getCurrentUrl();
		  
		
	      }
		   
	  }

	  
  
 @Parameters({"product"})
 @Test(priority=2,enabled=false)
	  
    public void h1(String product) throws IOException {
	 
	 // click on search button
	  driver.findElement(By.id("twotabsearchtextbox")).clear();
	  
	 
	  // click on search button
	 driver.findElement(By.id("twotabsearchtextbox")).click();
	 
	 // enter product
	 driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
	 
	 // click on search symbol
     driver.findElement(By.id("nav-search-submit-button")).click();
		
     // click on any Laptop name
     
     driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
     
     // window handle
     
     Set<String> win1=driver.getWindowHandles();
     for(String str2:win1) {
    	 
    	 driver.switchTo().window(str2);
    	 
    	 
     }
     
     // here Act and EXP dosn't match but will continue Execution because of use here Soft Assertion.
     
    String Act=driver.findElement(By.xpath("//*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[1]/span[3]/span[2]/span[2]")).getText();
    
    String EXP= "37990";
    
    SoftAssert as = new SoftAssert();
    as.assertEquals(Act, EXP);
    System.out.println(Act);
    
    
     //add to wishlist
	  
	  driver.findElement(By.id("add-to-wishlist-button-submit")).click();
	  
    
	  //  view your list
	  driver.findElement(By.xpath("//*[@id=\"huc-view-your-list-button\"]/span/a")).click();
	 
	 // click on add to card 
	  
	  driver.findElement(By.xpath("//*[@id=\"pab-I3NTMA0F68BSHZ\"]/span/a")).click();
	  
	 // proceed to checkout
	  driver.findElement(By.xpath("//*[@id=\"itemAction_I3NTMA0F68BSHZ\"]/div[4]/span[1]/span/a/span")).click();
	 
    
     // take Screenshot
	  obj.Screenshot();
	  
	  driver.close();
	  
	  Set<String> win2=driver.getWindowHandles();
	  for(String str2:win2) {
		  driver.switchTo().window(str2);
	  }
 }
 
 
 @DataProvider(name="sheet")
 public Object [][] getValue (){
	 
	 Object [][] data = new Object [1][1];
	 
	 data[0][0]="headphone";
	 
	return data;
	 
 }
 
 
 @Test(dataProvider="sheet",priority=3,enabled=false)
 public void h2(String Product){
	 
	 
	     // click on search button
		  driver.findElement(By.id("twotabsearchtextbox")).clear();
		  
		 
		  // click on search button
	     
		 driver.findElement(By.id("twotabsearchtextbox")).click();
		 
		 driver.findElement(By.xpath("twotabsearchtextbox")).sendKeys(Product);
		 
		 
		 
		 
	
 }
 

@Test (priority=4,enabled=false)
public void h3() throws IOException, InterruptedException {
	
	// click on search button
	driver.findElement(By.id("twotabsearchtextbox")).clear();
		  
		 
    // click on search button
	 driver.findElement(By.id("twotabsearchtextbox")).click();
		 
		 
String fileName="C:\\Users\\SAHIL\\Desktop\\New Microsoft Excel Worksheet.xlsx";
FileInputStream filestream = new FileInputStream(fileName);
HSSFWorkbook book = new HSSFWorkbook(filestream);
HSSFSheet sheet = book.getSheet("Sheet1");


int rowcount =sheet.getLastRowNum();

for(int i=0;i<=rowcount;i++) {
	
	String product= sheet.getRow(i).getCell(0).getStringCellValue();
	
	 
	// click on search button
	Thread.sleep(1000);
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
    
    FileOutputStream out = new FileOutputStream(fileName);
  
  book.write(out);
  book.close();
}
	
}

}