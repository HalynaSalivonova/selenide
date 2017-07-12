import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Stylus {
    private String googleSearch = "https://stylus.ua/";
    private String searchText = "Sony Z2";
    private WebDriver webDriver;

    @Test
    public void searchTest(){
        System.setProperty("webdriver.chrome.driver",
                "/home/mykhailo/Downloads/chromedriver");

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.get(googleSearch);
        By searchLocator = By.xpath("//*[@id='head-search']");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();

        webDriver.close();
    }
}
