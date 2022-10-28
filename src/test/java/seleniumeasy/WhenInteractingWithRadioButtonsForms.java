package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.actions.FormPage;
import seleniumeasy.actions.NavigateActions;
import seleniumeasy.pageobjects.MultipleRadioButtonsForm;
import seleniumeasy.pageobjects.RadioButtonsForm;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenInteractingWithRadioButtonsForms {

    @Managed
    WebDriver driver;

    @Steps
    NavigateActions navigate;

    RadioButtonsForm radioButtonsForm;

    @Test
    public void singleRadioButton() {
        //Abrimos la URL
        navigate.to(FormPage.RadioButtonsForm);
        //Seleccionamos el radiobutton según el argumento
        radioButtonsForm.selectOption("Male");
        //Damos clic en el botón
        radioButtonsForm.getCheckedValue();
        //Verificamos que el texto sea correcto
        assertThat(radioButtonsForm.getResult()).isEqualTo("Radio button 'Male' is checked");
    }

    MultipleRadioButtonsForm multipleRadioButtonsForm;
    @Test
    public void multipleRadioButtons() {
        //Abrimos la URL
        navigate.to(FormPage.MultipleRadioButtonsForm);
        //Seleccionamos el radiobutton del género
        multipleRadioButtonsForm.selectGender("Female");
        //Seleccionamos el radiobutton de la edad
        multipleRadioButtonsForm.selectAgeGroup("15 - 50");
        //Damos clic en el botón
        multipleRadioButtonsForm.getValues();
        //Verificamos que el resultado contenga ambos textos esperados
        assertThat(multipleRadioButtonsForm.getResult())
                .contains("Sex : Female")
                .contains("Age group: 15 - 50");

    }
}
