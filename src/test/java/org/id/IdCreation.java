package org.id;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IdCreation {
	public static WebDriver driver;
	static long start;
	@DataProvider(name="name")
	public Object[][] Idname(){
		return new Object[][] {{"Krishnaraj"}};
		
	}
	@DataProvider(name="mail")
	public Object[][] Idmail(){
		return new Object[][] {{"krishnaraj98@gmail.com"}};
		
	}
	@DataProvider(name="password")
	public Object[][] Idpassword(){
		return new Object[][] {{"Krishna@25"}};
		
	}
	@DataProvider(name="mobile")
	public Object[][] IdMobile(){
		return new Object[][] {{"8098045686"}};
		
	}
	@Parameters("URL")
	@BeforeClass
	public static void browserLaunch(String Url) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}
	@AfterClass
	public static void browserquit() {
		driver.quit();
	}
	@BeforeMethod
	public void startTime() {
		 start=System.currentTimeMillis();
	}
	@AfterMethod
	public void endTime() {
		long end=System.currentTimeMillis();
		System.out.println("Time Taken:"+(end-start));
	}
	@Test(priority=1,dataProvider="name")
	public void name(String name1) {
		WebElement name=driver.findElement(By.id("name"));
		name.sendKeys(name1);
	}
	@Test(priority=2,dataProvider="mail")
	public void mail(String Mail1) {
		WebElement Mail=driver.findElement(By.id("email"));
		Mail.sendKeys(Mail1);
	}
	@Test(priority=3,dataProvider="password")
	public void password(String Pass1) {
		WebElement Pass=driver.findElement(By.id("password"));
		Pass.sendKeys(Pass1);
	}
	@Test(priority=4,dataProvider="mobile")
	public void mobileNumber(String Mobile1) {
		WebElement Mobile=driver.findElement(By.id("mobile"));
		Mobile.sendKeys(Mobile1);
	}
	@Test(priority=5)
	public void Exp() {
		WebElement Exp=driver.findElement(By.xpath("(//h2[@class='main-3'])[1]"));
		Exp.click();
	}
	@Test(priority=6)
	public void Register() {
		WebElement Register=driver.findElement(By.xpath("(//button[@type='submit'])"));
		Register.click();
	}
}
