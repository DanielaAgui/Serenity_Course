package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://demo.seleniumeasy.com/basic-radiobutton-demo.html")
public class MultipleRadioButtonsForm extends PageObject {

    public void selectGender(String value) {
        inRadioButtonGroup("gender").selectByValue(value);
    }

    public void selectAgeGroup(String value) {
        inRadioButtonGroup("ageGroup").selectByValue(value);
    }

    public void getValues() {
        find(FormButton.withLabel("Get values")).click();
    }

    public String getResult() {
        return find(".groupradiobutton").getText();
    }
}
