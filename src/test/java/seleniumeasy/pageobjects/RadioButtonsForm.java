package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://demo.seleniumeasy.com/basic-radiobutton-demo.html")
public class RadioButtonsForm extends SeleniumEasyForm {

    //Método para seleccionar el radiobutton indicado
    public void selectOption(String value) {
        //Método para agrupar los radiobutton de un mismo grupo por medio del nombre y seleccionamos por valor
        inRadioButtonGroup("optradio").selectByValue(value);
    }

    public void getCheckedValue() {
        find("#buttoncheck").click();
    }

    public String getResult() {
        return find(".radiobutton").getText();
    }
}
