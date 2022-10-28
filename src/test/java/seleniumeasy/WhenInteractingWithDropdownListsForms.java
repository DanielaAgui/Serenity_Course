package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.actions.NavigateActions;
import seleniumeasy.pageobjects.MultiSelectListForm;
import seleniumeasy.pageobjects.SelectListForm;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenInteractingWithDropdownListsForms {

    @Managed
    WebDriver driver;

    @Steps
    NavigateActions navigate;

    SelectListForm selectListForm;

    @Test
    public void selectList() {
        //Abrimos la URL
        navigate.toTheSelectListForm();
        //Verificamos que no haya nada seleccionado
        assertThat(selectListForm.selectedDay()).isEmpty();
        //Seleccionamos un elemento
        selectListForm.selectDay("Wednesday");
        //Verificamos que el elemento seleccionado sea igual a
        assertThat(selectListForm.selectedDay()).isEqualTo("Wednesday");
    }

    MultiSelectListForm multiSelectListForm;

    @Test
    public void multiSelectList() {
        //Abrimos la URL
        navigate.toTheMultiSelectListForm();
        //Verificamos que no haya nada seleccionado
        assertThat(multiSelectListForm.selectedStates()).isEmpty();
        //Seleccionamos los elementos que queremos
        multiSelectListForm.selectStates("Florida", "Ohio", "Texas");
        //Verificamos que los elementos seleccionados sean iguales a
        assertThat(multiSelectListForm.selectedStates()).containsExactly("Florida", "Ohio", "Texas");
    }
}
