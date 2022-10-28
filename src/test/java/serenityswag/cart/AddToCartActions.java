package serenityswag.cart;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.inventory.ProductList;

public class AddToCartActions extends UIInteractionSteps {

    //Método que agrega elementos al carro de compras
    @Step("Add {0} to the cart")
    public void item(String itemName) {
        //Localizamos el elemento y le damos click
        find(ProductList.addToCartButton(itemName)).click();
    }
}
