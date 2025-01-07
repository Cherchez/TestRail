package tests;

import dto.TestCase;
import dto.TestCaseFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.AssertJUnit.assertEquals;

public class CasesTest extends BaseTest {

    @Test
    public void createTestCase() {
        loginPage.open();
        loginPage.login(user, password);
        addTestCasePage.openAddTestCase();
        TestCase randomTest = TestCaseFactory.getRandom();
        addTestCasePage.fillIn(randomTest);
        addTestCasePage.save();
    }

    @Test
    public void deleteTestCases() {
        loginPage.open();
        loginPage.login(user, password);
        allTestCasesPage.open();
        allTestCasesPage.DeleteAllTestCases();
//        Actions actions = new Actions(driver);
//        actions.moveToLocation(225, 315);
//        driver.findElement(By.xpath("//*[@class='icon-small-edit hidden action-hover']")).click();
    }

}
