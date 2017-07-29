package selenide.google;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import selenide.core.SelenideTestBase;
import selenide.pages.Google.GoogleSearchPage;
import selenide.pages.Google.GoogleSearchResultPage;
import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@Features("Google search")
@Stories({"WEB-100500"})
public class GoogleTest extends SelenideTestBase {
    private String google = "https://www.google.com/ncr";
    private String searchText = "selenide";
//without incapsulation and POP
    @Test
    public void searchInGoogleTest() {
//        утсановка драйвера для определённого драйвера браузера
//        ChromeDriverManager.getInstance().version("2.30").setup();

//        утсановка драйвера для последней верссии драйвера браузера
//        ChromeDriverManager.getInstance().setup();

//        Configuration.timeout = 6000L;

//        зарань тесты на хром браузере
//        Configuration.browser = WebDriverRunner.CHROME;
//        открыть линк
        open(google);

//        By serachLocator = By.name("q"); or
        $(By.name("q")).val(searchText).pressEnter();
        $$(By.xpath("//*[@class='rc']")).shouldHave(size(10));
        $(By.xpath("//*[@class='rc']")).shouldBe(visible).shouldHave(
                text("Selenide: concise UI tests in Java"),
                text("selenide.org"));
    }
//with POP and incapsulation
    @Title("Perform search via google")
    @Test
    public void searchInGoogleWithPageObjectTest() {
        open(google);
        GoogleSearchPage googleSearch = new GoogleSearchPage();
        googleSearch.searchFor(searchText);
        GoogleSearchResultPage googleResult = new GoogleSearchResultPage();
        googleResult.getLinksResults()
                .shouldHave(size(10))
                .first()
                .shouldHave(text("Selenide"));
    }
}
