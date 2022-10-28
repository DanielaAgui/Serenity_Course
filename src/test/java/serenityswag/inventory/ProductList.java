package serenityswag.inventory;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;

public class ProductList extends PageObject {

    //Método que devuelve el localizador del elemento dado
    public static By addToCartButton (String itemName) {
        return By.xpath("//div[@class='inventory_item'][contains(., '" + itemName + "')]//button");
    }

    //Método que devuelve los nombres de los productos en una lista
    public List<String> titles() {
        //Retornamos los elementos encontrados
        //Con 'textContents()' leemos los valores obtenidos en la lista
        return findAll(By.className("inventory_item_name")).textContents();
    }

    //Método que devuelve el título de la imagen según el producto
    public String imageTextForProduct(String productName) {
        //Retornamos la imagen que corresponde al nombre del producto buscado y obtenemos el valor del atributo dado
        return find("//*[@alt='" + productName + "']").getAttribute("alt");
    }

    //Método que devuelve el localizador del producto
    public static By productDetailsLinkFor(String itemName) {
        return By.linkText(itemName);
    }
}
