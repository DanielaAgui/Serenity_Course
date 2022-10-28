package serenityswag.cart;

import net.serenitybdd.core.pages.PageObject;

public class ShoppingCartBagde extends PageObject {

    //Método que cuenta la cantidad de productos
    public String count() {
        //Localizamos el elemento y devuelve su texto
        return find(".shopping_cart_link").getText();
    }
}
