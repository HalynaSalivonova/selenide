package selenide.core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import static com.codeborne.selenide.WebDriverRunner.CHROME;
import static selenide.util.PropertiesCache.getProperty;

@Listeners({TestListener.class})

public class SelenideTestBase {

    private String browser = System.getProperty("browser", CHROME);

    @BeforeClass
    public void setUp() {
        switch (browser){
            case WebDriverRunner.CHROME:
                ChromeDriverManager.getInstance().setup();
                break;
            case WebDriverRunner.FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                break;
            case WebDriverRunner.INTERNET_EXPLORER:
                InternetExplorerDriverManager.getInstance().setup();
                break;
        }
        Configuration.browser= browser;
        ChromeDriverManager.getInstance().setup();
        Configuration.browser = WebDriverRunner.CHROME;
        // если упадёт тест, браузер не закроется
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = Long.parseLong(getProperty("timeout"));
    }
}
