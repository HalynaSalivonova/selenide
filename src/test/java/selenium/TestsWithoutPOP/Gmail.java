package selenium.TestsWithoutPOP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import java.util.concurrent.TimeUnit;


@Features("Gmail login")
@Stories({"WEB-111"})

public class Gmail {
    private String gmailSearch = "https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
    private String login = "halyna.salivonova";
    private String password = "Bothisatvahoma1989";
    private WebDriver webDriver;

    @Test
    public void searchTest() {
        System.setProperty("webdriver.chrome.driver",
                "/home/mykhailo/Downloads/chromedriver");

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.get(gmailSearch);
        
        By searchLocator = By.xpath(".//*[@id='identifierId']");
        WebElement loginField = webDriver.findElement(searchLocator);
        loginField.sendKeys(login);
        By searchButton = By.xpath("//*[@class='RveJvd snByac']");
        WebElement nextButton = webDriver.findElement(searchButton);
        nextButton.click();

        By searchPassLocator = By.xpath("//input[@autocomplete='current-password']");
        WebElement passwordField = webDriver.findElement(searchPassLocator);
        passwordField.sendKeys(password);
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        By searchButton2 = By.xpath("//*[@class='RveJvd snByac']");
        WebElement nextButton2 = webDriver.findElement(searchButton2);
        nextButton2.click();

        By searchMails = By.xpath(".//*[@jsmodel='nXDxbd']");
        WebElement emails = webDriver.findElement(searchMails);
        System.out.println(emails);

        webDriver.close();

    }
}
