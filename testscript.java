package testScript;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.Base;
import pages.HomePage;
import pages.LoginPage;
public class GroceryTest extends Base {
@Test(priority = 1)
public void verifyLoginPageDisplayed() {
LoginPage login = new LoginPage(driver);
Assert.assertTrue(driver.getCurrentUrl().contains("admin"));
}
@Test(priority = 2)
public void verifyLoginFunctionality() {
LoginPage login = new LoginPage(driver);
HomePage home = login.enterUsername("admin")
.enterPassword("admin")
.clickSignIn();
Assert.assertTrue(home.isDashboardDisplayed());
}
@Test(priority = 3)
public void verifyAdminNameDisplayed() {
LoginPage login = new LoginPage(driver);
HomePage home = login.enterUsername("admin")
.enterPassword("admin")
.clickSignIn();
Assert.assertTrue(home.getAdminName().contains("Admin"));
}
@Test(priority = 4)
public void verifyLogoutFunctionality() {
LoginPage login = new LoginPage(driver);
HomePage home = login.enterUsername("admin")
.enterPassword("admin")
.clickSignIn();
login = home.clickProfileIcon()
.clickLogout();
Assert.assertTrue(driver.getCurrentUrl().contains("login"));
}
}
