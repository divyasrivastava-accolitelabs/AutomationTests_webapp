package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.io.File;
import pages.HomePage;
import pages.LoginPage;


public class UserProfilePage {

	LoginPage loginPage ;
	HomePage homePage;
	
	WebDriver driver;
	 public UserProfilePage(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(this.driver, this);
	 }
	
//	---------------------------------WebElements--------------------------------
	
	@FindBy(xpath = "//ul[@id='profile_menu']//a[contains(text(),'Edit Profile')]")
	public WebElement btnEditProfile;
	
	
	@FindBy(xpath = "//div[@class='edit-icon']/img[@id='edit-profile-pic']")
	public WebElement btnEditprofilepic;
	
	@FindBy(xpath = "//*[@id='file']")
	public WebElement btnUploadfile;
	
	@FindBy(xpath = "//*[@class='btn btn-danger']")
	public WebElement btnCancel;

	@FindBy(xpath = "//*[@class='profile-pic']")
	public WebElement userPic;
	
	@FindBy(xpath = "//*[contains(text(),\"Upload\")]")
	public WebElement btnUploadPic;
	
	
	
//---------- Edit Education ------------------------------------------------------
	
	@FindBy(xpath = "//*[@id='edit-education']")
	public WebElement btnEditEducation;
	
	@FindBy(xpath = "//*[@type='search']")
	public WebElement collegeName;
	
	@FindBy(id = "startDate")
	public WebElement joiningYear;
	
	@FindBy(id = "endDate")
	public WebElement endYear;
	
	@FindBy (xpath ="//*[@class='btn btn-primary'][contains(text(),'Save')]")
	public WebElement saveButton;
	

	@FindBy (xpath ="//*[@class='btn btn-primary'][contains(text(),'Cancel')]")
	public WebElement cancelButton;
	
	@FindBy (xpath = "//div[@class='toast-message ng-star-inserted']")
	public WebElement updateMessage;
	

	@FindBy (xpath = "//*[@class='error-msg'][contains(text(),'Please fill the joining year.')]")
	public WebElement errorMessageJoiningYear;
	
	@FindBy (xpath = "//*[@class='error-msg'][contains(text(),'Please fill the ending year.')]")
	public WebElement errorMessageEndingYear;
	
	@FindBy (xpath = "//*[@class='error-msg'][contains(text(),'Please enter a valid year')]")
	public WebElement errorMessageValidYear;
	
	@FindBy (xpath = "//*[@class='error-msg'][contains(text(),'Please fill the institute.')]")
	public WebElement errorMessageInstitute ;
	
	@FindBy (xpath = "//*[@class='mat-button-wrapper'][contains(text(),'Yes')]")
	public WebElement btnYesFromCancelbtnPopUp;
	
	@FindBy (xpath = "//*[@class='mat-button-wrapper'][contains(text(),'No')]")
	public WebElement btnNoFromCancelbtnPopUp;
	
	
	
	public void Updatecollege(String name) {
		collegeName.clear();
		collegeName.sendKeys(name);
		}
	
	public void UpdateJoiningYear(String year) throws Exception{
		joiningYear.clear();
		joiningYear.sendKeys(year);
		}
	public void UpdateEndingYear(String year) throws Exception{
		endYear.clear();
		endYear.sendKeys(year);
		}
	public String getUpdateMessageforEducationDetails() {
		String Msg = updateMessage.getText();
		return Msg;
	}
	
	public String getErrorMessageJoiningYear() {
		String Msg = errorMessageJoiningYear.getText();
		return Msg;
		}
	

	public String getErrorMessageEndingYear() {
		String Msg = errorMessageEndingYear.getText();
		return Msg;
	}
	
	public String getErrorMessageValidYear() {
		String Msg = errorMessageValidYear.getText();
		return Msg;
	}
	public String getErrorMessageEnterInstituteName() {
		String Msg = errorMessageInstitute.getText();
		return Msg;
	}
	

	
	
// Edit Company -----------------------------------------------------------------
	
	
   @FindBy (xpath = "//*[@id='edit-company']")
   public WebElement editCompany;
	 
	@FindBy (xpath = "//div/label[contains(text(),'Company')]/following-sibling::div//input")
	public WebElement fieldComapany;
	
