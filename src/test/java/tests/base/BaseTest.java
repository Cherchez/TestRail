package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.PropertyReader;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    public WebDriver driver;
    protected LoginPage loginPage;
    protected AddProjectPage addProjectPage;
    protected AddTestCasePage addTestCasePage;
    protected AddTestPlanPage addTestPlanPage;
    protected AddTestRunPage addTestRunPage;
    protected AllTestCasesPage allTestCasesPage;
    protected AllProjectsPage allProjectsPage;
    protected TestRunsPage testRunsPage;


    protected String user = System.getProperty("user", PropertyReader.getProperty("user"));
    protected String password = System.getProperty("password", PropertyReader.getProperty("password"));

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
//            options.addArguments("--headless");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
        } else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless");
            options.addArguments("--start-maximized");
            driver = new EdgeDriver(options);
        }
        testContext.setAttribute("driver", driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        addTestCasePage = new AddTestCasePage(driver);
        addProjectPage = new AddProjectPage(driver);
        addTestRunPage = new AddTestRunPage(driver);
        allTestCasesPage = new AllTestCasesPage(driver);
        allProjectsPage = new AllProjectsPage(driver);
        testRunsPage = new TestRunsPage(driver);
        addTestPlanPage = new AddTestPlanPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
