package gouthamacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import gouthamacademy.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	// public static void main(String[] args) {
	// TODO Auto-generated method stub

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement userEmail =
	// driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
	// WebElement pwd
	// =driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
	// WebElement lgn = driver.findElement(By.id("login")).click();
	// driver.findElements(By.cssSelector(".mb-3"));

	// PageFactory

	@FindBy(css = ".cartSection h3")
	List<WebElement> cartProducts;

	@FindBy(css=".totalRow button")
	WebElement checkoutEle;

	public Boolean verifyProductDisplay(String productName) {
	Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
	return match;

	}

	public CheckoutPage goTocheckout() {
		checkoutEle.click();
		return new CheckoutPage(driver);

	}

}
