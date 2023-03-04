package calculatorTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicOperations {
	
	WebDriver testDriver;
	String calC = "http://output.jsbin.com/hudape/1/";
	
	public static WebDriver newDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/tavtejsingh/Documents/jarfiles_selenium/chromedriver");
		return new ChromeDriver();
	}
	
	@BeforeMethod
	public void openUrl() {
		testDriver = newDriver();
		testDriver.get(calC);
	}
	
	@Test
	public void additionTest() {
		testDriver.findElement(By.xpath("/html/body/div/div[3]/button[1]")).click();
		testDriver.findElement(By.xpath("/html/body/div/div[3]/button[13]")).click();
		testDriver.findElement(By.xpath("/html/body/div/div[3]/button[8]")).click();
		testDriver.findElement(By.xpath("/html/body/div/div[3]/button[12]")).click();
		
		String value = testDriver.findElement(By.id("output")).getText();
		Assert.assertEquals("9", value, "Value mismatch test failed");
	}
	
	
	//chromeDriver.get("http://output.jsbin.com/hudape/1/");

//	public static void main(String[] args) {
//		chromeDriver.findElement(By.xpath("/html/body/div/div[3]/button[6]")).click();
//	}

}
