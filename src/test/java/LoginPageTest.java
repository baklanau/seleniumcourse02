import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import pages.MainPage;
import pages.SignUpPage;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() {
        String osName = System.getProperty("os.name");

        System.out.println(osName);

        if (osName.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver"
                    , "/Users/dzb/Downloads/chromedriver");

            System.setProperty("selenium.browser", "Chrome");

        } else if (osName.contains("Win")) {
            System.setProperty("phantomjs.binary.path"
                    , "C:\\Users\\Dmitry B\\IdeaProjects\\testselenium\\drivers\\chromedriver.exe");

            System.setProperty("selenium.browser", "Chrome");

        } else {
            System.out.println("Add any drivers for browsers for your OS");
        }

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.get("http://github.com/login");

        //mainPage = new MainPage(driver);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void loginWithEmptyCredsTest(){
        LoginPage newLoginPage =  loginPage.loginWithInvalidCreds("","");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void loginWithIncorrectCredsTest(){
        LoginPage newLoginPage =  loginPage.loginWithInvalidCreds("qweqewqwe","qweqweweqwe");
        String error = newLoginPage.getErrorText();
        Assert.assertEquals("Incorrect username or password.", error);
    }

    @Test
    public void createAccTest(){
        SignUpPage signUpPage = loginPage.clickCreateAccount();
        String heading = signUpPage.getHeaderText();
        Assert.assertEquals("Join GitHub", heading);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
