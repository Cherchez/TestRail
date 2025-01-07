package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class AllProjectsPage extends BasePage {
//    public static final By CREATE_PROJECT_BUTTON = By.id("sidebar-projects-add");


    public AllProjectsPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open 'All Project' page")
    public AllProjectsPage open() {
        driver.get(BASE_URL + "/dashboard");
        return this;
    }

    @Step("Check that All Projects Page was opened")
    public boolean isAllProjectsPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content_container")));
        } catch (Exception exception) {
            exception.printStackTrace();
            Assert.fail("AllProjectsPage was not opened");
            log.error(exception.getMessage());
        }
        return true;
    }
}
