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
public class WhenCompletingATask {

    @Managed
    WebDriver driver;

    @Steps
    TodoMvcActions todoMvcActions;

    @Before
    public void openPage() {
        todoMvcActions.openApplication();
    }

    @Test
    public void activeTasksShouldNotShowCompletedTasks() {
        todoMvcActions.addItems("Feed The Cat", "Walk The Dog");
        todoMvcActions.checkTheItem("Feed The Cat");
        todoMvcActions.goTo("Active");
        Serenity.reportThat("The active tasks should only have 'Walk The Dog'",
                () -> assertThat(todoMvcActions.allItems()).containsExactly("Walk The Dog")
        );
    }

    @Test
    public void completedTasksShouldNotShowActiveTasks() {
        todoMvcActions.addItems("Feed The Cat", "Walk The Dog");
        todoMvcActions.checkTheItem("Feed The Cat");
        todoMvcActions.goTo("Completed");
        Serenity.reportThat("The completed tasks should only have 'Feed The Cat'",
                () -> assertThat(todoMvcActions.allItems()).containsExactly("Feed The Cat")
        );
    }
}