	@FindBy (xpath = "//div/label[contains(text(),'Designation')]/following-sibling::div//input")
	public WebElement fieldJobDesignation;
   
  
    @FindBy (xpath ="//*[@class='btn btn-primary'][contains(text(),'Save')]")
	public WebElement saveCompanyDetailsButton;
	

	@FindBy (xpath ="//*[@class='btn btn-primary'][contains(text(),'Cancel')]")
	public WebElement cancelComapnyDetailsButton;
   
	public  void clearCompanyFields() {
		fieldComapany.clear();
		fieldJobDesignation.clear();
		}
   
	
//---------Edit Personal Details-------------------------------------------------
	@FindBy (id = "edit-personal")
	public WebElement btnEditDetails;
	
	@FindBy(id = "firstName")
	public WebElement fieldFirstName;
	
	@FindBy(id = "lastName")
	public WebElement fieldLastname;
	
	@FindBy(id = "profession")
	public WebElement fieldprofession;
	
	
	@FindBy (xpath = "//*[@class='btnpicker btnpickerenabled']")
	public WebElement dob;
	@FindBy (xpath = "//*[@class='markcurrday']")
	public WebElement selectCurrentDate;
	
	
	@FindBy(id = "gender")
	public WebElement fieldgender;
	
	@FindBy(id = "phoneNumber")
	public WebElement fieldPhoneNumber;
	
	@FindBy(id = "address")
	public WebElement fieldAddress;
	
	// Country 
	@FindBy(xpath = "//div/label[contains(text(),'Country')]/following-sibling::div//input")
	public WebElement fieldCountry;
	
	
	// State 
	@FindBy(xpath = "//div/label[contains(text(),'State')]/following-sibling::div//input")
	public WebElement fieldState;
	
	// City
	@FindBy(xpath = "//div/label[contains(text(),'City')]/following-sibling::div//input")
	public WebElement fieldCity;
	
	@FindBy(id = "pincode")
	public WebElement fieldpincode;
	
	@FindBy(xpath = "//*[@type='submit']")
	public WebElement btnSave;
	
	@FindBy (xpath = "//*[@aria-label='User Profile updated']")
	public WebElement profileUpdateMessage;
	
	@FindBy(xpath = "//*[@type='button']")
	public WebElement btnCanceleditprofile;
	
	public void updateDob() {
		dob.click();
		selectCurrentDate.click();
		}
	
	public void UpdatePersonalDetails(String Fname, String Lname, String PhoneNumber, String Address, String Country,
			String State, String City, String Pincode) {
		fieldFirstName.clear();
		fieldFirstName.sendKeys(Fname);
		fieldLastname.clear();
		fieldLastname.sendKeys(Lname);
		fieldPhoneNumber.clear();
		fieldPhoneNumber.sendKeys(PhoneNumber);
		fieldAddress.clear();
		fieldAddress.sendKeys(Address);
		fieldCountry.clear();
		fieldCountry.sendKeys(Country);
		fieldState.clear();
	    fieldState.sendKeys(State);
	    fieldCity.clear();
		fieldCity.sendKeys(City);
		fieldpincode.clear();
		fieldpincode.sendKeys(Pincode);
		
		}
	public String getUpdateMessageforPersonalDetails() {
		String Msg = profileUpdateMessage.getText();
		return Msg;
	}
	
// -----Update Password------------------------------------------------
	
@FindBy (xpath = "//*[@formcontrolname='currentPassword']")
public WebElement currentPassword;

@FindBy (xpath = "//*[@formcontrolname='newPassword']")
public WebElement newPassword;

@FindBy (xpath = "//*[@formcontrolname='newConfirmPassword']")
public WebElement newConfirmPassword;

@FindBy (xpath = "//*[@class='error-msg'][contains(text(),'Current Password must have atleast 8 characters')]")
public WebElement errorMessageCurrentPassword;

@FindBy (xpath = "//*[@class='error-msg'][contains(text(),'New Password must have atleast 8 characters')]")
public WebElement errorMessageNewPassword;

@FindBy (xpath = "//*[@class='error-msg'][contains(text(),'Confirm Password must have atleast 8 characters')]")
public WebElement errorMessageConfirmPassword;

@FindBy (xpath = "//*[@class='error-msg'][contains(text(),'New password and Confirm password must be same')]")
public WebElement errorMessageNewPasswordMismatch;

@FindBy (xpath = "//*[@class='error-msg'][contains(text(),'Current password and New password must be different')]")
public WebElement errorMessageSameCurrentandNewPassword;


@FindBy (xpath ="//*[@role=\"alertdialog\"][contains(text(),'The current password does not match with your existing password')]")
public WebElement errorMessageIncorrectCurrentPassword;



public String getIncorrectCurrentPasswordMessage() {
	String Msg = errorMessageIncorrectCurrentPassword.getText();
	return Msg;
}

public String getNewPasswordMismatchMessage() {
	String Msg = errorMessageNewPasswordMismatch.getText();
	return Msg;
}

public String getSameNewandCurrentPasswordMessage() {
	String Msg = errorMessageSameCurrentandNewPassword.getText();
	return Msg;
}

public void clearFields() {
 currentPassword.clear();
 newPassword.clear();
 newConfirmPassword.clear();
}


@FindBy (xpath ="//*[@class='btn btn-primary '][contains(text(),'Save')]")
public WebElement savePasswordBtn;

@FindBy (xpath ="//*[@class='btn btn-primary'][contains(text(),'Cancel')]")
public WebElement CancelPasswordBtn;

//-------Number of Games Played----------------------------------------
	
