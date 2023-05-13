package src.test;

import org.apache.commons.io.FileUtils;
import org.example.Conta;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class teste extends Conta {

    public static void main(String[] args) {


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-extensions");
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--no-sandbox");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("user-agent={user_agent}");


        Conta conta = new Conta();
        conta.driver = new ChromeDriver(options);
        WebDriver driver = conta.driver;

        driver.get("https://www.ganharnasredes.com/painel/?pagina=logout");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        WebElement x = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[1]/button"));
        x.click();

        WebElement email = driver.findElement(By.cssSelector("#uname"));
        email.sendKeys("rod.stqtic@gmail.com");
        WebElement senha = driver.findElement(By.cssSelector("#pwd"));
        new Actions(driver).scrollToElement(senha).perform();
        senha.sendKeys("15466231");
        WebElement logar = driver.findElement(By.cssSelector("body > div.main-wrapper > div > div > div.col-lg-5.col-md-7.bg-white > div > form > div > div:nth-child(3) > button"));
        logar.click();
        System.out.println("logou gni");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\maria\\Desktop\\automação\\fotoinsta.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



//        conta.contaIG = "futurista.z";
//        conta.senhaIG = "botnuumero03";
//        conta.logins();
//        driver.get("https://www.instagram.com/p/CNvkGTxFcBG/");
//        System.out.println(conta.driver.getCurrentUrl());
//        WebElement botaoCurtir = driver.findElement(By.cssSelector("section._aamu._ae3_ button._abl-"));
    }
}
