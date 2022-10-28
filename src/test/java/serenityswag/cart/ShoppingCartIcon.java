package serenityswag.cart;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class ShoppingCartIcon extends PageObject {

    //Método que cuenta la cantidad de productos
    public String badgeCount() {
        //Localizamos el elemento y devuelve su texto
        return find(".shopping_cart_link").getText();
    }

    //Podemos crear un método 'static' y solo usar la clase sin necesidad de instanciar un objeto de la clase
    //Devuelve el localizador del ícono del carro de compras
    public By link() {
        return By.cssSelector(".shopping_cart_link");
    }
}
