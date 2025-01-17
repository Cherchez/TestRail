package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class LoginPage extends BasePage {


    public static final By EMAIL_INPUT = By.id("name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By SIGN_IN_BUTTON = By.cssSelector("[id=button_primary]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    @Step("Opening login page")
    public LoginPage open() {
        log.info("Opening login page");
        driver.get(BASE_URL + "/auth/login/");
        return this;
    }

    @Step("Login by user '{user}'")
    public void login(String user, String password) {
        log.info("Login by user:{}, {}", user, password);
        driver.findElement(EMAIL_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(SIGN_IN_BUTTON).click();
    }
}

