package seleniumeasy.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

//Clase con los métodos que abren las diferentes URL de los test
public class NavigateActions extends UIInteractionSteps {

    //Método más sencillo y fácil de mantener de abrir todas las URL
    //Llamamos la clase enum de las constantes como un parámetro
    @Step
    public void to(FormPage formPage) {
        //Abrimos la URL según el nombre de la clase que necesitemos
        openPageNamed(formPage.name());
    }

    //Métodos que abren las URL según el nombre dado para cada una en "resources/serenity.conf"
    @Step
    public void toTheSingleInputForm() {
        openPageNamed("singleInputFieldForm");

        /*Podemos usar 'openURL()' para abrir el navegador
        openUrl("https://demo.seleniumeasy.com/basic-first-form-demo.html");*/
    }

    @Step
    public void toTheTwoInputFieldForm() {
        openPageNamed("twoInputFieldForm");
    }

    @Step
    public void toTheSelectListForm() {
        openPageNamed("selectListForm");
    }

    @Step
    public void toTheMultiSelectListForm() {
        openPageNamed("multiSelectListForm");
    }
}
