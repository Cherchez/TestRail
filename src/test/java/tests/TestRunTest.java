package tests.base;

import dto.TestCase;
import dto.TestCaseFactory;
import dto.TestRun;
import dto.TestRunFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.TestRunsPage;

import static org.testng.AssertJUnit.assertEquals;

public class TestRunTest extends BaseTest {
    @Test
    public void createTestRun() {
        loginPage.open();
        loginPage.login(user, password);
        testRunsPage.open();
        TestRun randomTest = TestRunFactory.getRandom();
        addTestRunPage.fillIn(randomTest);
        addTestRunPage.save();
        String actualError = driver.findElement(By.xpath("//*[@class='message message-success']")).getText();
        assertEquals("Wrong error message", "Successfully added the new test run.", actualError);
    }
}
