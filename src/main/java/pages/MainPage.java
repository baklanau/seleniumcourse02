package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By signIn = By.xpath("//a[text()='Sign in']");
    private By signUp = By.xpath("//a[text()='Sign up']");
    private By userName = By.xpath("//input[@id='user[login]']");
    private By email = By.xpath("");
    private By password = By.xpath("");
    private By signUpButton = By.xpath("");

}
