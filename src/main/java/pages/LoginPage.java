package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//input[@id='login_field']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@type='submit']");
    private By header = By.xpath("//div/h1");
    private By createAccountLink = By.xpath("//a[text()='Create an account']");
    private By error = By.xpath("//div[@class='container']");


    public LoginPage typeUserName(String userName){
        driver.findElement(loginField).sendKeys(userName);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage loginWithInvalidCreds(String userName, String password) {
        this.typeUserName(userName);
        this.typePassword(password);
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    public String getHeaderText(){
        return driver.findElement(header).getText();
    }

    public String getErrorText() {
        return driver.findElement(error).getText();
    }

    public SignUpPage clickCreateAccount() {
        driver.findElement(createAccountLink).click();
        return new SignUpPage(driver);
    }


}
