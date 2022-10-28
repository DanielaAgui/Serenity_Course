package serenityswag.inventory;

import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductDetails extends PageObject {

    public String productName() {
        //Localizamos el elemento y retornamos el texto
        return find(By.className("inventory_details_name")).getText();
    }

    //Forma de presentar información de estado sobre un elemento web
    public WebElementState productImageDisplayed(String firstItemName) {
        return find(By.cssSelector(".inventory_details_container img[alt='" + firstItemName + "']"));
    }
}
