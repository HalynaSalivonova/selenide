package selenium.TestsWithoutPOP;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Stylus {
    private String stylusSearch = "https://stylus.ua/";
    private String searchText = "Sony Xperia Z2";
    private WebDriver webDriver;

    @Test
    public void searchTest(){
        System.setProperty("webdriver.chrome.driver",
                "/home/mykhailo/Downloads/chromedriver");

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.get(stylusSearch);
        By searchLocator = By.xpath(".//*[@id='head-search']//*[@name='q']");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();

        By searchPhone = By.xpath("//ul[@class='product-grid']//a//*[@class='title']");
        List <WebElement> elements = webDriver.findElements(searchPhone);
        WebElement link;
        for(int i = 0; i < elements.size(); i++){
            System.out.println(elements.get(i).getText());
            if(elements.get(i).getText().contains(searchText)){
                link = elements.get(i);
                link.click();
                break;
            }
        }
        webDriver.close();
    }
}
