package seleniumeasy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MultiSelectListForm extends SeleniumEasyForm{

    private static final By STATE = By.id("multi-select");

    //Método que devuelve los elementos seleccionados
    //Devuelve una lista ya que pueden ser varias opciones
    public List<String> selectedStates() {
        return $(STATE).getSelectedValues();
    }

    //Método que selecciona un elemento de la lista por valor
    //'String...' para indicar que pueden ser varios parámetros
    public void selectStates(String... states) {
        for(String state : states) {
            $(STATE).select().byValue(state);
        }
    }
}
