package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By header = By.xpath("//div/h1");
    private By userNameField = By.xpath("//input[@name='user[login]']");
    private By emailField = By.xpath("//input[@name='user[email]']");
    private By passwordField = By.xpath("//input[@name='user[password]']");
    private By signUpButton = By.xpath("//button[@type='submit']");
    private By mainErrorText = By.xpath("//div[@class='flash flash-error my-3']");
    private By userNameErrorText = By.xpath("//dd[contains(text(), 'Login')]");
    private By emailErrorText = By.xpath("//dd[contains(text(), 'Email')]");
    private By passwordErrorText = By.xpath("//dd[contains(text(), 'Password')]");

    public SignUpPage typeUserName(String userName) {
        driver.findElement(userNameField).sendKeys(userName);
        return this;
    }

    public SignUpPage typeEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage typePassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public SignUpPage regiterWithInvalidCreds(String userName, String email, String password) {
        this.typeUserName(userName);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpButton() {
        driver.findElement(signUpButton).submit();
        return new SignUpPage(driver);
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public String getMainErrorText(){
        return driver.findElement(mainErrorText).getText();
    }

    public String getUsernameErrorText(){
        return driver.findElement(userNameErrorText).getText();
    }


    public String getEmailErrorText(){
        return driver.findElement(emailErrorText).getText();
    }

    public String getPasswrodErrorText(){
        return driver.findElement(passwordErrorText).getText();
    }


}
