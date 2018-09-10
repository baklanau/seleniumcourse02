package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
//
//    private By signIn = By.xpath("//a[text()='Sign in']");
//    private By signUp = By.xpath("//a[text()='Sign up']");
//    private By userNameField = By.xpath("//input[@id='user[login]']");
//    private By emailField = By.xpath("//input[@id='user[email]']");
//    private By passwordField = By.xpath("//input[@id='user[password]']");
//    private By signUpButton = By.xpath("//div/form/button");

    @FindBy(xpath = "//a[text()='Sign in']")
    private WebElement signIn;

    @FindBy(xpath = "//a[text()='Sign up']")
    private WebElement signUp;

    @FindBy(xpath = "//input[@id='user[login]']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@id='user[email]']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='user[password]']")
    private WebElement passwordField;

    @FindBy(xpath = "//div/form/button")
    private WebElement signUpButton;

//    public LoginPage clickSignIn(){
//        driver.findElement(signIn).click();
//        return new LoginPage(driver);
//    }
//
//    public SignUpPage clickSignUp(){
//        driver.findElement(signUp).click();
//        return new SignUpPage(driver);
//    }
//
//    public SignUpPage clickSignUpButton(){
//        driver.findElement(signUpButton).click();
//        return new SignUpPage(driver);
//    }
//
//    public MainPage typeUserName(String userName) {
//        driver.findElement(userNameField).sendKeys(userName);
//        return this;
//    }
//
//    public MainPage typeEmail(String email) {
//        driver.findElement(emailField).sendKeys(email);
//        return this;
//    }
//
//    public MainPage typePassword(String password) {
//        driver.findElement(passwordField).sendKeys(password);
//        return this;
//    }

    public LoginPage clickSignIn(){
        signIn.click();
        return new LoginPage(driver);
    }

    public SignUpPage clickSignUp(){
        signUp.click();
        return new SignUpPage(driver);
    }

    public SignUpPage clickSignUpButton(){
        signUpButton.click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String userName) {
        userNameField.sendKeys(userName);
        return this;
    }

    public MainPage typeEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public MainPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public SignUpPage register(String userName, String email, String password) {
        this.typeUserName(userName);
        this.typeEmail(email);
        this.typePassword(password);
        this.clickSignUpButton();
        return new SignUpPage(driver);
    }

}
