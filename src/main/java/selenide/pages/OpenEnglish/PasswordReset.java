package selenide.pages.OpenEnglish;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class PasswordReset {
    private SelenideElement continueButton = $(By.xpath(".//*[@class='black-btn migration-continue-btn']"));
    private SelenideElement passwordResetButton = $(By.xpath(".//*[@href='recovery.html']"));

    public void passResetButton(){
        passwordResetButton.click();
    }

    public void clickContinueButton(){
        continueButton.click();
    }
}
