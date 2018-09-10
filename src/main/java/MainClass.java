import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.MainPage;

public class MainClass {

    static WebDriver driver;
    public static void main(String[] args) {
        //WebDriver driver;

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

        driver.get("http://github.com");

        //MainPage mainPage = new MainPage(driver);

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

        mainPage.register("testUserName", "testEmail@email.org", "testPassword");

        driver.quit();
    }
}
