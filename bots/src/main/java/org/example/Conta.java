package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Conta {

    WebDriver driver = new ChromeDriver();

    public  void logins(){
        driver.get("https://www.instagram.com/");
        WebElement user =   new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginForm > div > div:nth-child(1) > div > label > input")));
        user.sendKeys("rod_stqtic");
        WebElement pwd = driver.findElement(By.cssSelector("#loginForm > div > div:nth-child(2) > div > label > input"));
        pwd.sendKeys("15466231");
        WebElement botaoLogin = driver.findElement(By.cssSelector("#loginForm > div > div:nth-child(3)"));
        botaoLogin.click();

        driver.get("https://www.ganharnasredes.com/painel/?pagina=logout");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        WebElement x = driver.findElement(By.cssSelector("#modalAvisoCurso > div > div > div.modal-header > button"));
        x.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement email = driver.findElement(By.cssSelector("#uname"));
        email.sendKeys("rod.stqtic@gmail.com");
        WebElement senha = driver.findElement(By.cssSelector("#pwd"));
        senha.sendKeys("15466231");
        WebElement logar = driver.findElement(By.cssSelector("body > div.main-wrapper > div > div > div.col-lg-5.col-md-7.bg-white > div > form > div > div:nth-child(3) > button"));
        logar.click();
    }

    public void irParaAcoes(){

        WebElement barraLateral = driver.findElement(By.cssSelector("#main-wrapper > aside > div > nav"));
        Actions action = new Actions(driver);
        action.moveToElement(barraLateral).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement Acoes = driver.findElement(By.cssSelector("#sidebarnav > li:nth-child(11) > center > a > b > span"));
        Acoes.click();
        WebElement body = driver.findElement(By.cssSelector("#form_selecionar"));
        action.moveToElement(body).build().perform();
        WebElement botaoIniciar = driver.findElement(By.cssSelector("#btn_iniciar"));
        new Actions(driver).scrollToElement(botaoIniciar).perform();
        botaoIniciar.click();
    }

    public void realizarAcoes(){
        driver.findElement(By.cssSelector("#btn_iniciar"));

        WebElement acao = driver.findElement(By.cssSelector("#tarefa > b"));
        if(acao.equals("[IG] Curtir Publicação [R$ 0,002]\n")){
            curtir();
        }

        // #btn-acessar
        // #btn-confirmar
    }

    public void curtir(){

    }

    public void seguir(){

    }

}
