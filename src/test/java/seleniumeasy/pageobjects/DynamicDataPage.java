package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

@DefaultUrl("https://demo.seleniumeasy.com/dynamic-data-loading-demo.html")
public class DynamicDataPage extends SeleniumEasyForm {

    private static final By USER_DETAILS = By.id("loading");

    public String userDescription() {
        return $(USER_DETAILS).getText();
    }

    public void getNewUser() {
        //Damos clic en el botón
        $(FormButton.withLabel("Get New User")).click();
        //Despúes de dar clic en el botón esperamos que el elemento con un texto específico no sea visible
        withTimeoutOf(Duration.ofSeconds(30)).waitFor(ExpectedConditions.invisibilityOfElementWithText(USER_DETAILS, "loading..."));

        /*Podemos usar el 'waitFor' sin tiempo y ponerlo en una 'fluentwait'
        waitFor(ExpectedConditions.);*/
    }
}
