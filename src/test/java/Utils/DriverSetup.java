package Utils;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class DriverSetup {

public static WebDriver driver;
String browser = "chrome";

@BeforeSuite(alwaysRun = true)

public WebDriver driverSetup() throws Exception {
	switch (browser) {
	case "firefox":
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
	case "chrome":
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
	case "ie":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + File.separator + "drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
	case "edge":
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + File.separator + "drivers\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			break;
	default :
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
}
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("chrome://settings/clearBrowserData");
	driver.get("http://dev-pwa.eduthrill.com/login");
	return driver;
	}

@AfterSuite(alwaysRun = true)
public void quit(){
driver.quit();
 }
}