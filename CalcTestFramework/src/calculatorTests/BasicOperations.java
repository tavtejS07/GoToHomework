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
	
	/**
	 * add one and eight
	 * expected result 9
	 */
	@Test
	public void additionTest() {
		num.one();
		rpt.clickAdd();
		num.eight();
		rpt.clickEqual();
		
		String input = rpt.readInput();
		String output = rpt.readOutput();
		
		System.out.println("input provided = " + input);
		System.out.println("output received = " + output);
		
		Assert.assertEquals("9", output, "Value mismatch test failed");
	}
	
	
	/**
	 * subtract 2 from 6
	 * expected result 4
	 */
	@Test
	public void subtractionTest() {
		num.six();
		rpt.clickSub();
		num.two();
		rpt.clickEqual();
		
		String input = rpt.readInput();
		String output = rpt.readOutput();
		
		System.out.println("input provided = " + input);
		System.out.println("output received = " + output);
		
		Assert.assertEquals("4", output, "Value mismatch test failed");
	}
	
	/**
	 * divide 9 by 3
	 * expected result 3
	 */
	@Test
	public void divisionTest() {
		num.nine();
		rpt.clickDiv();
		num.three();
		rpt.clickEqual();
		
		String input = rpt.readInput();
		String output = rpt.readOutput();
		
		System.out.println("input provided = " + input);
		System.out.println("output received = " + output);
		
		Assert.assertEquals("3", output, "Value mismatch test failed");
	}
	
	/**
	 * Multiply 7 and 4
	 * expected result 28
	 */
	@Test
	public void multiplicationTest() {
		num.seven();
		rpt.clickMul();
		num.four();
		rpt.clickEqual();
		
		String input = rpt.readInput();
		String output = rpt.readOutput();
		
		System.out.println("input provided = " + input);
		System.out.println("output received = " + output);
		
		Assert.assertEquals("28", output, "Value mismatch test failed");
	}
	
	/**
	 * test BODMAS functionality
	 * use expression 10-1+3*4/2 -- Expected result = 15
	 * This test should fail at assertion proving that the BODMAS works
	 */
	@Test
	public void bodmasTest() {
		num.one();
		num.zero();
		rpt.clickSub();
		num.one();
		rpt.clickAdd();
		num.three();
		rpt.clickMul();
		num.four();
		rpt.clickDiv();
		num.two();
		rpt.clickEqual();
		
		String input = rpt.readInput();
		String output = rpt.readOutput();
		
		System.out.println("input provided = " + input);
		System.out.println("output received = " + output);
		
		Assert.assertEquals("24", output, "Value mismatch test failed");
	}
	
	@Test
	public void deleteTest(){
		num.nine();
		num.zero();
		rpt.clickAdd();
		rpt.clickMul();
		num.two();
		rpt.clickEqual();
		
		String input = rpt.readInput();
		String output = rpt.readOutput();
		
		System.out.println("input provided = " + input);
		System.out.println("output received = " + output);
		Assert.assertEquals("ERR", output, "Value mismatch test failed");
		
		
		if(output.contains("ERR")) {
			rpt.clickDel();
			rpt.clickDel();
			num.two();
			rpt.clickEqual();
			
			String input1 = rpt.readInput();
			String output1 = rpt.readOutput();
			
			System.out.println("new input = " + input1);
			System.out.println("new output = " + output1);
			Assert.assertEquals("ERR", output1, "Value mismatch test failed"); //this assertion if fails will pass the test proving that delete works and new value is calculated
		}
		
	}
	
	@Test
	public void infinityTest() {
		num.three();
		rpt.clickDiv();
		num.zero();
		rpt.clickEqual();

		String input = rpt.readInput();
		String output = rpt.readOutput();
		
		System.out.println("input provided = " + input);
		System.out.println("output received = " + output);
		
		Assert.assertTrue(output.contains("Infinity"));
	}
	
	/**
	 * Test 1+2-3+4 first then delete all the numbers and input operators as below
	 * Testing +-+ inputs
	 * expected result should be an error for only operators
	 */
	@Test
	public void errorAnalysisTest1() {
		num.one();
		rpt.clickAdd();
		num.two();
		rpt.clickSub();
		num.three();
		rpt.clickAdd();
		num.four();
		rpt.clickEqual();
		
		String input = rpt.readInput();
		String output = rpt.readOutput();
		
		System.out.println("input provided = " + input);
		System.out.println("output received = " + output);
		
		if(input.contains("1")) {
			for(int i=0; i<input.length();i++) {
				rpt.clickDel();
			}
			
			rpt.clickAdd();
			rpt.clickSub();
			rpt.clickAdd();
			rpt.clickEqual();
			
			String input1 = rpt.readInput();
			String output1 = rpt.readOutput();
			
			System.out.println("new input = " + input1);
			System.out.println("new output = " + output1);
			Assert.assertTrue(output1.contains("ERR"));
		}
		
	}
	
	
	/**
	 * This test is to calculate decimal divisions and the place of decimal helps to decide if the division was performed correctly or not.
	 */
	@Test
	public void decimalValueTest() {
		num.seven();
		rpt.clickDiv();
		num.three();
		rpt.clickEqual();
		
		String input = rpt.readInput();
		String output = rpt.readOutput();
		
		int decIndex = output.indexOf(".");
		
		System.out.println("input provided = " + input);
		System.out.println("output received = " + output);
		System.out.println("There is a decimal present at " + decIndex + " index");
		
		Assert.assertTrue(output.contains("."));
	}
	
	@Test
	public void negativeValueMulTest() {
		rpt.clickSub();
		num.seven();
		rpt.clickMul();
		rpt.clickSub();
		num.seven();
		rpt.clickEqual();
		
		String input = rpt.readInput();
		String output = rpt.readOutput();
		System.out.println("new input = " + input);
		System.out.println("new output = " + output);
		Assert.assertFalse(output.contains("-"));
		
		if(input.contains("-")) {
			for(int i=0; i<input.length(); i++) {
				rpt.clickDel();
			}
			
			num.seven();
			rpt.clickMul();
			rpt.clickSub();
			num.seven();
			rpt.clickEqual();
			
			String input1 = rpt.readInput();
			String output1 = rpt.readOutput();
			
			System.out.println("new input = " + input1);
			System.out.println("new output = " + output1);
			Assert.assertTrue(output1.contains("-"));
		}
	}
	
	@Test(enabled = false)
	public void readInputDisplay() {
		for(int i=0; i<10; i++) {
			num.three();
			rpt.clickAdd();
		}
		num.three();
		rpt.clickEqual();
		
		String input = rpt.readInput();
		String output = rpt.readOutput();
		System.out.println("new input = " + input);
		System.out.println("new output = " + output);
	}
	
	@AfterMethod
	public void quitBrowser() {
		testDriver.quit();
	}

}
