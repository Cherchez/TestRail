package tests;

import dto.Project;
import dto.ProjectFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.AllProjectsPage;
import tests.base.BaseTest;

import static org.testng.AssertJUnit.assertEquals;

public class ProjectTest extends BaseTest {

    @Test(description = "Create new project")
    public void createNewProject() {
//        Project project = ProjectFactory.getRandom();
//        loginPage.open();
//        loginPage.login(user, password);
//        String myAccount = driver.findElement(By.cssSelector("[data-testid='testCaseContentHeaderTitle']")).getText();
//        assertEquals("Пользователь не залогинен", "All Projects", myAccount);
//        addProjectPage.open();
//        addProjectPage.createProject(project);
//        String myProject = driver.findElement(By.xpath("//*[@class='message message-success']")).getText();
//        assertEquals("Project wasn't create", "Successfully added the new project.", myProject);
    }
}
