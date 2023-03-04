package calculatorTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import calculatorTests.RepeatButtons;

public class BasicOperations {
	
	WebDriver testDriver;
	String calcLink = "http://output.jsbin.com/hudape/1/";
	RepeatButtons rpt;
	
	
	public static WebDriver newDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/tavtejsingh/Documents/jarfiles_selenium/chromedriver");
		return new ChromeDriver();
	}
	
	@BeforeMethod
	public void openUrl() {
		testDriver = newDriver();
		testDriver.get(calcLink);
		rpt = new RepeatButtons(testDriver);
	}
	
	@Test
	public void additionTest() {
		testDriver.findElement(By.xpath("/html/body/div/div[3]/button[1]")).click();
		rpt.clickAdd();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[13]")).click();
		testDriver.findElement(By.xpath("/html/body/div/div[3]/button[8]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[12]")).click();
		rpt.clickEqual();
		//clickEqual(testDriver);
		
		String value = testDriver.findElement(By.id("output")).getText();
		Assert.assertEquals("9", value, "Value mismatch test failed");
	}
	
	@Test
	public void subtractionTest() {
		testDriver.findElement(By.xpath("/html/body/div/div[3]/button[6]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[14]")).click();
		rpt.clickSub();
		testDriver.findElement(By.xpath("/html/body/div/div[3]/button[2]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[12]")).click();
		rpt.clickEqual();
		String value = testDriver.findElement(By.id("output")).getText();
		Assert.assertEquals("4", value, "Value mismatch test failed");
	}
	
	@Test
	public void divisionTest() {
		testDriver.findElement(By.xpath("/html/body/div/div[3]/button[9]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[10]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[10]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[10]")).click();
		rpt.clickDiv();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[16]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[13]")).click();
		testDriver.findElement(By.xpath("/html/body/div/div[3]/button[3]")).click();
		rpt.clickEqual();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[12]")).click();
		
		String value = testDriver.findElement(By.id("output")).getText();
		//System.out.println(value);
		Assert.assertEquals("3", value, "Value mismatch test failed");
	}
	
	@Test
	public void multiplicationTest() {
		testDriver.findElement(By.xpath("/html/body/div/div[3]/button[7]")).click();
		rpt.clickMul();
		testDriver.findElement(By.xpath("/html/body/div/div[3]/button[4]")).click();
		rpt.clickEqual();
		
		String value = testDriver.findElement(By.id("output")).getText();
		//System.out.println(value);
		Assert.assertEquals("28", value, "Value mismatch test failed");
	}
	
	@AfterMethod
	public void quitBrowser() {
		testDriver.quit();
	}
	
	
	//chromeDriver.get("http://output.jsbin.com/hudape/1/");

//	public static void main(String[] args) {
//		chromeDriver.findElement(By.xpath("/html/body/div/div[3]/button[6]")).click();
//	}

}
