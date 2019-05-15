package pages;

import java.io.File;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class DashboardPage {
	WebDriver driver;
	
//WebElements 
//DashboardPage 
	@FindBy(xpath = "//app-sidebar//a[contains(text(),'Dashboard')]")
	public WebElement dashboardbutton;
	
	@FindBy(xpath = "//div[@class='topicCard col-xs-12 col-sm-12 col-md-4 col-lg-4'][4]//img[@class='video']")
	public WebElement landsOnGamesScreen;
	
	@FindBy(xpath="//*[contains(text(),'Single')]")
	public WebElement SinglePlayerButton;
	
	@FindBy(xpath="//ul/div[1]")
	public WebElement Option;
	
	@FindBy(xpath="//div[@class='col-md-12 text-center']/button[contains(text(),'Next')]")
	public WebElement ClickNextButton;
	
	@FindBy(xpath="//*[contains(text(),'Random')]")
	public WebElement RandomGameButton;
	
	@FindBy(xpath="//*[contains(text(),'Rapid')]")
	public WebElement RapidfireGameButton;
	
	@FindBy(xpath="//div[@class='col-md-12 text-center']/button[contains(text(),'Leave')]")
	public WebElement LeaveGameButton;
	
	@FindBy(xpath="//button/span[contains(text(), 'Ok')]")
	public WebElement ClickOkonLeaveGamePopUp;
	
	@FindBy(className="profile-pic")
	public WebElement UserProfilePic;
	
	@FindBy(xpath="//*[contains(text(),'Fastest')]")
	public WebElement FastestFingerGameButton;
	
	@FindBy(xpath="(//*[contains(text(),'Flag as inappropriate')])[1]")
	public WebElement FlagAsInappropriateButton;
	
	@FindBy(xpath="//*[contains(text(),'Question is not relevant')]")
	public WebElement SelectFlagQuestionOption;
	
	@FindBy(xpath="//*[contains(text(),'Submit')]")
	public WebElement ClickSubmitButton;

	@FindBy(xpath="(//*[contains(text(),'Upvote')])[1]")
	public WebElement UpvoteQuestion;
	
	@FindBy(xpath="//*[contains(@class,'games-count num-container')]")
	public WebElement NoOfGames;
	
	@FindBy(xpath="//div[@class='row question-count']/div/div/h4")
	public WebElement QuestionNumber;
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void DashboardButton() {
		dashboardbutton.click();
		}
	
// Click on Play button of topic 	
	public void PlayOnFirstTopic() {
		landsOnGamesScreen.click();
		}
// Click on Single Player Button
	public void ClickSinglePlayerButton() {
		SinglePlayerButton.click();
	}
//Select first option	
	public void Selectoption() {
		Option.click();
	}
//Click on Random Opponent Button 
	public void initiateRandomGame() {
		RandomGameButton.click();
	}
//Click on Rapid Fire Game Button	
	public void initiateFastestFinger() {
		FastestFingerGameButton.click();
	}
//Click on Fastest Finger game button 
	public void initiateRapidFire() {
		RapidfireGameButton.click();
	}
	
//Click on Flag as inappropriate button
	public void flagquestion() {
		FlagAsInappropriateButton.click();
		SelectFlagQuestionOption.click();
		ClickSubmitButton.click();
		}
//Upvote a Question from result screen 
	public void upvotequestion() {
		UpvoteQuestion.click();		
	}
//Leave game
	public void leavegame() {
		LeaveGameButton.click();
	}
//Wait for Looking for Opponent to disappear
	public void waittostartgame() {
		new WebDriverWait(driver,40).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//*[contains(text(),'Looking')])")));
	}
	
//Click Ok on Leave Game Pop Up
	public void popup() {
		String myWindowHandle = driver.getWindowHandle();
		driver.switchTo().window(myWindowHandle);
		ClickOkonLeaveGamePopUp.click();
	}
	
//Check that user is landed successfully on Result Screen 
	public void userprofilepicture() {
		UserProfilePic.click();
	}
//Get Number of games Played by user	
	public void getgamesplayed() {
		String gamesplayed = NoOfGames.getText();
        System.out.println(gamesplayed);   	
	}
	
//Play Game for FF	
	 public void playgameFF()
	 {   	 
		 int ques=0;
		 String quesno = QuestionNumber.getText();
		 System.out.println(quesno);
		 String[] vals = quesno.split(" ");
		 String test = "Question "+vals[1] +" of " +vals[3];
		 System.out.println(test);
		 
		 for (int i = Integer.parseInt(vals[1]); i <= Integer.parseInt(vals[3]); i++)
	     {
			 Random rand = new Random();
		     int low = 1;
			 int high = 5;
			 int number = rand.nextInt(high-low) + low;
			 System.out.println("Selected option is"+number);	
			 driver.findElement(By.xpath("//ul/div["+number+"]")).click();	
			// ClickNextButton.click();
			 WebDriverWait wait=new WebDriverWait(driver, 120);
			 System.out.println("QUESTION "+(i+1)+" OF " +vals[3]);
			 String testnew = "QUESTION "+(i+1)+" OF " +vals[3];
		     if(i != Integer.parseInt(vals[3]))
		     {
		    	 wait.until(ExpectedConditions.textToBePresentInElement(QuestionNumber, testnew));
		    		 }
		     else{
		    	 break;
		     }
	     } 
	 }
//Play game for other game types		 
		public void playgames(){
			 for (int i = 1; i <= 5;i++)
		     {
				 Random rand = new Random();
			     int low = 1;
				 int high = 5;
				 int number = rand.nextInt(high-low) + low;
				 System.out.println("Selected option is"+number);	
				 driver.findElement(By.xpath("//ul/div["+number+"]")).click();	
				 ClickNextButton.click();
		}
		 		 
			 }
		
	     }
	 
		 

	 


