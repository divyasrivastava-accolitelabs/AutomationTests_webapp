package Tests;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserProfilePage;
import Utils.DriverSetup;

public class LoginTests extends DriverSetup{
	LoginPage loginPage ;
	HomePage homePage;
	UserProfilePage userProfilePage;
	
	String loginErrorMsg = "×\n" + "Invalid Login Credentials!\n" +	"Please enter correct username and password.";

	@BeforeClass
	public void driversetup() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		userProfilePage = new UserProfilePage(driver);
	}
/*
	@Test(priority=0, description = "Logging in Eduthrill Webapp with blank credentials")
	public void verifyLoginWithBlankCredentials() throws Exception {
		loginPage.login("","");
		Assert.assertEquals(loginPage.getToastMsg(), loginErrorMsg);
		Thread.sleep(3000);
	}

	@Test(priority=1, description = "Logging in Eduthrill Webapp with blank Username")
	public void VerifyLoginWithBlankUsername() throws Exception {
		loginPage.login("","password");
		Assert.assertEquals(loginPage.getToastMsg(), loginErrorMsg);
		Thread.sleep(3000);
	}
	
	@Test(priority=2, description = "Logging in Eduthrill Webapp with blank password")
	public void VerifyLoginWithBlankPassword() throws Exception {
		loginPage.login("usa@mailinator.com","");
		Assert.assertEquals(loginPage.getToastMsg(), loginErrorMsg);
		Thread.sleep(3000);
	}

	@Test(priority=3, description = "Logging in Eduthrill Webapp with invalid username")
	public void VerifyLoginWithInvalidUsername() throws Exception {
		loginPage.login("usa", "password");
		Assert.assertEquals(loginPage.getToastMsg(), loginErrorMsg);
		Thread.sleep(3000);
	}
	
	@Test(priority=4, description = "Logging in Eduthrill Webapp with invalid password")
	public void VerifyLoginWithInvalidPassword() throws Exception {
		loginPage.login("usa@mailinator.com","password1");
		Assert.assertEquals(loginPage.getToastMsg(), loginErrorMsg);
		Thread.sleep(3000);
	}

	@Test(priority=5, description ="Logging in Eduthrill Webapp with valid credentials" )
	public void VerifyLoginWithValidCredentials() throws Exception {
		loginPage.login("hey1@mailinator.com", "password");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertTrue(homePage.userimagepresent());
		homePage.logout();
	}

	@Test(priority=6, description ="SignUp in Eduthrill Webapp With Missing Mandatory Fields" )
	public void VerifySignUpWithMissingMandatoryFields() throws Exception {
		loginPage.signup("","","","","","");
		Thread.sleep(2000);
	    Assert.assertFalse(loginPage.checkSignupBtnIsEnabled());
		loginPage.backToLogin();
	}
	
	@Test(priority=7, description ="SignUp in Eduthrill Webapp With Invalid Email id" )
	public void VerifySignUpWithInvalidEmailId() throws Exception {
		loginPage.signup("rasj","password","password","automation","test","9876543210");
		Thread.sleep(2000);
		Assert.assertFalse(loginPage.checkSignupBtnIsEnabled());
		loginPage.backToLogin();
	}
	
	@Test(priority=8, description ="SignUp in Eduthrill Webapp with Already Registered Email id" )
	public void VerifySignUpWithAlreadyRegisteredEmailId() throws Exception {
		loginPage.signup("test1divya@gmail.com", "password","password","automation","test","9876543210");
		Thread.sleep(2000);
		driver.switchTo().activeElement();
		Assert.assertEquals(loginPage.getAlreadyRegisteredUserDialogMsg(),"User Already Registered!!");
		loginPage.btnOk.click();
		loginPage.backToLogin();
	}

	@Test(priority=9, description ="SignUp in Eduthrill Webapp With Short Password Length" )
	public void VerifySignUpWithShortPasswordLength() throws Exception {
		loginPage.signup("automationtest@mailinator.com", "pass","pass","automation","test","9876543210");
		Thread.sleep(2000);
		Assert.assertFalse(loginPage.checkSignupBtnIsEnabled());
		loginPage.backToLogin();
	}
			
	@Test(priority=10, description ="SignUp With Invalid PhoneNumber" )
	public void VerifySignUpWithInvalidPhoneNumber() throws Exception {
		loginPage.signup("automationtest@mailinator.com", "pass","pass","automation","test","s8765432s0");
		Thread.sleep(2000);
		Assert.assertFalse(loginPage.checkSignupBtnIsEnabled());
		loginPage.backToLogin();
	}
	
	/*
	@Test(priority=11, description ="Verify SignUp With Mismatched Password and Confirm Password" )
	public void VerifySignUpWithMismatchedPasswordandConfirmPassword() throws Exception {
		loginPage.signup("automationtest@mailinator.com", "password1","password2","automation","test","9876543210");
		Thread.sleep(2000);
		Assert.assertFalse(loginPage.checkSignupBtnIsEnabled());
		loginPage.backToLogin();
	}

	@Test(priority=12, description ="Verify Signing Up new user With OTP" )
	public void VerifySignUpWithOTPValidation() throws Exception {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		//Creating user email id with time stamp
		String userid = timeStamp + "@mailinator.com";
		
		loginPage.signup(userid, "password","password","automation","test","9876543210");
		String OTP = loginPage.fetchOTP(userid);
		Thread.sleep(2000);
		
		loginPage.txtOTP.sendKeys(OTP);
		loginPage.btnCnfrm.click();
		Thread.sleep(3000);
		
		Assert.assertEquals(loginPage.txtHeader.getText(),"Registration Successful!!");
		loginPage.btnRegistrationSuccessfulOK.click();
		Thread.sleep(3000);
		
		//Logging in eduthrill webapp for new signed up user
		loginPage.login(userid, "password");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertTrue(homePage.userimagepresent());
		homePage.logout();
	}
	
	@Test(priority=13, description ="Verify Signing Up new user by resending OTP" )
	public void VerifySingUpWithResendOTP() throws Exception {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		//Creating user email id with time stamp
		String userid = timeStamp + "@mailinator.com";
		loginPage.signup(userid, "password","password","automation","test","9876543210");
		loginPage.btnResendOTP.click();
		
		String OTP = loginPage.fetchOTP(userid);
		Thread.sleep(2000);
		
		loginPage.txtOTP.sendKeys(OTP);
		loginPage.btnCnfrm.click();
		Thread.sleep(3000);
		
		Assert.assertEquals(loginPage.txtHeader.getText(),"Registration Successful!!");
		loginPage.btnRegistrationSuccessfulOK.click();
		Thread.sleep(3000);
		
		//Logging in eduthrill webapp for new signed up user
		loginPage.login(userid, "password");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertTrue(homePage.userimagepresent());
		homePage.logout();
	}
	
	@Test(priority=14, description = "Verifying Forget Password with Blank Field")
	public void VerifyForgetPasswordWithBlankEmailId() throws Exception{
    	loginPage.ForgetPassword("");
		Assert.assertEquals(loginPage.getErrorMsgForForgotPassword(), "Please enter email address" );
		Thread.sleep(6000);
	}
		
	@Test(priority=15, description = "Verifying Forget Password Button with Invalid Email ID")
	public void VerifyForgetPasswordWithInvalidEmailId() throws Exception{
		loginPage.ForgetPassword("hahahaa");
        Assert.assertEquals(loginPage.getErrorMsgForForgotPassword(), "Invalid email address" );
		Thread.sleep(6000);
	} 
	
	@Test(priority=16, description = "Verifying Forget Password Button with Valid Email ID")
	public void VerifyForgetPasswordWithValidEmailId() throws Exception{
       loginPage.ForgetPassword("Usa@mailinator.com");
	   Assert.assertEquals(loginPage.getToastMsg(), "Instructions to reset your password have been sent to your email. To ensure email delivery, please whitelist techadmin@eduthrillmail.com. If you do not receive your email, please be sure to check both your inbox and filters for a message from techadmin@eduthrillmail.com" );
	   Thread.sleep(3000);
	}

	@Test(priority=17, description = "Verifying Forget Password Button with Non Registered Email ID")
	public void VerifyForgetPasswordWithNonRegisteredEmailId() throws Exception{
	   loginPage.ForgetPassword("Higuain@mailinator.com");
       Assert.assertEquals(loginPage.registerfirst(),"Please register first" );
	   Thread.sleep(3000);
	}
	
	
	@Test(priority=17, description = "Verifying Updating Profile Pic")
    public void VerifyUpdatingProfilePic()throws Exception{
		loginPage.login("addy1@mailinator.com", "password");
		Thread.sleep(5000);
		homePage.Dropdown.click();
		userProfilePage.btnEditProfile.click();
		Thread.sleep(5000);
		userProfilePage.btnEditprofilepic.click();
		userProfilePage.btnUploadfile.click();
		Thread.sleep(4000);
		}*/
	@Test(priority=18, description = "Verifying Updating College Details")
	public void VerifyUpdatingCollegeDetails()throws Exception{
		loginPage.login("addy11@mailinator.com", "password");
		Thread.sleep(5000);
		homePage.Dropdown.click();
		userProfilePage.btnEditProfile.click();
		Thread.sleep(3000);
		userProfilePage.btnEditEducation.click();
		Thread.sleep(5000);
		userProfilePage.Updatecollege("Indian Institute of Information Technology, Sonipat");
	    userProfilePage.UpdateJoiningYear("2012");
		userProfilePage.UpdateEndingYear("2016");
		userProfilePage.saveButton.click();
		
		
	}
}
	