package serenityswag.cart;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.inventory.ProductList;

import java.util.List;

public class CartActions extends UIInteractionSteps {

    ShoppingCartIcon shoppingCartIcon;

    //Método que agrega un elemento al carro de compras
    @Step("Add {0} to the cart")
    public void addItem(String itemName) {
        //Localizamos el elemento y le damos click
        find(ProductList.addToCartButton(itemName)).click();
    }

    //Método que agrega múltiples elementos al carro de compras
    @Step ("Add {0} to the cart")
    public void addItems(List<String> items) {
        //Iteramos sobre cada uno de los elementos de la lista, utilizando el método 'addItem'
        items.forEach(this::addItem);
    }

    //Método para abrir la página del carro de compras
    @Step ("Open the shopping cart page")
    public void openCart() {
        //Localizamos el link del método y le damos click
        find(shoppingCartIcon.link()).click();
    }

    //Método que obtiene los elementos de la página del carro de compras
    public List<String> displayedItems() {
        //Con 'texts()' devolvemos los textos de los elementos encontrados
        return findAll(".inventory_item_name").texts();
    }
}
