/*package gouthamacademy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	
	
	public WebDriver initializeDriver() throws IOException {
		// TODO Auto-generated method stub

		// Properties Class
		
		WebDriver driver;
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+
				"\\src\\main\\java\\gouthamacademy\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			// firefox
			System.setProperty("webdriver.edge.driver", "firefox.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			// edge
			System.setProperty("webdriver.edge.driver", "edge.exe");
			driver = new EdgeDriver();

		}
		
		return driver;
		System.out.println("Result Check5" +verifyOrder);
		System.out.println("Result Check5" +verifyOrder);

	}

	/*public LandingPage launchApplication() throws IOException 
	{
		driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTO();
		return landingPage;
	}*/
	

