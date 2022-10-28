package seleniumeasy.pageobjects;

import org.openqa.selenium.By;

//Método genérico para localizar un elemento
public class FormButton {
    public static By withLabel(String label) {
        return By.xpath("//button[.='" + label + "']");
    }
}