	@FindBy (xpath = "//*[contains(@src,\"test-icons.png\")]/..//span[@class=\"bignum\"]")
	public WebElement gamesCount;
	
	public boolean fetchCountOfGamesPlayed(){
		String count = getGamesCount();
		boolean status=false;
		if(count.isEmpty()) {
			status=false;
		}
		else {
			status=true;
		}
		return status;
	}
	
	public String getGamesCount() {
		String Msg = gamesCount.getText();
		return Msg;
		
	}
//-------Member Since----------------------------------------
	
		@FindBy (xpath = "//*[contains(@class,\"calendar\")]/../..//*[@class=\"bignum\"]")
		public WebElement memberSinceCount;	

		public boolean fetchMemberSince(){
			String count = getMemberSince();
			boolean status=false;
			if(count.isEmpty()) {
				status=false;
			}
			else {
				status=true;
			}
			return status;
		}
		
		public String getMemberSince() {
			String Msg = memberSinceCount.getText();
			return Msg;
			
		}
//-------Performance----------------------------------------
		
	@FindBy (xpath = "//*[@class=\"success-circle\"]")
	public WebElement performanceSuccessRate;	
	
	public boolean fetchSuccessRate(){
		String count = getSuccessRate();
		boolean status=false;
		if(count.isEmpty()) {
			status=false;
		}
		else {
			status=true;
		}
		return status;
	}
	
	
	public String getSuccessRate() {
		String Msg = performanceSuccessRate.getText();
		return Msg;
		
	}
	
//-------Packs -----------------------------------------------
	
	@FindBy (xpath = "//*[@class=\"packs-available-list packs-container\"]/div")
	public WebElement userPacks;
	
	@FindBy (xpath ="//*[contains(text(),'No Packs Available!')]")
	public WebElement noPacksMessage;
	
	public boolean fetchUserPacksCount() {
		int count = driver.findElements(By.xpath("//*[@class=\"packs-available-list packs-container\"]/div")).size();
		boolean status=false;
		if (count == 0) {
			status = false;
			}
		else {
			status = true;
		}
			return status;
		
	}
//-------------SharePerformanceButton-------------------------------------
	
	
    @FindBy (xpath = "//input[@value='NO ONE']")
	public  WebElement sharePerfWithNoOne;
	
	@FindBy (xpath = "//input[@value='MY FRIENDS ONLY']")
	public  WebElement sharePerfWithFriends;
	
	@FindBy (xpath = "//input[@value='ALL ACEIT USERS']")
	public  WebElement sharePerfWithAllUser;
	
	public String getUpdateMessageforsharingPerformanceWith() {
		String Msg = profileUpdateMessage.getText();
		return Msg;
	}
	
// --------Badges----------------------------------------------------------
	//@FindBy (xpath = "//*[@class = 'budget-earn-list']")
	@FindBy (xpath = "//*[@alt= 'badge']")
	public WebElement userBadges;
		
}
