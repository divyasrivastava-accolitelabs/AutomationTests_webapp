package Tests;
import java.text.SimpleDateFormat;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utils.DriverSetup;
import pages.HomePage;
import pages.LoginPage;
import pages.UserProfilePage;

public class UpdateProfileTests extends DriverSetup{

	LoginPage loginPage ;
	HomePage homePage;
	UserProfilePage userProfilePage;
	
	@BeforeClass
	public void driversetup() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
        userProfilePage = new UserProfilePage(driver);
        
        }
	
	@Test(priority=0, description = "Verifying Updating Profile Pic  Cancel Button")
	public void VerifyUpdatingProfilePicCancelButton() throws Exception{
		loginPage.login("addy3@mailinator.com", "password");
		Thread.sleep(5000);
		homePage.Dropdown.click();
		userProfilePage.btnEditProfile.click();
		userProfilePage.btnEditprofilepic.click();
		userProfilePage.btnUploadfile.sendKeys("C:\\\\Users\\\\admin\\\\Desktop\\\\mypic.jpg");
		//userProfilePage.btnUploadfile.sendKeys("D:\\Web Automation\\AutomationTests_EduthrillWebapp\\src\\test\\resources\\data");
		userProfilePage.btnCancel.click();
		
		}
	
	@Test(priority=1, description = "Verifying Updating Profile Pic")
	
		public void VerifyUpdatingProfilePic()throws Exception{
		userProfilePage.btnEditprofilepic.click();
		userProfilePage.btnUploadfile.sendKeys("C:\\Users\\admin\\Desktop\\mypic.jpg");
		Thread.sleep(1000);
		userProfilePage.btnUploadPic.click();
		Thread.sleep(2000);
		
	}
	
	
	
	@Test(priority=2, description = "Verifying Success Rate Is Getting Displayed")
    public void VerifySuccessRateDisplaying()throws Exception{
		Thread.sleep(1000);
		Assert.assertTrue(userProfilePage.fetchSuccessRate());
	}
	
	@Test(priority=3, description = "Verify Number Of Games Played Is Displaying ")
	public void VerifyNumberOfGamesPlayedDisplaying()throws Exception{
		Assert.assertTrue(userProfilePage.fetchCountOfGamesPlayed());
		
		}
	@Test(priority=4, description = "Verify Member Since Count Is Displaying ")
	public void VerifyMemberSinceFieldIsDisplaying()throws Exception{
		Assert.assertTrue(userProfilePage.fetchMemberSince());
		
	}
	
	@Test(priority=5, description = "Verify Pack Details Are Displaying")
	public void VerifyPackDetailsAreDisplaying()throws Exception{
		Assert.assertTrue(userProfilePage.fetchUserPacksCount());
		
	}
	
	@Test(priority=6, description = "Verify Badges are getting displayed")
	public void VerifyBadgesAreGettingDisplayed()throws Exception{
		Assert.assertTrue(userProfilePage.userBadges.isDisplayed());	
		
	}
	
	@Test(priority=7, description = "Verifying Updating Company Details")
	public void VerifyUpdatingCompanyDetails() throws Exception{
		userProfilePage.editCompany.click();
		userProfilePage.clearCompanyFields();
		userProfilePage.fieldComapany.sendKeys("MyCompany");
		userProfilePage.fieldJobDesignation.sendKeys("CEO");
		userProfilePage.saveCompanyDetailsButton.click();
		Thread.sleep(5000);
	}
	
	
	
	
	@Test(priority=8, description = "Verifying Updating College with Missing College Name")
	public void VerifyUpdatingCollegeDetailsWithMissingCollegeName() throws Exception{
		userProfilePage.btnEditEducation.click();
		userProfilePage.Updatecollege(" ");
		userProfilePage.UpdateJoiningYear("2012");
		userProfilePage.UpdateEndingYear("2016");
		Assert.assertTrue(userProfilePage.saveButton.isEnabled());
		Thread.sleep(1000);
		
		}
		
				
	@Test(priority=9, description = "Verifying Updating College with Missing Year")
	public void VerifyUpdatingCollegeDetailsWithMissingYear() throws Exception{
		userProfilePage.Updatecollege("Indian Institute of Information Technology, Sonipat ");
		userProfilePage.UpdateJoiningYear("");
		userProfilePage.UpdateEndingYear("");
			Assert.assertTrue(userProfilePage.saveButton.isEnabled());
			Thread.sleep(6000);
}
	@Test(priority=10, description = "Verifying Updating College with Invalid Year")
	public void VerifyUpdatingCollegeDetailsWithInvalidYear() throws Exception{
		userProfilePage.Updatecollege("Indian Institute of Information Technology, Sonipat ");
		userProfilePage.UpdateJoiningYear("abc2019");
		userProfilePage.UpdateEndingYear("abc2001");
		Thread.sleep(1000);
		Assert.assertEquals(userProfilePage.getErrorMessageValidYear(), "Please enter a valid year" );
		
	}
	@Test(priority=11, description = "Verifying Updating College with Valid Details")
	public void VerifyUpdatingCollegeDetails()throws Exception{
		userProfilePage.Updatecollege("Indian Institute of Information Technology, Sonipat");
	    userProfilePage.UpdateJoiningYear("2012");
		userProfilePage.UpdateEndingYear("2016");
		userProfilePage.saveButton.click();
		Thread.sleep(2000);
		Assert.assertEquals(userProfilePage.getUpdateMessageforEducationDetails(), "User Profile updated" );
		Thread.sleep(6000);
			}
	
	
	@Test(priority=12, description = "Verifying Updating Personal Details with Valid Details")
	public void VerifyUpdatingPersonalDetails()throws Exception{
		userProfilePage.btnEditDetails.click();
		Thread.sleep(1000);
		userProfilePage.UpdatePersonalDetails("TestFirstName", "TestLastName", "9810101010", "Test Address",
		"India", "National Capital Territory of Delhi", "Delhi", "110091");
	    userProfilePage.updateDob();
		userProfilePage.btnSave.click();
		Thread.sleep(1000);
		Assert.assertEquals(userProfilePage.getUpdateMessageforPersonalDetails(), "User Profile updated" );
	} 
	
	@Test(priority=13, description = "verify update share performance with no one")
	public  void VerifyUpdatingShareMyPerformanceDetailsWithNoOne()throws Exception{
		userProfilePage.sharePerfWithNoOne.click();
		Thread.sleep(500);
		Assert.assertEquals(userProfilePage.getUpdateMessageforsharingPerformanceWith(), "User Profile updated" );
		}
	
	@Test(priority=14, description = "verify update share performance with My Friends")
	public  void VerifyUpdatingShareMyPerformanceDetailsWithMyFriends()throws Exception{
		userProfilePage.sharePerfWithFriends.click();
		Thread.sleep(500);
		Assert.assertEquals(userProfilePage.getUpdateMessageforsharingPerformanceWith(), "User Profile updated" );
		}
	
	@Test(priority=15, description = "verify update share performance with All User's")
	public  void VerifyUpdatingShareMyPerformanceDetailsWithAllUsers()throws Exception{
		userProfilePage.sharePerfWithAllUser.click();
		Thread.sleep(500);
		Assert.assertEquals(userProfilePage.getUpdateMessageforsharingPerformanceWith(), "User Profile updated" );
		}
	
	@Test(priority=16, description = "Verifying Update Password with Incorrect Current Password")
	public void  verifyingupdatepasswordinvalidcurrentpassword()throws Exception{
		Thread.sleep(1000);
		userProfilePage.currentPassword.sendKeys("incorrectcurrentpassword");
		userProfilePage.newPassword.sendKeys("newpassword");
		userProfilePage.newConfirmPassword.sendKeys("newpassword");
		userProfilePage.savePasswordBtn.click();
		Thread.sleep(1000);
		Assert.assertEquals(userProfilePage.getIncorrectCurrentPasswordMessage(), "The current password does not match with your existing password" );
	}
	
	@Test(priority=17, description = "Verifying Update password with incorrect New password and Confirm password")
	public void  VerifyingUpdatingMismtachNewPassword()throws Exception{
		
		userProfilePage.clearFields();
		userProfilePage.currentPassword.sendKeys("password");
		userProfilePage.newPassword.sendKeys("newpassword");
		userProfilePage.newConfirmPassword.sendKeys("mismatchpassword");
		userProfilePage.savePasswordBtn.click();	
		Assert.assertEquals(userProfilePage.getNewPasswordMismatchMessage(), "New password and Confirm password must be same" );
	}
	@Test(priority=18, description = "Verifying Update password with same current password and New password")
	public void  VerifyingUpdatingPasswordWithSameCurrentandNewPassword()throws Exception{
		userProfilePage.clearFields();
		userProfilePage.currentPassword.sendKeys("password");
		userProfilePage.newPassword.sendKeys("password");
		userProfilePage.newConfirmPassword.sendKeys("password");
		Assert.assertEquals(userProfilePage.getSameNewandCurrentPasswordMessage(), "Current password and New password must be different" );
		
	}
	
	/*@Test(priority=19, description = "Verifying Update password with positive case")
	public void  VerifyingUpdatingPassword()throws Exception{
		userProfilePage.clearFields();
		userProfilePage.currentPassword.sendKeys("password");
		userProfilePage.newPassword.sendKeys("newpassword");
		userProfilePage.newConfirmPassword.sendKeys("newpassword");
		userProfilePage.savePasswordBtn.click();
		
	} */
	
	
}

