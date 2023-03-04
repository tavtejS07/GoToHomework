package calculatorTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicOperations {
	
	WebDriver testDriver;
	String calcLink = "http://output.jsbin.com/hudape/1/";
	RepeatButtons rpt;
	NumericButtons num;
	
	
	public static WebDriver newDriver() {
		System.setProperty("webdriver.chrome.driver", "/Users/tavtejsingh/Documents/jarfiles_selenium/chromedriver");
		return new ChromeDriver();
	}
	
	@BeforeMethod
	public void openUrl() {
		testDriver = newDriver();
		testDriver.get(calcLink);
		rpt = new RepeatButtons(testDriver);
		num = new NumericButtons(testDriver);
	}
	
	//add one and eight
	//expected result 9
	@Test
	public void additionTest() {
		num.one();
		rpt.clickAdd();
		num.eight();
		rpt.clickEqual();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[1]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[13]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[8]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[12]")).click();
		//clickEqual(testDriver);
		
		String value = testDriver.findElement(By.id("output")).getText();
		Assert.assertEquals("9", value, "Value mismatch test failed");
	}
	
	
	//subtract 2 from 6
	//expected result 4
	@Test
	public void subtractionTest() {
		num.six();
		rpt.clickSub();
		num.two();
		rpt.clickEqual();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[6]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[14]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[2]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[12]")).click();
		String value = testDriver.findElement(By.id("output")).getText();
		Assert.assertEquals("4", value, "Value mismatch test failed");
	}
	
	//divide 9 by 3
	//expected result 3
	@Test
	public void divisionTest() {
		num.nine();
		rpt.clickDiv();
		num.three();
		rpt.clickEqual();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[9]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[10]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[10]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[10]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[16]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[13]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[3]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[12]")).click();
		
		String value = testDriver.findElement(By.id("output")).getText();
		//System.out.println(value);
		Assert.assertEquals("3", value, "Value mismatch test failed");
	}
	
	//Multiply 7 and 4
	//expected result 28
	@Test
	public void multiplicationTest() {
		num.seven();
		rpt.clickMul();
		num.four();
		rpt.clickEqual();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[7]")).click();
		//testDriver.findElement(By.xpath("/html/body/div/div[3]/button[4]")).click();
		
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
