package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.TestListener;

import static org.testng.AssertJUnit.assertEquals;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @Test(description = "Check if user can log in")
    public void successfulLogin() {
        loginPage.open();
        loginPage.login(user, password);
        String myAccount = driver.findElement(By.cssSelector("[data-testid='testCaseContentHeaderTitle']")).getText();
        assertEquals("Пользователь не залогинен", "All Projects", myAccount);
    }

    @Test
    public void IncorrectEmail() {
        loginPage.open();
        loginPage.login("Cherreer@mail.ru", password);
        String actualError = driver.findElement(By.xpath("//*[contains(text(), 'Email/Login or Password is incorrect. Please try again.')]")).getText();
        assertEquals("Wrong error message", "Email/Login or Password is incorrect. Please try again.", actualError);
    }

    @Test
    public void IncorrectPassword() {
        loginPage.open();
        loginPage.login(user, "33333333333");
        String actualError = driver.findElement(By.xpath("//*[@class='error-text']")).getText();
        assertEquals("Wrong error message", "Email/Login or Password is incorrect. Please try again.", actualError);
    }

    @Test(description = "Email should be required")
    public void emailIsRequired() {
        loginPage.open();
        loginPage.login("", "");
        String passwordError = driver.findElement(By.xpath("//*[@id='content']/form/div[3]")).getText();
        assertEquals("Wrong error message", "Email/Login is required.", passwordError);
        String actualError = driver.findElement(By.xpath("//*[@id='content']//div//div//div")).getText();
        assertEquals("Wrong error message", "Password is required.", actualError);
        //div [class*="loginpage-message"]
    }

    @Test
    public void invalidEmailAddress() {
        loginPage.open();
        loginPage.login("q", "q");
        String actualError = driver.findElement(By.xpath("//*[@id='content']//div//div//div")).getText();
        assertEquals("Wrong error message", "Password is too short (5 characters required).", actualError);
    }

    @Test(description = "Password should be required")
    public void passwordIsRequired() {
        loginPage.open();
        loginPage.login(user, "");
        String actualError = driver.findElement(By.xpath("//*[@id='content']//div//div//div")).getText();
        assertEquals("Wrong error message", "Password is required.", actualError);
  }
}

