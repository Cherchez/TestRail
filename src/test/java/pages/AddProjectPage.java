package pages;

import dto.Project;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AddProjectPage extends BasePage{
    public static final By PROJECT_NAME = By.id("name");
    public static final By ANNOUNCEMENT = By.id("announcement_display");
    public static final By ANNOUNCEMENT_CHECKBOX = By.id("show_announcement");
    public static final By FOR_ALL_CASES_RADIOBUTTON = By.id("suite_mode_single");
    public static final By ENABLE_TEST_CASE_APPROVALS_CHECKBOX = By.id("case_statuses_enabled");
    public static final By ADD_PROJECT_BUTTON = By.id("accept");


    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening New Project page")
    public AddProjectPage open() {
        log.info("Opening New Project page");
        driver.get(BASE_URL + "admin/projects/add/1");
        return this;
    }
    @Step("Create new project'")
    public void createProject(Project project) {
//        driver.findElement(CREATE_PROJECT_BUTTON).click();
        driver.findElement(PROJECT_NAME).sendKeys(project.getName());
        driver.findElement(ANNOUNCEMENT).sendKeys(project.getAnnouncement());
        driver.findElement(ANNOUNCEMENT_CHECKBOX).click();
        driver.findElement(FOR_ALL_CASES_RADIOBUTTON).click();
        driver.findElement(ENABLE_TEST_CASE_APPROVALS_CHECKBOX).click();
        driver.findElement(ADD_PROJECT_BUTTON).click();
    }
}
