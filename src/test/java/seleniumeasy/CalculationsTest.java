package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.actions.NavigateActions;
import seleniumeasy.pageobjects.TwoInputFieldForm;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

//Clase para ejecutar un conjunto de pruebas utilizando un conjunto de datos
@RunWith(SerenityParameterizedRunner.class)
//Para correr los test en paralelo (al tiempo)
@Concurrent
public class CalculationsTest {

    //Constantes a usar en los test
    private final String a;
    private final String b;
    private final String total;

    //Usamos '--headless' para que no abra el navegador cuando vayamos a ejeuctar todos los tests al tiempo
    @Managed (options = "--headless")
    WebDriver driver;

    //Creamos el constructor
    public CalculationsTest(String a, String b, String total) {
        this.a = a;
        this.b = b;
        this.total = total;
    }

    //Datos parametrizados para el test, se puede usar con pocos datos
    //Podemos añadir nombres de columnas para los reportes
    @TestData(columnNames = "A, B, Total")
    //Creamos una colección de objetos con los parámetros a usar
    public static Collection<Object[]> testData() {
        return Arrays.asList(
                new Object[][] {
                        //Datos a usar según el constructor
                        {"1", "2", "3"},
                        {"10", "20", "30"},
                        {"10", "-5", "5"}
                }
        );
    }

    TwoInputFieldForm twoInputFieldForm;
    NavigateActions navigate;

    //Marca un método en casos de prueba basados en datos instanciados
    @Qualifier
    public String qualifier() {
        //Aparece en los nombres de los métodos en los reportes de Serenity
        return a + " + " + b + " = " + total;
    }

    @Test
    public void shouldCalculateTheCorrectTotal() {
        //Abrimos la URL
        navigate.toTheTwoInputFieldForm();
        //Ingresamos el dato A de los parámetros
        twoInputFieldForm.enterA(a);
        //Ingresamos el dato B de los parámetros
        twoInputFieldForm.enterB(b);
        //Obtenemos el total
        twoInputFieldForm.getTotal();
        //Verificamos que el total obtenido sea igual al total según la colección
        assertThat(twoInputFieldForm.displayedTotal()).isEqualTo(total);
    }
}
