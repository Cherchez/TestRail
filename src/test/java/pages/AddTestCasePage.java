package pages;

import dto.TestCase;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Dropdown;
import wrappers.Input;

import static org.testng.AssertJUnit.assertEquals;


@Log4j2
public class AddTestCasePage extends BasePage {


    public static final By ADD_TEST_CASE = By.id("sidebar-cases-add");
    public static final By ADD_TEST_BUTTON = By.id("accept");
    public static final By caseTitle = By.xpath("//label[text()='Title\t\t']//..//input");

    public AddTestCasePage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening page for create test case")
    public void openAddTestCase() {
        driver.get(BASE_URL + "/suites/view/2");
    }

    @Step("Filling in test case's form")
    public AddTestCasePage fillIn(TestCase testCase) {
        driver.findElement(ADD_TEST_CASE).click();
        log.info("Filling in Title {}", testCase.getTitle());
        driver.findElement(caseTitle).clear();
        driver.findElement(caseTitle).sendKeys(testCase.getTitle());
        log.info("Filling in Steps field: {}", testCase.getSteps());
        new Input(driver, "Title").writeInFields(testCase.getTitle());
        new Dropdown(driver, "Section").selectOption(testCase.getSection());
        new Dropdown(driver, "Template").selectOption(testCase.getTemplate());
        new Dropdown(driver, "Type").selectOption(testCase.getType());
        new Dropdown(driver, "Priority").selectOption(testCase.getPriority());
        new Input(driver, "Estimate").writeInFields(testCase.getEstimate());
        driver.findElement(By.id("refs")).sendKeys(testCase.getReferences());
        new Dropdown(driver, "Automation Type").selectOption(testCase.getAutomationType());
        driver.findElement(By.id("custom_preconds_display")).sendKeys(testCase.getPreconditions());
        driver.findElement(By.id("custom_steps_display")).sendKeys(testCase.getSteps());
        driver.findElement(By.id("custom_expected_display")).sendKeys(testCase.getExpectedResult());
        return this;
    }
        @Step("Saving new test case")
        public void save () {
            log.info("Saving new test case");
            driver.findElement(ADD_TEST_BUTTON).click();
            String actualError = driver.findElement(By.xpath("//*[text()='Successfully added the new test case. ']")).getText();
            assertEquals("Wrong error message", "Successfully added the new test case. Add another", actualError);
        }
}



