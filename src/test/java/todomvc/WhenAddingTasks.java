package todomvc;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import todomvc.pageobjects.TodoMvcActions;

import static org.assertj.core.api.Assertions.assertThat;

//No es necesario poner la anotación 'RunWith()' ya que Junit5 lo reconoce
//Anotación que permite dar un nombre personalizado a la clase o métodos para los reportes de Serenity
@DisplayName("When adding tasks to the to-do list")
public class WhenAddingTasks {

    @Managed
    WebDriver driver;

    @Steps
    TodoMvcActions todoMvcActions;

    //Método que debe ejecutarse antes de cada test
    @BeforeEach
    public void openPage() {
        todoMvcActions.openApplication();
    }

    //Método que debe ejecutarse después de cada test
    @AfterEach
    //No es necesario indicar 'public' en los métodos, Junit5 reconoce el método
    void clearTheList() {
        todoMvcActions.clearList();
    }

    @DisplayName("Adding a single task to the to-do list")
    @Test
    public void addingASingleTask() {
        todoMvcActions.addItem("Feed The Cat");

        Serenity.reportThat("The text should be 'Feed Tha Cat'",
                () -> assertThat(todoMvcActions.allItems()).contains("Feed The Cat"));

        Serenity.reportThat("The item's quantity should be 1",
                () -> assertThat(todoMvcActions.getItemCount()).isEqualTo("1"));
    }

    @Test
    public void addingMultipleTasks() {
        todoMvcActions.addItems("Feed The Cat", "Walk The Dog");

        Serenity.reportThat("The text should be 'Feed Tha Cat'",
                () -> assertThat(todoMvcActions.allItems()).contains("Feed The Cat", "Walk The Dog"));

        Serenity.reportThat("The item's quantity should be 2",
                () -> assertThat(todoMvcActions.getItemCount()).isEqualTo("2"));
    }
}
