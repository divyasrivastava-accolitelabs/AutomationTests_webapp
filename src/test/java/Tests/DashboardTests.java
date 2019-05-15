package Tests;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.HomePage;
import pages.LoginPage;
import Utils.DriverSetup;

@Test
public class DashboardTests extends DriverSetup{
	private static final WebDriver WebDriverRefrence = null;
	LoginPage loginPage ;
	HomePage homePage;
	DashboardPage dashboardPage;

	
	@BeforeClass
	public void driversetup() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		dashboardPage=new DashboardPage(driver);
		}

	 @Test(priority=0, description = "Capture Games Played by User")
		public void CaptureGamesPlayed() throws Exception {
		 loginPage.login("usa@mailinator.com","rashisingh");
		 Thread.sleep(3000);
		 dashboardPage.DashboardButton();
		 Thread.sleep(3000);
		 dashboardPage.getgamesplayed();
	 }

    @Test(priority=1, description = "Verify Single Player Game")
	public void VerifySinglePlayerGame() throws Exception {
		dashboardPage.PlayOnFirstTopic();
		Thread.sleep(3000);
		dashboardPage.ClickSinglePlayerButton();
		dashboardPage.playgames();
		Thread.sleep(6000);	
	}
	
	@Test(priority=2, description = "Verify Single Player Result Screen")
	public void VerifySinglePlayerResultScreen() throws Exception {
		dashboardPage.userprofilepicture();
		dashboardPage.flagquestion();
		Thread.sleep(6000);
	//	dashboardPage.upvotequestion();
		Thread.sleep(6000);
	}	
	
	@Test(priority=3, description = "Verify Random Player Simulated Game")
	public void VerifyRandomOpponentSimulatedGame() throws Exception {
		dashboardPage.initiateRandomGame();
		dashboardPage.waittostartgame();
		dashboardPage.playgames();
		Thread.sleep(6000);	
		dashboardPage.userprofilepicture();
		}


	@Test(priority=4, description = "Verify Rapid fire Simulated Game")
	public void VerifyRapidFireSimulatedGame() throws Exception {
		dashboardPage.initiateRapidFire();
		dashboardPage.waittostartgame();
		dashboardPage.playgames();
		Thread.sleep(6000);	
		dashboardPage.leavegame();
		Thread.sleep(6000);
		dashboardPage.popup();
		Thread.sleep(6000);
	}
	
	@Test(priority=5, description = "Verify Fastest Finger Simulated Game")
	public void VerifyFastestFingerSimulatedGame() throws Exception {
		
		dashboardPage.initiateFastestFinger();
        dashboardPage.waittostartgame();
		dashboardPage.playgameFF();
		Thread.sleep(6000);	
		dashboardPage.userprofilepicture();
	}
	
}