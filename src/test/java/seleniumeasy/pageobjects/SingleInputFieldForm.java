package seleniumeasy.pageobjects;

import net.thucydides.core.pages.PageObject;

//Establecemos la URL a usar
public class SingleInputFieldForm extends PageObject {

    //Método para escribir contenido en el input
    public void enterMessage(String message) {
        find("#user-message").sendKeys(message);
    }

    //Método para dar clic en el botón de mostrar mensaje
    public void showMessage() {
        //Llamamos al método genérico de localización
        find(FormButton.withLabel("Show Message")).click();
    }

    //Método que obtiene y devuelve el texto mostrado en el mensaje
    public String displayedMessage() {
        return find("#display").getText();
    }
}
