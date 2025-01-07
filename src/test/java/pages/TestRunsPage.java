package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@Log4j2
public class TestRunsPage extends BasePage {
    public static final By ADD_TEST_PLAN_BUTTON = By.id("navigation-plans-add");
    public static final By ADD_TEST_RUN_BUTTON = By.id("navigation-runs-add");

    public TestRunsPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open 'Test Runs' page")
    public TestRunsPage open() {
        driver.get(BASE_URL + "/runs/overview/5");
        return this;
    }

    @Step("Check that the Page was opened")
    public boolean isOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'content-header-title page_title')]")));
        } catch (Exception exception) {
            exception.printStackTrace();
            Assert.fail("Test Runs and Results page was not opened");
            log.error(exception.getMessage());
        }
        return true;
    }
    @Step("Click on Add Test Plan button")
    public void clickAddTestPlan() {
        driver.findElement(ADD_TEST_PLAN_BUTTON).click();
    }
//    @Step("Click on Add Test Plan button")
//    public void clickAddTestRun() {
//        driver.findElement(ADD_TEST_RUN_BUTTON).click();
//    }
}
