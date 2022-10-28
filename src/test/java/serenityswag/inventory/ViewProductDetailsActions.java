package serenityswag.inventory;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class ViewProductDetailsActions extends UIInteractionSteps {

    //Método que localiza un producto y le da clic
    @Step("View product details for product {0}")
    public void forProductWithName(String firstItemName) {
        //Llamamos el método de localización de la página y le damos clic
        find(ProductList.productDetailsLinkFor(firstItemName)).click();
    }
}
