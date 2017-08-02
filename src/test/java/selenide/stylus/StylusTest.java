package selenide.stylus;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import selenide.core.SelenideTestBase;
import selenide.pages.Stylus.StylusMainPage;
import selenide.pages.Stylus.StylusSearchResultPage;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static junit.framework.TestCase.assertTrue;

public class StylusTest extends SelenideTestBase{
    private String stylusLink = "https://stylus.ua/";
    private String targetUrl = "https://stylus.ua/aksessuary-dlya-planshetnyh-pk/sony-style-cover-stand-white-scr12roww-for-sony-xperia-z2-tablet.html";
    private String searchText = "Sony Xperia Z2";
    private WebDriver webDriver;
//without POP
    @Test
    public void stylusTest() {
//        System.setProperty("webdriver.chrome.driver",
//                "/home/mykhailo/Downloads/chromedriver");

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.get(stylusLink);

        By searchLocator = By.name("q");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();

        By textLocator = By.xpath(".//span[contains(text(),'Sony Xperia Z2')]");
        WebElement text = webDriver.findElement(textLocator);
        assertTrue(text.getText().contains(searchText));
        text.click();

        Assert.assertEquals(targetUrl, webDriver.getCurrentUrl());
        webDriver.quit();
    }

    @Test
    public void stylusObjectPatternTest() {
        open(stylusLink);
        StylusMainPage stylusMainPage = new StylusMainPage();
        stylusMainPage.searchFor(searchText);
        WebDriverRunner.getWebDriver().getCurrentUrl().contains(targetUrl);
        StylusSearchResultPage stylusResult = new StylusSearchResultPage();
        stylusResult.getLinksResults()
                .first()
                .shouldHave(text("Sony Xperia Z2"));
    }
}
