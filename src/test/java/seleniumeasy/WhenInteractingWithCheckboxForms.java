package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.actions.FormPage;
import seleniumeasy.actions.NavigateActions;
import seleniumeasy.pageobjects.CheckboxForm;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenInteractingWithCheckboxForms {

    @Managed
    WebDriver driver;

    @Steps
    NavigateActions navigate;

    CheckboxForm checkboxForm;

    @Test
    public void singleCheckbox() {
        //Abrimos URL
        navigate.to(FormPage.CheckboxForm);
        //Damos clic en el checkbox
        checkboxForm.setAgeSelected();
        //Verificamos que el texto sea correcto
        assertThat(checkboxForm.ageText()).isEqualTo("Success - Check box is checked");
    }

    private static final List<String> ALL_THE_OPTIONS = asList("Option 1", "Option 2", "Option 3", "Option 4");
    @Test
    public void multipleCheckboxes() {
        //Abrimos URL
        navigate.to(FormPage.CheckboxForm);
        //Verificamos que las casillas no estén seleccionadas
        assertThat(ALL_THE_OPTIONS).allMatch(
                option -> !checkboxForm.optionIsCheckedFor(option)
        );
        /*También se puede hacer un assertion con cada una de las opciones
        assertThat(checkboxForm.optionIsCheckedFor("Option 2")).isFalse();*/

        //Damos clic en el botón
        checkboxForm.checkAll();
        //Verificamos que todas las casillas estén seleccionadas
        assertThat(ALL_THE_OPTIONS).allMatch(
                option -> checkboxForm.optionIsCheckedFor(option)
        );
        /*También se puede hacer un assertion con cada una de las opciones
        assertThat(checkboxForm.optionIsCheckedFor("Option 1")).isTrue();*/
    }
}
