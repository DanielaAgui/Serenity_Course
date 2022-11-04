package todomvc.pageobjects;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Arrays;
import java.util.List;

import static todomvc.pageobjects.TodoMvcVariables.*;

public class TodoMvcActions extends UIInteractionSteps {

    @Step("Opening TodoMVC page")
    public void openApplication() {
        openPageNamed("home");
    }

    @Step("Adding item {0}")
    public void addItem(String item) {
        $(ITEM_FIELD).typeAndEnter(item);
    }

    //Lista de items a añadir
    public void addItems(String... items) {
        addItems(Arrays.asList(items));
    }

    @Step("Adding multiple items")
    //Tomamos la lista de items y la añadimos al campo
    public void addItems(List<String> items) {
        items.forEach(this::addItem);
    }

    public List<String> allItems() {
        return $$(NEW_FIELD).texts();
    }

    public String getItemCount() {
        return $(ITEM_COUNT).getText();
    }

    @Step("Item {0} completed")
    public void checkTheItem(String item) {
        $("//label[.='{0}']/preceding-sibling::input[@type='checkbox']", item).click();
    }

    public void goTo(String filter) {
        $(FIELD_BUTTON(filter)).click();
    }

    @Step("Deleting item {0}")
    public void deleteAnItem(String item) {
        $("//label[.='{0}']", item).click();
        $("//label[.='{0}']/following-sibling::button[@class='destroy']", item).click();
    }

    public void clearList() {
        //Obtenemos el driver y eliminamos los datos almacenados en el navegador
        ((JavascriptExecutor)getDriver()).executeScript("localStorage.clear();");
    }
}
