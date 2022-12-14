package seleniumeasy.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://the-internet.herokuapp.com/download")
public class DownloadPage extends PageObject {

    public void downloadSampleField() {
        $(By.linkText("sample.png")).click();
    }
}
