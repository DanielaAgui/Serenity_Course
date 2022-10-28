package serenityswag.inventory;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import serenityswag.authentication.User;
import serenityswag.authentication.actions.LoginActions;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenViewingHighlightedProducts {

    @Managed
    WebDriver driver;

    //Repetimos los pasos de Login
    @Steps
    LoginActions login;

    @Steps
    ViewProductDetailsActions viewProductDetails;

    ProductList productList;
    ProductDetails productDetails;

    @Test
    public void shouldDisplayHighlightedProductsOnTheWelcomePage() {
        login.as(User.STANDARD_USER);

        //Creamos una variable de lista con los datos obtenidos del método
        List<String> productsOnDisplay = productList.titles();

        //Verificamos el tamaño de la lista y que contenga alguno de los títulos
        assertThat(productsOnDisplay).hasSize(6).contains("Sauce Labs Backpack");
    }

    @Test
    public void highlightedProductShouldDisplayTheCorrespondingImage() {
        login.as(User.STANDARD_USER);

        //Obtenemos la lista de titulos de los productos
        List<String> productsOnDisplay = productList.titles();

        SoftAssertions softAssertions = new SoftAssertions();

        //Iteramos sobre los productos desplegados en pantalla
        productsOnDisplay.forEach(productName ->
                //Por cada uno verificamos que el texto de la imagen sea igual al nombre del producto
                assertThat(productList.imageTextForProduct(productName)).isEqualTo(productName));

        /*for (String productName : productsOnDisplay) {
            assertThat(productList.imageText(productName)).isEqualTo(productName);
        }*/
    }

    @Test
    public void shouldDisplayCorrectProductDetailsPage() {
        login.as(User.STANDARD_USER);

        //Devolvemos en una variable el texto obtenido en el índice cero según el método ejecutado
        String firstItemName = productList.titles().get(0);
        //Localizamos el elemento de la variable anterior
        viewProductDetails.forProductWithName(firstItemName);

        //Verificamos que el texto obtenido según el método sea igual al obtenido del índice cero
        assertThat(productDetails.productName()).isEqualTo(firstItemName);
        //Verificamos si el elemento obtenido es visible
        productDetails.productImageDisplayed(firstItemName).shouldBeVisible();
    }
}
