package org.example;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Conta {
    String contaIG;
    String senhaIG;

    WebDriver driver = new ChromeDriver();

    public  void logins(){
        // OBTER CONTA E SENHA DO OBJETO CRIADO
        contaIG = this.contaIG;
        senhaIG = this.senhaIG;
        // IR PRO INSTA E LOGAR
        driver.get("https://www.instagram.com/");
        WebElement user =   new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginForm > div > div:nth-child(1) > div > label > input")));
        user.sendKeys(contaIG);
        WebElement pwd = driver.findElement(By.cssSelector("#loginForm > div > div:nth-child(2) > div > label > input"));
        pwd.sendKeys(senhaIG);
        WebElement botaoLogin = driver.findElement(By.cssSelector("#loginForm > div > div:nth-child(3)"));
        botaoLogin.click();
        // IR PRO GNI E LOGAR
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
        // SELECIONAR BARRA LATERAL E IR PARA AREA DE ESCOLHER CONTA
        String contaig = contaIG;
        WebElement barraLateral = driver.findElement(By.cssSelector("#main-wrapper > aside > div > nav"));
        Actions action = new Actions(driver);
        action.moveToElement(barraLateral).build().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement Acoes = driver.findElement(By.cssSelector("#sidebarnav > li:nth-child(11) > center > a > b > span"));
        Acoes.click();
        WebElement body = driver.findElement(By.cssSelector("#form_selecionar"));
        action.moveToElement(body).build().perform();
        // ESCOLHENDO CONTA
        WebElement escolherConta = driver.findElement(By.cssSelector("#contaig"));
        escolherConta.click();
        WebElement conjuntoContas = driver.findElement(By.xpath("//*[@id=\"contaig\"]"));
        List<WebElement> contas = conjuntoContas.findElements(By.tagName("option"));
        String contaXpath = "";
        // FOR PARA COMPARAR A CONTA DA VEZ COM A TAG OPTION DENTRO DO BOTAO
        for(int i = 0; i < contas.size(); i++){
            String conta = contas.get(i).getText();
            System.out.println(conta);
            if(conta.equals(contaig)){
                contaXpath= "//*[@id=\"contaig\"]/option["+ ++i +"]";
                System.out.println(" xpath de : " + conta + " é :  "+ contaXpath);
            }
        }
        //SELECIONANDO A OPTION CORRETA
        WebElement escolhida = driver.findElement(By.xpath(contaXpath));
        escolhida.click();
        //CLICANDO NO BOTAO DE INICIAR AÇÃO
        WebElement botaoIniciar = driver.findElement(By.cssSelector("#btn_iniciar"));
        new Actions(driver).scrollToElement(botaoIniciar).perform();
        botaoIniciar.click();
    }

    public void realizarAcoes(){
       WebDriverWait disponivel = new WebDriverWait(driver,Duration.ofDays(1));
       disponivel.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btn_iniciar")));

        WebElement acao = driver.findElement(By.cssSelector("#tarefa > b"));
        if(acao.equals("[IG] Curtir Publicação [R$ 0,002]")){
            curtir();
        } else if(acao.equals("[IG] Seguir Perfil [R$ 0,005]")){
            seguir();
        }

        // #btn-acessar
        // #btn-confirmar
    }


    public void curtir(){

    WebElement curtir = driver.findElement(By.cssSelector("#btn-acessar"));
    curtir.click();

    WebElement curtirIG = driver.findElement(By.xpath("]/div/div/div[2]/div/div/div/div[1]/div[1]/div[2]/section/main/div/div[2]"));
    curtirIG.click();

    WebElement confirmar = driver.findElement(By.cssSelector("#btn-confirmar"));
    confirmar.click();
    }


    public void seguir(){
        WebElement acessarSeguir = driver.findElement(By.cssSelector("#btn-acessar"));
        acessarSeguir.click();
        WebElement seguirIG = driver.findElement(By.xpath("//*[@id=\"mount_0_0_Bs\"]/div/div/div[2]/div/div/div/div[1]/div[1]/div[2]/div[2]/section/main/div/header/section/div[3]/div/div[1]/button/div/div[1]"));
        seguirIG.click();

        WebElement confirmar = driver.findElement(By.cssSelector("#btn-confirmar"));
        confirmar.click();
    }

}
