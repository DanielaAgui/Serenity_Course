package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.AlertMessagePage;
import seleniumeasy.pageobjects.DynamicDataPage;
import seleniumeasy.pageobjects.ModalDialogPage;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenWaitingForElements {

    @Managed (driver = "chrome")
    WebDriver driver;

    ModalDialogPage modalDialogPage;

    @Test
    public void waitingForAModalDialog() {
        //Abrimos la URL
        modalDialogPage.open();
        //Verificamos que el botón no esté visible
        //El elemento espera antes de continuar el método, podemo establecer el tiempo poniendolo en 'serenity.conf'
        modalDialogPage.saveChangesButton().shouldNotBeVisible();
        //Abrimos el modal
        modalDialogPage.openModal();
        //Verificamos que el botón esté visible
        modalDialogPage.saveChangesButton().shouldBeVisible();
        //Cerramos el modal
        modalDialogPage.saveChangesAction();
        //Verificamos que el botón no esté visible
        modalDialogPage.saveChangesButton().shouldNotBeVisible();
    }

    AlertMessagePage alertMessagePage;

    @Test
    public void waitingForAMessageToClose() {
        //Abrimos la URL
        alertMessagePage.open();
        //Damos clic en el botón para abrir el mensaje
        alertMessagePage.openSuccessMessage();
        //Verificamos que el mensaje esté correcto
        assertThat(alertMessagePage.alertSuccessMessageText()).contains("I'm an autocloseable success message.");
        //Esperamos a que el elemento desaparezca
        alertMessagePage.waitForMessageToDissappear();
        //Verificamos que el elemento no esté visible
        alertMessagePage.alertSuccessMessage().shouldNotBeVisible();
    }

    DynamicDataPage dynamicDataPage;

    @Test
    public void waitingForElementsToAppear() {
        //Abrimos la URL
        dynamicDataPage.open();
        //Damos clic en el botón
        dynamicDataPage.getNewUser();
        //Verificamos que aparezcan los textos
        assertThat(dynamicDataPage.userDescription())
                .contains("First Name")
                .contains("Last Name");
    }
}
