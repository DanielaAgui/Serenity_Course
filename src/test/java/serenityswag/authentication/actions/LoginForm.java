package serenityswag.authentication.actions;

import org.openqa.selenium.By;

//Creamos una clase que contenga las variables para loguearse en la página
class LoginForm {
    //Creamos las variables estáticas
    static By USER_NAME = By.xpath("//*[@data-test='username']");
    static By PASSWORD = By.xpath("//*[@data-test='password']");
    static By LOGIN_BUTTON = By.xpath("//*[@data-test='login-button']");
}
