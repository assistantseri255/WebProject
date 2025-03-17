package Package1.Maven_Project1;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class Pom_signin  {
	
	WebDriver driver;
	
	 Pom_signin( WebDriver d){                      //page factory
		driver=d;
		PageFactory.initElements(d,this);
		 
		
	}
	
	@FindBy(xpath="//div[@id='nav-tools']/a[2]")  WebElement Hello_signin;
    @FindBy(xpath="//div[@id='nav-flyout-ya-signin']/a")  WebElement Signin;
	@FindBy(xpath="//input[@type='email']")  WebElement mobile;
	@FindBy(xpath="//input[@type='submit']")  WebElement Conti;
	@FindBy(xpath="//input[@id='ap_password']")  WebElement pass;
	
	public void clickonSignin() throws InterruptedException {
		Actions action= new Actions(driver);
		action.moveToElement(Hello_signin).perform();
		Thread.sleep(2000);
		Signin.click();
		
	}
	
	public void signinpage() throws InterruptedException {
		mobile.sendKeys("9172999112");
		Thread.sleep(2000);	
		Conti.click();
		pass.sendKeys("Pass@123");
		
		
	}
	
	public void Screenshot() throws IOException {
		
//		Date d = new Date();
//		System.out.println(d);
//		
//		String file=d.toString().replace("_", ":".replace(" ", "_"))+".png";
//		System.out.println(d);
//		
//		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scr, new File("D:\\Screenshot"));
		
		
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr, new File("D:\\Screenshot"+".png"));
	}
	
	
}
