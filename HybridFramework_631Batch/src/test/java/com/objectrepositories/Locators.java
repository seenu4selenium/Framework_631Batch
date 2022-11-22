package com.objectrepositories;

import org.openqa.selenium.By;

public class Locators {
	// public final By PageName_WebElmentName_Type = By.LocatorName("LocatorValue");
	public final By FBLogin_Email_EditBox = By.name("email");
	public final By FBLogin_Password_EditBox = By.name("pass");
	public final By FBLogin_Login_Button = By.name("login");
	public final By FBLogin_ForgotPassword_Link = By.linkText("Forgot password?");

	// JRI Application Locators
	public final By jre_SignUp_Name = By.xpath("//*[@id='signup_name']");
	public final By jre_SignUp_MobileNo = By.xpath("//*[@id='signup_mobileno']");
	public final By jre_SignUp_Email = By.xpath("//*[@id='signup_email']");
	public final By jre_SignUp_Password = By.xpath("//*[@id=\'signup_password\']");
	public final By jre_SignUp_ReadCheckbox = By.xpath("//*[@id='checkbox']");
	public final By jre_SignUp_CreateAccount_Button = By.xpath(" //*[@id='imgbtnSubmit']");
	public final By jre_LogInId = By.id("txtUserName");
	public final By jre_LogInPassowrd = By.id("txtPasswd");
	public final By jre_EnterCaptcha = By.id("txtCaptcha");
	public final By jre_SecureSignInButton = By.id("imgbtnSignin");
	public final By jre_AddMobileNumberManu = By.className("addMobileLink");
	public final By jre_AddMobileNumber = By.name("txtpopMobileNo");
	public final By jre_ServiceProvider = By.name("ddlpopMobileSP");
	public final By jre_Nickname = By.name("txtpopMobileNickname");
	public final By jre_Location = By.xpath("//*[@id='ddlpopMobileLocation']");
	public final By jre_AddNumberButton = By.xpath("//*[@id='btnPopupAddMobile']");
	public final By jre_line8MobileNumber = By.xpath("//*[@id='listingtable_btnGridDelete_8']");
	public final By jre_line7MobileNumber = By.xpath("//*[@id='listingtable_btnGridDelete_7']");

}
