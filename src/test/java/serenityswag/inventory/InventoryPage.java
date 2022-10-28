package serenityswag.inventory;

import net.thucydides.core.pages.PageObject;

//Con PageObject creamos objetos de página
public class InventoryPage extends PageObject {

    //Método que devuelve el texto del elemento localizado
    public String getHeading() {
        return find(".title").getText();
    }
}
