package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.WebElementState;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html")
public class AlertMessagePage extends UIInteractionSteps {

    private final static By ALERT_SUCCESS_MESSAGE = By.cssSelector(".alert-autocloseable-success");

    public void openSuccessMessage() {
        $("#autoclosable-btn-success").click();
    }

    public String alertSuccessMessageText() {
        return $(ALERT_SUCCESS_MESSAGE).getText();
    }

    public void waitForMessageToDissappear() {
        //Las esperas se utilizan con 'fluentwait' en la configuración para dar más tiempo, lo predeterminado son 5 segundos
        waitForRenderedElementsToDisappear(ALERT_SUCCESS_MESSAGE);
    }

    public WebElementState alertSuccessMessage() {
        return $(ALERT_SUCCESS_MESSAGE);
    }
}
