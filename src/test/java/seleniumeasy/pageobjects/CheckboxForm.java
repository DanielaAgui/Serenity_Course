package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://demo.seleniumeasy.com/basic-checkbox-demo.html")
public class CheckboxForm extends SeleniumEasyForm {

    //Método para seleccionar el checkbox
    public void setAgeSelected() {
        find("#isAgeSelected").click();
    }

    //Método para devolver el texto obtenido
    public String ageText() {
        return find("#txtAge").getText();
    }

    //Método para verificar si los checkbox están seleccionados
    public boolean optionIsCheckedFor(String option) {
        //'isSelected()' devuelve un booleano para saber si los checkbox están seleccionados o no
        //Utilizamos 'findBy' si necesitamos pasar parámetros
        return findBy("//label[contains(.,'{0}')]/input", option).isSelected();
    }

    //Método para dar clic en el botón "Check All"
    public void checkAll() {
        find("#check1").click();
    }
}
