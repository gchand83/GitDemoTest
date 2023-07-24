package gouthamacademy.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import gouthamacademy.TestComponents.BaseTest;
import gouthamacademy.pageobjects.CartPage;
import gouthamacademy.pageobjects.CheckoutPage;
import gouthamacademy.pageobjects.ConfirmationPage;
import gouthamacademy.pageobjects.LandingPage;
import gouthamacademy.pageobjects.OrderPage;
import gouthamacademy.pageobjects.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class StandAloneTest {

	//@Test
	//public void submitOrder() throws IOException, InterruptedException {
	public static void main(String[] args) throws InterruptedException, IOException {
	
		
		// String emailid="anshika@gmail.com";
		// String pwdid = "Iamking@000";
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().window().maximize();

		//LandingPage landingPage = new LandingPage(driver);
		//landingPage.goTO();
		
		String productName = "ZARA COAT 3";
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTO();
		
		ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		List<WebElement>products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
				 		  
				
		CartPage cartPage = productCatalogue.gotToCartPage();
		
		 
		 		
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0,500)");
		// js.executeScript("window.scrollBy(0, 550)");
		 Thread.sleep(1000);
		 
		CheckoutPage checkoutPage = cartPage.goTocheckout();
	  
		 
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();

		// driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
		// driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		// driver.findElement(By.id("login")).click();
		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		// List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		// prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		// ng-animating
		// wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		// driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		// List <WebElement> cartProducts =
		// driver.findElements(By.cssSelector(".cartSection h3"));
		// Boolean match = cartProducts.stream().anyMatch(cartProduct->
		// cartProduct.getText().equalsIgnoreCase(productName));

		//  JavascriptExecutor js = (JavascriptExecutor) driver;
		//   js.executeScript("window.scrollBy(0,500)");
		//   Thread.sleep(1000);
		// driver.findElement(By.cssSelector(".totalRow button")).click();
		// driver.findElement(By.cssSelector("//button[@class='btn btn-primary' and
		// contains(text(),'Checkout')]")).click();

		// Actions a = new Actions(driver);
		// a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select
		// Country']")), "india").build().perform();

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		// driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		// driver.findElement(By.cssSelector(".action__submit")).click();

		String confirmMessage = confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		OrderPage orderPage = cartPage.goToOrdersPage();
		Boolean verifyOrder = orderPage.verifyOrderDisplay(productName);
		System.out.println(verifyOrder);
		System.out.println("Result Check" +verifyOrder);
		System.out.println("Result Check" +verifyOrder);
		System.out.println("Result Check1" +verifyOrder);
		System.out.println("Result Check2" +verifyOrder);
		System.out.println("Result Check3" +verifyOrder);
		System.out.println("Result Check4" +verifyOrder);
		System.out.println("Result Check5" +verifyOrder);
		Assert.assertTrue(verifyOrder);
		driver.close();
	}

}
