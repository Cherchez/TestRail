package pages;

import dto.TestCase;
import dto.TestRun;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Dropdown;
import wrappers.Input;


@Log4j2
public class AddTestRunPage extends BasePage {
    public static final By CONFIRM_ADD_TEST_PLAN_BUTTON = By.id("accept");
    public static final By referencesINPUT = By.id("refs");
    public static final By descriptionDISPLAY = By.id("description_display");
    public static final By SELECT_SPECIFIC_TEST_CASES_RADIO = By.id("includeSpecific");
    public static final By CHANGE_SELECTION_STRING = By.xpath("//*[@id='includeSpecificInfo']/a");
    public static final By SELECT_CASES_CHECKBOX = By.xpath("//*[@class='checkbox-tree']");
    public static final By SELECT_CASES_OK_BUTTON = By.id("selectCasesSubmit");
    public static final By ADD_TEST_RUN_CONFIRM_BUTTON = By.id("accept");
    public static final By ADD_TEST_RUN_BUTTON = By.id("navigation-runs-add");

    public AddTestRunPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open 'Add Test Run' page")
    public AddTestRunPage open() {
        driver.get(BASE_URL + "/index.php?/runs/add/5");
        return this;
    }

    @Step("Create a new Test Run")
    public AddTestRunPage fillIn(TestRun testRun) {
        driver.findElement(ADD_TEST_RUN_BUTTON).click();
        log.info("Create a new Test Run");
        driver.findElement(referencesINPUT).sendKeys(testRun.getReferences());
        new Dropdown(driver, "Assign To").selectOption(testRun.getAssignTo());
        driver.findElement(descriptionDISPLAY).sendKeys(testRun.getDescription());
        driver.findElement(SELECT_SPECIFIC_TEST_CASES_RADIO).click();
        driver.findElement(CHANGE_SELECTION_STRING).click();
        driver.findElement(SELECT_CASES_CHECKBOX).click();
        driver.findElement(SELECT_CASES_OK_BUTTON).click();
        return this;
    }
    @Step("Saving new Test Run")
    public void save () {
        log.info("Saving new Test Run");
        driver.findElement(ADD_TEST_RUN_CONFIRM_BUTTON).click();
    }
}