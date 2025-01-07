package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class AddTestPlanPage extends BasePage {
    public static final By CONFIRM_ADD_TEST_PLAN_BUTTON = By.id("accept");

    public AddTestPlanPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open 'Add Test Plan' page")
    public AddTestPlanPage open() {
        driver.get(BASE_URL + "/index.php?/plans/add/5");
        return this;
    }
    @Step("Create a new Test plan")
    public void addTestPlan() {
        log.info("Create a new Test plan with some name and description");
        driver.findElement(By.id("name")).sendKeys("Demo Test Plan");
        driver.findElement(By.id("description_display")).sendKeys("Vika and Lexa my loves");
        driver.findElement(CONFIRM_ADD_TEST_PLAN_BUTTON).click();
    }
}