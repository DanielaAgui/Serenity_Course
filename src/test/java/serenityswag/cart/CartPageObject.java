package serenityswag.cart;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

//Ponemos el link de la página a abrir
@DefaultUrl("https://www.saucedemo.com/cart.html")
public class CartPageObject extends PageObject {

    //Anotación para localizar un elemento web
    @FindBy(id = "checkout")
    //Se tienen que crear la variable como objeto WebElementFacade
            WebElementFacade checkoutButton;

    @FindBy(css = ".title")
    WebElementFacade title;

    //También se pueden localizar varios elementos web con un criterio único
    @FindBy(className = "cart_item")
    List<WebElementFacade> cartItemElements;

    //Método para dar click en el botón de checkout
    public void checkout() {
        //Se usa la variable localizada y se ejecuta la acción
        checkoutButton.click();
    }

    //Método para obtener el texto del título
    public String getTitleText() {
        return title.getText();
    }

    //Método para obtener una lista con los elementos de la página del carrito de compras
    //Para obtener la lista debemos tener en cuenta la clase record creada anteriormente y obtener los datos que se solicitan
    public List<CartItem> items() {
        //Creamos un ArrayList
        List<CartItem> cartItems = new ArrayList<>();

        //Iteramos sobre cada WebElement de la lista de elementos obtenidos con el localizador anterior
        for (WebElementFacade cartItemElement: cartItemElements) {
            //Creamos las variables y las localizamos según los parámetros estipulados en la clase record
            String name = cartItemElement.findBy(".inventory_item_name").getText();
            String description = cartItemElement.findBy(".inventory_item_desc").getText();
            //Obtenemos el texto del elemento y lo convertimos a Double
            Double price = priceFrom(cartItemElement.findBy(".inventory_item_price").getText());

            //Agregamos en el ArrayList creado los elementos con sus respectivos argumentos
            cartItems.add(new CartItem(name, description, price));
        }

        //Otra forma de crear un ArrayList es por medio de la función 'map'
        /*findAll(By.className("cart_item")).map(
                item -> new CartItem(
                        item.findBy(".inventory_item_name").getText(),
                        item.findBy(".inventory_item_desc").getText(),
                        priceFrom(item.findBy(".inventory_item_price").getText())
                )
        );*/

        return cartItems;
    }

    //Método para cambiar de String a Double (según los parámetros requeridos en la clase record)
    private Double priceFrom(String textValue) {
        //Convertimos el texto obtenido en Double y reemplazamos el signo $ por un espacio en blanco
        return Double.parseDouble(textValue.replace("$", ""));
    }
}
