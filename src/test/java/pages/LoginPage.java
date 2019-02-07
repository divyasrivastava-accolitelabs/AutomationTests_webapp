package pages;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	WebDriver driver;
	
	//	---------------------------------WebElements--------------------------------
	
	//	----Login Page----
	@FindBy(id = "username")
	public WebElement txtUsername;

	@FindBy(id = "password")
	public WebElement txtPassword;

	@FindBy(id = "showPasswordIcon")
	public WebElement iconShowPassword;
	
	@FindBy(className = "login-button")
	public WebElement btnLogin;

	@FindBy(id = "Sample")
	public WebElement btnLoginWithgmail;

	@FindBy(className = "loginBtn--facebook")
	public WebElement btnLoginWithFB;

	@FindBy(id = "button")
	public WebElement btnDontHaveAnAccountYet;

	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	public WebElement linkForgotPassword;
	
	@FindBy(id = "toast-container")
	public WebElement toast;

	//	---- Sign up Page ----
	@FindBy(id = "email")
	public WebElement txtEmailForSignup;

	@FindBy(id = "password")
	public WebElement txtPasswordForSignup;

	@FindBy(id = "confirmPassword")
	public WebElement txtConfirmPasswordForSignup;

	@FindBy(id = "firstName")
	public WebElement txtFirstNameForSignup;

	@FindBy(id = "lastName")
	public WebElement txtLastNameForSignup;

	@FindBy(className = "icon-mydpcalendar")
	public WebElement calDobForSignup;

	@FindBy(id = "gender")
	public WebElement ddGenderForSignup;

	@FindBy(id = "profession")
	public WebElement ddProfessionForSignup;

	@FindBy(id = "phoneNumber")
	public WebElement txtPhoneForSignup;
	
	@FindBy(name = "registerTnC")
	public WebElement checkboxTnCForSignup;	
	
	@FindBy(xpath = "//*[contains(text(),'Sign Up')]")
	public WebElement btnSignup;
	
	@FindBy(className = "login-button")
	public WebElement btnBackToLogin;
	
	//	---- Sign up Page - Already registered User dialog ----
	@FindBy(xpath = "//div[@id='alreadyRegisteredModal']//h4")
	public WebElement dialogMsg;
	
	@FindBy(xpath = "//div[@id='alreadyRegisteredModal']//button[contains(text(),'OK')]")
	public WebElement btnOk;
	
	//	---- Sign up Page - New registered User dialog ----
	@FindBy(id = "otp")
	public WebElement txtOTP;
	
	@FindBy(xpath = "//button[contains(text(),'Confirm')]")
	public WebElement btnCnfrm;
	
	@FindBy(xpath = "//button[contains(text(),'Resend OTP')]")
	public WebElement btnResendOTP;
	
	//	---- Sign up Page - Successful Registration Confirmation Dialog ----
	@FindBy(xpath = "//div[@id='successfulRegistrationModal']//h4")
	public WebElement txtHeader;
	
	@FindBy(xpath = "//div[@id='successfulRegistrationModal']//button[contains(text(),'OK')]")
	public WebElement btnRegistrationSuccessfulOK;
	
	//	---- Forget Password Pop up ----
	@FindBy(id = "email")
	public WebElement txtEmail;
	
	@FindBy(id = "confirm")
	public WebElement btnSubmit;

	@FindBy(xpath = "//div[@class='modal-body']/span")
	public WebElement msgError;
	
	@FindBy(xpath = "//span[contains(text(),'×')]")
	public WebElement iconClose;
	
	//	---- Already Logged in Pop up ----
	@FindBy(id = "alreadyloggedin")
	public WebElement Alreadyloggedin;
	
	@FindBy(id = "confirmLogin")
	public WebElement btnOkConfirmLogin;

	public String getErrorMsgForForgotPassword() {
		String Msg = msgError.getText();
		return Msg;
	}

	public String getToastMsg() {
		return toast.getText();
	}

	public String getAlreadyRegisteredUserDialogMsg() {
		return dialogMsg.getText();
	}

	@FindBy(xpath = "//*[contains(text(),'Please register first')]")
	public WebElement registerfirst;

	public final String registerfirst() {
		String Msgg = registerfirst.getText();
		return Msgg;
	}
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	//	--------------------------------- Methods --------------------------------
	
	//	---- Fetching OTP from mailinator mailbox ----
	public String fetchOTP(String userName) {
		WebDriver driverOTP = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers\\chromedriver.exe");
		driverOTP.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driverOTP.manage().window().maximize();
		driverOTP.get("https://www.mailinator.com/");
		driverOTP.findElement(By.xpath("//input[@id='inboxfield']")).sendKeys(userName);;
		driverOTP.findElement(By.xpath("//button[contains(text(),'Go!')]")).click();
		driverOTP.findElement(By.xpath("(//td[contains(text(),'Activate your account')])[1]")).click();
		driverOTP.switchTo().frame("msg_body");
		String otp = driverOTP.findElement(By.xpath("//div//span[contains(text(),'Please find the code to activate your account below.')]//following::div")).getText();
		driverOTP.quit();
		return otp;
	}

	//	---- Login in EduThrill Webapp ----
	public void login(String userName, String password) {
		txtUsername.sendKeys(userName);
		txtPassword.sendKeys(password);
		iconShowPassword.click();
		btnLogin.click();
	}
	
	//	---- Sign up a new user ----
	public void signup(String email, String password, String confirmpassword, String firstname, String lastname,
			String phonenumber) throws InterruptedException {
		btnDontHaveAnAccountYet.click();
		txtEmailForSignup.sendKeys(email);
		txtPasswordForSignup.sendKeys(password);
		txtConfirmPasswordForSignup.sendKeys(confirmpassword);
		txtFirstNameForSignup.sendKeys(firstname);
		txtLastNameForSignup.sendKeys(lastname);
		calDobForSignup.click();
		Select gender = new Select(ddGenderForSignup);
		gender.selectByVisibleText("Male");
		Select profession = new Select(ddProfessionForSignup);
		profession.selectByVisibleText("Student");
		txtPhoneForSignup.sendKeys(phonenumber);
		checkboxTnCForSignup.click();
		Thread.sleep(3000);
		btnSignup.click();
	}

	//	---- Go back to Login from Sign up screen ----
	public void backToLogin() {
		btnBackToLogin.click();
	}

	// ---- Check if Signup button is disabled in Sign up Screen ----
	public boolean checkSignupBtnIsEnabled() {
		return btnSignup.isEnabled();
	}

	// ---- Forget Password ----
	public void ForgetPassword(String emailID) throws Exception {
		linkForgotPassword.click();
		driver.getWindowHandle();
		txtEmail.clear();
		txtEmail.sendKeys(emailID);
		btnSubmit.click();
		Thread.sleep(3000);
		iconClose.click();
	}

}
