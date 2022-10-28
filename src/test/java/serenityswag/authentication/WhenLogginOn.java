package serenityswag.authentication;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.inventory.InventoryPage;

import static org.assertj.core.api.Assertions.assertThat;

//Establece con qué se van a ejecutar las pruebas
@RunWith(SerenityRunner.class)
//Heredamos de UIInteractionSteps: clase diseñada para interactuar con una aplicación a través de la interfaz de usuario
public class WhenLogginOn extends UIInteractionSteps {

    //Creamos una instancia del driver a usar
    @Managed
    WebDriver driver;

    //Creamos una variable de la clase con los pasos a ejecutar
    @Steps
    LoginActions login;

    InventoryPage inventoryPage;

    @Test
    public void usersCanLogOnViaTheHomePage() {
        //Llamamos al método de clase de los pasos con sus argumentos
        login.as(User.STANDARD_USER);

        //Para que en el reporte aparezcan las verificaciones, usamos el método 'reportThat()'
        //Ponemos un mensaje de descripción y la verificación como función lambda
        Serenity.reportThat("The inventory page should be displayed",
                () -> assertThat(inventoryPage.getHeading()).isEqualToIgnoringCase("Products"));
    }
}
