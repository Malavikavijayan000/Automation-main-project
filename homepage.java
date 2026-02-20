package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
WebDriver driver;
public LoginPage(WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//input[@name='username']")
private WebElement usernameField;
@FindBy(xpath = "//input[@name='password']")
private WebElement passwordField;
@FindBy(xpath = "//button[@type='submit']")
private WebElement signInButton;
@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
private WebElement errorAlert;
// Actions
public LoginPage enterUsername(String username) {
usernameField.clear();
usernameField.sendKeys(username);
return this;
}
public LoginPage enterPassword(String password) {
passwordField.clear();
passwordField.sendKeys(password);
return this;
}
public HomePage clickSignIn() {
signInButton.click();
return new HomePage(driver);
}
public boolean isErrorAlertDisplayed() {
return errorAlert.isDisplayed();
}
}
