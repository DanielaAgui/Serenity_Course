package seleniumeasy.pageobjects;

import net.thucydides.core.pages.PageObject;

public class TwoInputFieldForm extends PageObject {

    //Método para ingresar valor A
    public void enterA(String value) {
        find("#sum1").sendKeys(value);
    }

    //Método para ingresar valor B
    public void enterB(String value) {
        find("#sum2").sendKeys(value);
    }

    //Método para dar clic en el botón
    public void getTotal() {
        //Método genérico de localización
        find(FormButton.withLabel("Get Total")).click();
    }

    //Método para obtener el texto de la suma
    public String displayedTotal() {
        return find("#displayvalue").getText();
    }
}
