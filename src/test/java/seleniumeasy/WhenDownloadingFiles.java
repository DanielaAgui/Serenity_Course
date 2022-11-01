package seleniumeasy;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.configuration.SessionLocalTempDirectory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import seleniumeasy.pageobjects.DownloadPage;

import java.io.File;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.awaitility.Awaitility.await;

@RunWith(SerenityRunner.class)
public class WhenDownloadingFiles {

    @Managed
    WebDriver driver;

    DownloadPage downloadPage;

    @Test
    public void weCanDownloadAFileToOurHardDrive() {
        downloadPage.open();
        downloadPage.downloadSampleField();
        //Agregamos un directorio temporal en esta sesión y añadimos el archivo
        File downloadedFile = SessionLocalTempDirectory.forTheCurrentSession().resolve("sample.png").toFile();

        /*También podemos descargar el archivo a un directorio específico
        File downloadedFile = Paths.get("Descargas/sample.png").toFile();*/

        //Esperamos hasta que el path temporal del archivo exista
        await().atMost(15, TimeUnit.SECONDS).until(downloadedFile::exists);
        //Verificamos que el archivo exista
        assertThat(downloadedFile).exists();
    }
}
