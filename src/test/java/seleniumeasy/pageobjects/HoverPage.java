package seleniumeasy.pageobjects;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.WebElementState;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://the-internet.herokuapp.com/hovers")
public class HoverPage extends PageObject {

    public static final String FIGURE_IMAGE = "//*[@class='figure'][{0}]";
    public static final String FIGURE_CAPTION = "(//*[@class='figcaption'])[{0}]";

    //Método para pasar sobre la figura
    public void hoverOverFigure(int number) {
        //Localizamos la figura y la creamos en un objeto WebElementFacade
        WebElementFacade figure = $(FIGURE_IMAGE, number);
        //Con las acciones vamos hasta el elemento
        withAction().moveToElement(figure).perform();

        /*Podemos pasar de una imagena a otra con 'drag and drop()'
        withAction().dragAndDrop($(FIGURE_IMAGE, 1), $(FIGURE_IMAGE, 2)).perform();*/
    }

    //Método para verificar el estado de un elemento
    public WebElementState captionForFigure(int number) {
        return $(FIGURE_CAPTION, number);
    }
}
