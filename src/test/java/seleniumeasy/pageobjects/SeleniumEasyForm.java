package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class SeleniumEasyForm extends PageObject {

    //Localizamos el ícono de cierre del pop-up
    private static final By POPUP_WINDOW_CLOSE_ICON = By.cssSelector("a[title='Close']");

    //Anotación para indicar que el método se ejcuta cuando se abre la página
    @WhenPageOpens
    public void clearPopupWindow() {
        //Si el ícono está presente
        if ($(POPUP_WINDOW_CLOSE_ICON).isPresent()) {
            //Entonces espera hasta que esté visible y le da clic
            waitFor(visibilityOfElementLocated(POPUP_WINDOW_CLOSE_ICON)).click();
            //Y luego espera que no esté visible
            waitFor(invisibilityOfElementLocated(POPUP_WINDOW_CLOSE_ICON));
        }
    }
}
