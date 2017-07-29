package selenide.openenglish;

import com.codeborne.selenide.WebDriverRunner;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;
import selenide.core.SelenideTestBase;
import selenide.pages.OpenEnglish.LoginPage;
import selenide.pages.OpenEnglish.MainPage;
import selenide.pages.OpenEnglish.PasswordReset;

import static com.codeborne.selenide.Selenide.*;

public class OpenEnglishTest extends SelenideTestBase {
    //private String loginScreenLink = "https://learningplatform.stg.openenglish.com/login.html";
    private String loginScreenLink = "https://learningplatform.openenglish.com/login.html";

    private String login = "shiosaky@gmail.com";
    private String password = "Test123";
    private String welcomeScreen = "https://learningplatform.stg.openenglish.com/";
    private String loginValidationMessage = "The email you entered is not recognized. Please try again.";
    private String passwordValidationMessage = "Parece que hay un error en la contraseña. Por favor, inténtelo de nuevo.";
    private String resetScreen = "https://learningplatform.stg.openenglish.com/recovery.html";
    private String mainScreen = "https://learningplatform.stg.openenglish.com/index.html";
//    private String progressScreen = "https://learningplatform.stg.openenglish.com/progress/profile.html";
//    private String feedbackScreen = "https://learningplatform.stg.openenglish.com/progress/teacher-feedback.html";
    @Title("Login with valid data")
    @Test
    public void loginWithValidCredentials() {
        open(loginScreenLink);
        LoginPage loginPage = new LoginPage();
        loginPage.clickContinueButton().setLogin(login).setPassword(password).clickLoginButton();
        sleep(5000);
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), welcomeScreen);
    }

    @Test
    public void C141() {
        open(loginScreenLink);
        LoginPage loginPage = new LoginPage();
        //step 1
        loginPage.clickContinueButton().setLogin("test@test.com").setPassword(password).clickLoginButton();
        Assert.assertEquals(loginPage.getLoginErrorMessage(), loginValidationMessage);
        //step 2
        loginPage.clickContinueButton().setLogin("testtest.com").setPassword(password).clickLoginButton();
        Assert.assertEquals(loginPage.getLoginErrorMessage(), loginValidationMessage);
        //step 3
        loginPage.clickContinueButton().setLogin("testtest@test").setPassword(password).clickLoginButton();
        Assert.assertEquals(loginPage.getLoginErrorMessage(), loginValidationMessage);
    }

    @Test
    public void C142() {
        open(loginScreenLink);
        LoginPage loginPage = new LoginPage();
        //step 1
        loginPage.clickContinueButton().setLogin(login).setPassword("qwerty1234").clickLoginButton();
        Assert.assertEquals(loginPage.getLoginErrorMessage(), passwordValidationMessage);
        //step2
        sleep(10000);
        loginPage.setLogin(login).setPassword("qwerty1234").clickLoginButton();
        sleep(5000);
        Assert.assertTrue(loginPage.isCaptchaDisplayed());
    }

    @Ignore
    // need to work on this case!!!
    public void C145() {
        open(loginScreenLink);
        LoginPage loginPage = new LoginPage();
        //continue from previous scenario of C142
        loginPage.clickContinueButton().setLogin(login).setPassword("qwerty1234").clickLoginButton();
        sleep(5000);
        loginPage.setLogin(login).setPassword("qwerty1234").clickLoginButton();
        sleep(5000);
        Assert.assertTrue(loginPage.isCaptchaDisplayed());
        loginPage.setCaptcha("qqqq");
    }

    @Test
    public void C144() {
        open(loginScreenLink);
        PasswordReset passwordReset = new PasswordReset();
        passwordReset.clickContinueButton();
        passwordReset.passResetButton();
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), resetScreen);
    }

    @Test
    public void C98_99() {
        open(loginScreenLink);
        LoginPage loginPage = new LoginPage();
        loginPage.clickContinueButton().setLogin(login).setPassword(password).clickLoginButton();

        MainPage mainPage = new MainPage();
        mainPage.clickLogoButton();
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), mainScreen);
    }

    @Ignore
    public void C100(){
        open(loginScreenLink);
        LoginPage loginPage = new LoginPage();
        loginPage.clickContinueButton().setLogin(login).setPassword(password).clickLoginButton();
        //Scenario 1
        MainPage mainPage = new MainPage();
        mainPage.hoverProgressTab().clickProfileSubTab();
    }
}