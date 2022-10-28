package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.actions.NavigateActions;
import seleniumeasy.pageobjects.SingleInputFieldForm;
import seleniumeasy.pageobjects.TwoInputFieldForm;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenInteractingWithInputForms {

    //Podemos especificar con qué navegador correr los tests
    //Podemos poner el parámetro 'uniqueSession=true' si queremos que se ejecuten todos los test en una sola sesión
    @Managed(driver = "chrome", uniqueSession = true)
    WebDriver driver;

    @Steps
    NavigateActions navigate;

    SingleInputFieldForm singleInputFieldForm;

    @Test
    public void basicForms() {
        //Abrimos la URL establecida
        navigate.toTheSingleInputForm();
        //Escribimos el mensaje
        singleInputFieldForm.enterMessage("Hi there");
        //Mostramos el mensaje
        singleInputFieldForm.showMessage();
        //Verificamos que el mensaje coincida
        assertThat(singleInputFieldForm.displayedMessage()).isEqualTo("Hi there");
    }

    TwoInputFieldForm twoInputFieldForm;

    @Test
    public void basicFormsWithMultipleFields() {
        //Abrimos la URL
        navigate.toTheTwoInputFieldForm();
        //Escribimos el valor A
        twoInputFieldForm.enterA("2");
        //Escribirmos el valor B
        twoInputFieldForm.enterB("3");
        //Obtenemos el total de la suma
        twoInputFieldForm.getTotal();
        //Verificamos que la suma sea correcta
        assertThat(twoInputFieldForm.displayedTotal()).isEqualTo("5");
    }
}
