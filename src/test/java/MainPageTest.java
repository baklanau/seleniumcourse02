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

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        String osName = System.getProperty("os.name");

        System.out.println(osName);

        if (osName.contains("Mac")) {
            System.setProperty("webdriver.chrome.driver"
                    , "/Users/dzb/IdeaProjects/pageobjectselenium/drivers/chromedriver");

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


        driver.get("http://github.com");

        //mainPage = new MainPage(driver);
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @Test
    public void signInTest(){
        LoginPage loginPage = mainPage.clickSignIn();
        String heading = loginPage.getHeaderText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerFailTest(){
        SignUpPage signUpPage = mainPage.register("testuser", "testemail", "testpass");
        String error = signUpPage.getMainErrorText();
        Assert.assertEquals("There were problems creating your account.", error);
    }

    @Test
    public void signUpEmptyUsernameTest(){
        SignUpPage signUpPage = mainPage.register("", "mail", "pass");
        String error = signUpPage.getUsernameErrorText();
        Assert.assertEquals("Login can't be blank", error);
    }

    @Test
    public void signUpInvalidEmailTest(){
        SignUpPage signUpPage = mainPage.register("qeqwe", "qweq", "pass");
        String error = signUpPage.getEmailErrorText();
        Assert.assertEquals("Email is invalid or already taken", error);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
