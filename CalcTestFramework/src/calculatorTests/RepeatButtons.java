package calculatorTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RepeatButtons {
	
	WebDriver testDriver;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[12]")
	WebElement equalBtn;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[13]")
	WebElement addBtn;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[14]")
	WebElement subBtn;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[15]")
	WebElement mulBtn;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[16]")
	WebElement divBtn;
	
	@FindBy(xpath = "/html/body/div/div[3]/button[11]")
	WebElement delBtn;
	
	@FindBy(xpath = "//*[@id=\"expression\"]")
	WebElement inputScreen;
	
	@FindBy(id = "output")
	WebElement outputScreen;
	
	public RepeatButtons(WebDriver testDriver) {
		this.testDriver = testDriver;
		PageFactory.initElements(testDriver, this);
	}
	
	public String readInput() {
		return inputScreen.getAttribute("value");
	}
	
	public String readOutput() {
		return outputScreen.getText();
	}
	
	public void clickEqual() {
		equalBtn.click();
	}
	
	public void clickAdd() {
		addBtn.click();
	}
	
	public void clickSub() {
		subBtn.click();
	}
	
	public void clickMul() {
		mulBtn.click();
	}
	
	public void clickDiv() {
		divBtn.click();
	}
	
	public void clickDel() {
		delBtn.click();
	}

}
