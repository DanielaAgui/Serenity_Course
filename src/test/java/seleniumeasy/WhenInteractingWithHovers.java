package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.actions.FormPage;
import seleniumeasy.actions.NavigateActions;
import seleniumeasy.pageobjects.HoverPage;

@RunWith(SerenityRunner.class)
public class WhenInteractingWithHovers {

    @Managed
    WebDriver driver;

    @Steps
    NavigateActions navigate;

    HoverPage hoverPage;

    @Test
    public void hover() {
        //Abrimos la URL
        navigate.to(FormPage.HoverPage);
        //Nos movemos al elemento
        hoverPage.hoverOverFigure(1);
        //El texto aparecido debería ser visible
        hoverPage.captionForFigure(1).shouldBeVisible();
        //El texto aparecido debería contener un texto
        hoverPage.captionForFigure(1).shouldContainText("user1");
    }
}
