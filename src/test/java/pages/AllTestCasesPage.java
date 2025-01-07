package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2
public class AllTestCasesPage extends BasePage {
    public static final By ADD_TEST_CASE_BUTTON = By.id("sidebar-cases-add");
    public static final By SELECT_ALL_CHECKBOX = By.xpath("//*[@onclick='App.Cases.onToggleAllClick(this)']");
    public static final By DELETE_CASES_BUTTON = By.id("deleteCases");
    public static final By DELETE_PERMANENTLY_BUTTON = By.xpath("//*[contains(@class, 'button button-left button-positive button-no-margin-right dialog-action-secondary button-black')]");
    public static final By DELETE_PERMANENTLY_CONFIRM_BUTTON = By.xpath("//*[@id='casesDeletionConfirmationDialog']/div[3]/div/a[1]");
    public static final By ADD_PROJECT_BUTTON = By.id("accept");


    public AllTestCasesPage(WebDriver driver) {
        super(driver);
    }
    @Step("Open 'All Test Cases' page")
    public AllTestCasesPage open() {
        driver.get(BASE_URL + "/suites/view/5&group_by=cases:section_id&group_order=asc&display_deleted_cases=0&group_id=2");
        return this;
    }
    @Step("Delete all cases")
    public void DeleteAllTestCases () {
        log.info("Delete all cases done");
        driver.findElement(SELECT_ALL_CHECKBOX).click();
        driver.findElement(DELETE_CASES_BUTTON).click();
        driver.findElement(DELETE_PERMANENTLY_BUTTON).click();
        driver.findElement(DELETE_PERMANENTLY_CONFIRM_BUTTON).click();
    }
}
