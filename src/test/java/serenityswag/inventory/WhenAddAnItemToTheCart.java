package serenityswag.inventory;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.User;
import serenityswag.authentication.actions.LoginActions;
import serenityswag.cart.CartActions;
import serenityswag.cart.CartItem;
import serenityswag.cart.CartPageObject;
import serenityswag.cart.ShoppingCartIcon;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SerenityRunner.class)
public class WhenAddAnItemToTheCart {

    @Managed
    WebDriver driver;

    @Steps
    LoginActions login;

    //Siempre antes de cada test se va a loguear
    @Before
    public void login() {
        login.as(User.STANDARD_USER);
    }

    ShoppingCartIcon shoppingCartBagde;

    @Steps
    CartActions cart;

    @Test
    public void theCorrectItemCountShouldBeShown() {
        //Verificamos que el carro de compras esté vacío
        Serenity.reportThat("The shopping should be empty",
                () -> assertThat(shoppingCartBagde.badgeCount()).isEmpty());

        //Agregamos un producto al carro de compras
        cart.addItem("Sauce Labs Backpack");

        //Verificamos que la cantidad en el carro de compras sea igual a 1
        assertThat(shoppingCartBagde.badgeCount()).isEqualTo("1");
    }

    ProductList productList;

    @Test
    public void allTheItemsShouldAppearInTheCart() {
        //Creamos una lista con los subíndices obtenidos del método
        List<String> selectedItems = productTitlesDisplayed(0, 2);

        //Agregamos al carro de compras los productos de la lista obtenida
        cart.addItems(selectedItems);

        //Devolvemos en un String el tamaño de la lista de productos obtenidos
        String cartBadgeCount = Integer.toString(selectedItems.size());

        //Verificamos que la cantidad en el carro de compras sea igual al número de productos agregados
        assertThat(shoppingCartBagde.badgeCount()).isEqualTo(cartBadgeCount);

        //Abrimos la página del carro de compras
        cart.openCart();

        //Verificamos que los elementos obtenidos de la página del carro de compras sean los mismos que agregamos
        assertThat(cart.displayedItems()).containsExactlyElementsOf(selectedItems);
    }

    CartPageObject cartPage;

    @Test
    public void pricesForEachItemShouldBeShownInTheCart() {
        //Agregamos productos al carrito de compras
        cart.addItems(productTitlesDisplayed(0, 2));

        //Abrimos la página del carro de compras con el link por defecto
        cartPage.open();

        //Obtenemos la lista de los elementos de la página del carrito de compras
        List<CartItem> items = cartPage.items();

        //Verificamos que la lista tenga el tamaño de
        //Con 'allMatch()' devolvemos un booleano si los elementos coinciden con el predicado dado
        //Verificamos que los items de la lista tengan todos un precio mayor a 0
        assertThat(items).hasSize(2).allMatch(item -> item.price() > 0.0);
    }

    //Método que obtiene los nombres de los productos de la página de inventario
    private List<String> productTitlesDisplayed(int indiceInicio, int indiceFinal) {
        //Con 'subList()' devolvemos una porción de la lista (índice inicio, índice final)
        return productList.titles().subList(indiceInicio, indiceFinal);
    }
}
