import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.SignUpPage;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {
    private WebDriver driver;
    private SignUpPage signUpPage;

    @Before
    public void setUo() {
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


        driver.get("http://github.com/join");

        //mainPage = new MainPage(driver);
        signUpPage = PageFactory.initElements(driver, SignUpPage.class);
    }

    @Test
    public void signUpWithShortPassAfterClickSignUpButton() {
        signUpPage.typePassword("qwe");
        SignUpPage sp = signUpPage.clickSignUpButton();
        String error = sp.getPasswrodErrorText();
        Assert.assertEquals("Password is too short (minimum is 7 characters) and has been compromised in a third party data breach"
                , error);
    }

    @Test
    public void signUpReservedUserNameAfterClickSignUpButtonTest() {
        signUpPage.typeUserName("username");
        SignUpPage sp = signUpPage.clickSignUpButton();
        String error = sp.getUsernameErrorText();
        Assert.assertEquals("Error messages are not equals", "Login name 'username' is a reserved word"
                , error);
    }

    @Test
    public void signUpTakenUserNameAfterClickSignUpButtonTest() {
        signUpPage.typeUserName("user");
        SignUpPage sp = signUpPage.clickSignUpButton();
        String error = sp.getUsernameErrorText();
        Assert.assertEquals("Error messages are not equals", "Login is already taken"
                , error);
    }

    @Test
    public void getHeaderTest() {
        String header = signUpPage.getHeaderText();
        Assert.assertEquals("Headers are different"
                , "Join GitHub", header);
    }



    @After
    public void tearDown() {
        driver.quit();
    }

}
