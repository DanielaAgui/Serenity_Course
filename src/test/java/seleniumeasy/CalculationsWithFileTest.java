package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.actions.NavigateActions;
import seleniumeasy.pageobjects.TwoInputFieldForm;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent
//Pasamos el path del archivo csv creado para usar los datos como parámetros
@UseTestDataFrom("test-data/calculations.csv")
public class CalculationsWithFileTest {

    //Variables a usar en el test
    private String a;
    private String b;
    private String total;

    @Managed (options = "--headless")
    WebDriver driver;

    TwoInputFieldForm twoInputFieldForm;
    NavigateActions navigate;

    @Qualifier
    public String qualifier() {
        return a + " + " + b + " = " + total;
    }

    @Test
    public void shouldCalculateTheCorrectTotal() {
        navigate.toTheTwoInputFieldForm();
        twoInputFieldForm.enterA(a);
        twoInputFieldForm.enterB(b);
        twoInputFieldForm.getTotal();
        assertThat(twoInputFieldForm.displayedTotal()).isEqualTo(total);
    }
}
