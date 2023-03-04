package calculatorTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NumericButtons {
	WebDriver testDriver;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[1]")
	WebElement one;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[2]")
	WebElement two;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[3]")
	WebElement three;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[4]")
	WebElement four;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[5]")
	WebElement five;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[6]")
	WebElement six;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[7]")
	WebElement seven;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[8]")
	WebElement eight;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[9]")
	WebElement nine;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[10]")
	WebElement zero;
	
	public NumericButtons(WebDriver testDriver) {
		this.testDriver = testDriver;
		PageFactory.initElements(testDriver, this);
	}
	
	public void one() {
		one.click();
	}
	
	public void two() {
		two.click();
	}
	
	public void three() {
		three.click();
	}
	
	public void four() {
		four.click();
	}
	
	public void five() {
		five.click();
	}
	
	public void six() {
		six.click();
	}
	
	public void seven() {
		seven.click();
	}
	
	public void eight() {
		eight.click();
	}
	
	public void nine() {
		nine.click();
	}
	
	public void zero() {
		zero.click();
	}
	

}
