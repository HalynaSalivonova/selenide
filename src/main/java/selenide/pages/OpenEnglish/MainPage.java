package selenide.pages.OpenEnglish;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement logoButton = $(By.xpath(".//*[@class='logo']"));
    private SelenideElement progressTab = $(By.xpath(".//*[@id='nav-progress']"));
    private SelenideElement profileSubTab = $(By.xpath(".//*[@id='nav-profile']"));
    private SelenideElement feedbackSubTab = $(By.xpath(".//*[@id='nav-feedback']"));


    public MainPage clickLogoButton(){
        logoButton.click();
        return this;
    }

    public MainPage hoverProgressTab(){
        progressTab.hover();
        return this;
    }

    public MainPage clickProfileSubTab(){
        profileSubTab.click();
        return this;
    }

    public MainPage clickFeedbackSubTab(){
        feedbackSubTab.click();
        return this;
    }
}
