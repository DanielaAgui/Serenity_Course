package todomvc;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import todomvc.pageobjects.TodoMvcActions;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenDeletingATask {

    @Managed
    WebDriver driver;

    @Steps
    TodoMvcActions todoMvcActions;

    @Before
    public void openPage() {
        todoMvcActions.openApplication();
    }

    @Test
    public void deletingATask() {
        todoMvcActions.addItems("Feed The Cat", "Walk The Dog");
        todoMvcActions.deleteAnItem("Feed The Cat");
        Serenity.reportThat("The list should not contain the deleted item",
                () -> assertThat(todoMvcActions.allItems()).containsExactly("Walk The Dog")
        );
    }
}
