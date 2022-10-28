package serenityswag.authentication.actions;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import serenityswag.authentication.User;

public class LoginActions extends UIInteractionSteps {

    //Método que ejecuta los pasos a seguir en el login
    //En el título podemos poner entre corchetes el índice del parámetro que queremos usar como título
    //Con 'Step' indicamos que un método va a aparecer como paso en los reportes de test
    @Step("Log in as {0}")
    //Podemos parametrizar instanciando los objetos de la clase 'enum'
    public void as(User user) {
        //Abrimos la URL
        openUrl("https://www.saucedemo.com/");

        //Localizamos los elementos, con las variables creadas. La palabra 'find' se puede reemplazar con $
        //Recuperamos los valores con los 'getters' de la clase 'enum'
        find(LoginForm.USER_NAME).sendKeys(user.getUsername());
        find(LoginForm.PASSWORD).sendKeys(user.getPassword());
        find(LoginForm.LOGIN_BUTTON).click();
    }
}
