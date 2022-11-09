package todomvc;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.WebDriver;
import todomvc.pageobjects.TodoMvcActions;

import java.util.List;

import static java.util.Arrays.asList;
import static net.serenitybdd.core.Serenity.reportThat;
import static org.assertj.core.api.Assertions.assertThat;

public class WhenFilteringTasks {

    @Managed(driver = "chrome")
    WebDriver driver;

    @Steps
    TodoMvcActions todoList;

    @AfterEach
    void clearTheList() {
        todoList.clearList();
    }

    //Para los test parametrizados no necesitamos las constantes ni el constructor ni el testData con JUnit5
    //Anotación de test parametrizado, le podemos pasar un nombre para los tests
    @ParameterizedTest(name = "Should correctly filter items: {0}")
    //Anotación para pasar los parámetros para los test
    @CsvSource({
            "Active, Feed the cat;Walk the dog, Feed the cat, Walk the dog",
            "Completed, Feed the cat;Walk the dog, Feed the cat, Feed the cat",
            "All, Feed the cat;Walk the dog, Feed the cat, Feed the cat;Walk the dog"
    })
    public void shouldShowCorrectlyFilteredItems(String filterBy,
                                                 String todoItems,
                                                 String completeItem,
                                                 String filteredItems) {
        //Abrimos la URL
        todoList.openApplication();
        //Añadimos los items según la lista obtenida de la cadena parametrizada
        todoList.addItems(listFrom(todoItems));
        //Completamos una de las tareas
        todoList.checkTheItem(completeItem);
        //Filtramos
        todoList.goTo(filterBy);

        reportThat("The todo list should contain the expected items",
                //Verificamos que los items obtenidos sean los mismo del filtro según la lista
                () -> assertThat(todoList.allItems()).hasSameElementsAs(listFrom(filteredItems))
        );
    }

    private List<String> listFrom(String items) {
        //Convertimos los elementos en una lista diviendo la cadena por un caracter específicado
        return asList(items.split(";"));
    }
}
