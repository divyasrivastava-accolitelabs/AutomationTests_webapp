package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	//	--------------------------------- WebElements --------------------------------

	//User Profile Drop down displaying on right top corner
	@FindBy(xpath = "//span/a[@id='dropdownMenu1']")
	public WebElement Dropdown;
	
	@FindBy(xpath = "//ul[@id='profile_menu']//a[contains(text(),'Logout')]")
	public WebElement btnLogout;
	
	@FindBy(id = "user_img")
	public WebElement userImage;
	
	//	--------------------------------- Methods --------------------------------
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	// ---- To make sure that user was logged in (Checking User Image) ----
	public boolean userimagepresent() {
		return userImage.isEnabled();
	}
	
	// ---- Logout from Eduthrill Webapp ----
	public void logout(){
		Dropdown.click();
		btnLogout.click();
        
	}

}



