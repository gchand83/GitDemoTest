package gouthamacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import gouthamacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {

	// public static void main(String[] args) {
	// TODO Auto-generated method stub

	WebDriver driver;

	public ProductCatalogue(WebDriver driver) {
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

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	By aniMessage = By.cssSelector(".ng-animating");

	public List<WebElement> getProductList() {

		waitForElementToAppear(productsBy);
		return products;
	}

	public WebElement getProductByName(String productName) {

		WebElement prod = getProductList().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);
		return prod;

	}

	public void addProductToCart(String productName) {
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisAppear(spinner);

	}

}
