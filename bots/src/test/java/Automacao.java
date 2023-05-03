import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automacao {

    @Test
    public void pesquisarGoogle(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\maria\\Desktop\\automação\\bots\\src\\drive\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();

        navegador.get("https://google.com");
    }
}
