package org.example;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import jdk.jfr.Timespan;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Conta {
    String contaIG;
    String senhaIG;


    ChromeDriver driver = new ChromeDriver();

    public  void logins(){
        //DEFINIR TAMANHO DA JANELA
        driver.manage().window().setSize(new Dimension(500, 860));
        driver.manage().window().setPosition(new Point(1090, 0));


        // OBTER CONTA E SENHA DO OBJETO CRIADO
        contaIG = this.contaIG;
        senhaIG = this.senhaIG;
        // IR PRO INSTA E LOGAR
       driver.get("https://www.instagram.com/");
        WebElement user =   new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginForm > div > div:nth-child(1) > div > label > input")));
        user.sendKeys(contaIG);
        WebElement pwd = driver.findElement(By.cssSelector("#loginForm > div > div:nth-child(2) > div > label > input"));
        pwd.sendKeys(senhaIG);
        WebElement botaoLogin = driver.findElement(By.cssSelector("#loginForm > div > div:nth-child(3)"));
        botaoLogin.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

//        WebElement agoraNao = driver.findElement(By.cssSelector("#mount_0_0_5v > div > div > div:nth-child(3) > div > div > div.x9f619.x1n2onr6.x1ja2u2z > div > div.x1uvtmcs.x4k7w5x.x1h91t0o.x1beo9mf.xaigb6o.x12ejxvf.x3igimt.xarpa2k.xedcshv.x1lytzrv.x1t2pt76.x7ja8zs.x1n2onr6.x1qrby5j.x1jfb8zj > div > div > div > div > div.x7r02ix.xf1ldfh.x131esax.xdajt7p.xxfnqb6.xb88tzc.xw2csxc.x1odjw0f.x5fp0pe > div > div > div._a9-z > button._a9--._a9_1"));
//        agoraNao.click();

//        WebDriverWait agoraNao = new WebDriverWait(driver,Duration.ofSeconds(100));
//        agoraNao.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mount_0_0_7S\"]/div/div/div[3]/div/div/div[1]/div/div[2]/div/div/div/div/div[2]/div")));

       //  IR PRO GNI E LOGAR

        driver.get("https://www.ganharnasredes.com/painel/?pagina=logout");

        WebElement x = driver.findElement(By.cssSelector("#modalAvisoCurso > div > div > div.modal-header > button"));
        x.click();

        WebElement email = driver.findElement(By.cssSelector("#uname"));
        email.sendKeys("rod.stqtic@gmail.com");
        WebElement senha = driver.findElement(By.cssSelector("#pwd"));
        new Actions(driver).scrollToElement(senha).perform();
        senha.sendKeys("15466231");
        WebElement logar = driver.findElement(By.cssSelector("body > div.main-wrapper > div > div > div.col-lg-5.col-md-7.bg-white > div > form > div > div:nth-child(3) > button"));
        logar.click();
    }

    public void irParaAcoes(){
        // SELECIONAR BARRA LATERAL E IR PARA AREA DE ESCOLHER CONTA
        String contaig = contaIG;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement barraLateral = driver.findElement(By.cssSelector("#main-wrapper > header > nav > div.navbar-header > a.nav-toggler.waves-effect.waves-light.d-block.d-md-none"));
        barraLateral.click();
        Actions action = new Actions(driver);
//        action.moveToElement(barraLateral).build().perform();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

    public boolean realizarAcoes(){

        while(true) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            WebElement acao = driver.findElement(By.cssSelector("#tarefa"));
            String acaoTexto = acao.getText();
            System.out.println(acaoTexto);

            if (acaoTexto.contains("[IG] Curtir Publicação")) {
                curtir();
            } else if (acaoTexto.contains("[IG] Seguir Perfil")) {
                seguir();
            }

        }

    }



    public void curtir(){

        String url1 = driver.getCurrentUrl();
        System.out.println(url1);

        try {
        Thread.sleep(5000);
        } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        }

        WebElement acessarCurtir = driver.findElement(By.cssSelector("#btn-acessar"));
        acessarCurtir.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        ArrayList<String> windu = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windu.get(1));


        String url = driver.getCurrentUrl();
        System.out.println(url);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        List <WebElement> curtirIG = driver.findElements(By.cssSelector("button._abl-"));
        WebElement botaoCurtir = curtirIG.get(1);
        new Actions(driver).scrollToElement(botaoCurtir).perform();
        botaoCurtir.click();

        try {
        Thread.sleep(5000);
        } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        }

        driver.close();

        driver.switchTo().window(windu.get(0));

        WebElement confirmar = driver.findElement(By.cssSelector("#btn-confirmar"));
        confirmar.click();

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


    }


    public void seguir(){

        String originalWindow = driver.getWindowHandle();

        String url1 = driver.getCurrentUrl();
        System.out.println(url1);

        try {
        Thread.sleep(3000);
        } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        }

        WebElement acessarSeguir = driver.findElement(By.cssSelector("#btn-acessar"));
        acessarSeguir.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        ArrayList<String> windu = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windu.get(1));


       String url = driver.getCurrentUrl();
       System.out.println(url);

        try {
        Thread.sleep(2000);
        } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        }

        List <WebElement> seguirIG = driver.findElements(By.tagName("button"));
        seguirIG.get(1).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        driver.close();
        try {
        Thread.sleep(5000);
        } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        }
        driver.switchTo().window(windu.get(0));

        WebElement confirmar = driver.findElement(By.cssSelector("#btn-confirmar"));
        confirmar.click();

        try {
            Thread.sleep(50000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

}
