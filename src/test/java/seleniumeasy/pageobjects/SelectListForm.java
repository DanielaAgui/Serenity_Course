package seleniumeasy.pageobjects;

import org.openqa.selenium.By;

public class SelectListForm extends SeleniumEasyForm{

    //Constante para evitar la repetición de código
    private static final By DAYS_OF_THE_WEEK = By.id("select-demo");

    //Método para obtener el valor actual del dropdown list
    public String selectedDay() {
        return $(DAYS_OF_THE_WEEK).getSelectedValue();
    }

    //Método para seleccionar por un valor un elemento del dropdown list
    public void selectDay(String day) {
        $(DAYS_OF_THE_WEEK).select().byValue(day);
    }
}
