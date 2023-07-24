package gouthamacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import gouthamacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	// public static void main(String[] args) {
	// TODO Auto-generated method stub

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail =
	// driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
	// WebElement pwd
	// =driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
	// WebElement lgn = driver.findElement(By.id("login")).click();
	// PageFactory

	@FindBy(id = "userEmail")
	WebElement useremail;

	@FindBy(id = "userPassword")
	WebElement password;

	@FindBy(id = "login")
	WebElement submit;

	public ProductCatalogue loginApplication(String email, String pwd) {
		useremail.sendKeys(email);
		password.sendKeys(pwd);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}

	public void goTO() {
		driver.get("https://rahulshettyacademy.com/client");

	}

}
