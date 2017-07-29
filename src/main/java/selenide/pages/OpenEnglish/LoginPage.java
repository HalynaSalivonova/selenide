package selenide.pages.OpenEnglish;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private SelenideElement continueButton = $(By.xpath(".//*[@class='black-btn migration-continue-btn']"));
    private SelenideElement loginField = $(By.xpath(".//*[@id='username']"));
    private SelenideElement passwordField = $(By.xpath(".//*[@id='password']"));
    private SelenideElement loginButton = $(By.xpath(".//*[@id='login-btn']"));
    private SelenideElement loginValidation = $(By.xpath(".//*[@class='tooltipster-content']"));
    private SelenideElement passwordValidation = $(By.xpath(".//*[@class='tooltipster-arrow-right tooltipster-arrow']"));
    private SelenideElement captchaField = $(By.xpath(".//*[@id='captcharesponse']"));

    public LoginPage clickContinueButton(){
        continueButton.click();
        return this;
    }

    public LoginPage setLogin(String login){
        loginField.sendKeys(login);
        return this;
    }

    public LoginPage setPassword(String password){
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton(){
        loginButton.click();
        return this;
    }

    public String getLoginErrorMessage(){
        return loginValidation.getText();
    }

    public String getPasswordErrorMessage(){
        return passwordValidation.getText();
    }

    public boolean isCaptchaDisplayed(){
        return captchaField.isDisplayed();
    }

    public void setCaptcha(String captcha){
        captchaField.sendKeys();
    }
}
