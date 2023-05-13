package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.io.FileUtils;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Conta {
    public String contaIG;
    public String senhaIG;
    public WebDriver driver;

    public  void logins(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        //DEFINIR TAMANHO DA JANELA
        driver.manage().window().setSize(new Dimension(1800,850));


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
        System.out.println("logou insta");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
            //                                      tirar print
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\maria\\Desktop\\automação\\fotoinsta.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

       //  IR PRO GNI E LOGAR
        driver.get("https://www.ganharnasredes.com/painel/?pagina=logout");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        WebElement x = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/button"));
        x.click();

        WebElement email = driver.findElement(By.cssSelector("#uname"));
        email.sendKeys("rod.stqtic@gmail.com");
        WebElement senha = driver.findElement(By.cssSelector("#pwd"));
        new Actions(driver).scrollToElement(senha).perform();
        senha.sendKeys("15466231");
        WebElement logar = driver.findElement(By.cssSelector("body > div.main-wrapper > div > div > div.col-lg-5.col-md-7.bg-white > div > form > div > div:nth-child(3) > button"));
        logar.click();
        System.out.println("logou gni");

    }

    public void irParaAcoes(){

        // SELECIONAR BARRA LATERAL E IR PARA AREA DE ESCOLHER CONTA
        String contaig = contaIG;
        Actions action = new Actions(driver);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        WebElement Acoes = driver.findElement(By.cssSelector("#sidebarnav > li:nth-child(11) > center > a"));
        Acoes.click();

        //                                                                  tirar print
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        try {
            FileUtils.copyFile(scrFile, new File("C:\\Users\\maria\\Desktop\\automação\\fotogni.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

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

        WebElement botaoCurtir = driver.findElement(By.cssSelector("._aamu._ae3_._ae47._ae48 button._abl-"));
        new Actions(driver).scrollToElement(botaoCurtir).perform();
        botaoCurtir.click();

        try {
        Thread.sleep(5000);
        } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        }

        driver.close();

        driver.switchTo().window(windu.get(0));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        WebElement confirmar = driver.findElement(By.cssSelector("#btn-confirmar"));
        confirmar.click();

        try {
            Thread.sleep(60000);
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
        seguirIG.get(0).click();

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
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    public  void movimentarContas(){
        String[][] contas = {
                {"conta1", "conta2", "conta3" ,"conta4" ,"conta5" ,"conta6", "conta7"},
                {"senha1","senha2","senha3","senha4","senha5","senha6", "senha 7"}
        };

        for (int i = 0; i < contas[0].length; i++) {
            System.out.println("===== CONTA A POSTAR : " + contas[0][i] + " SENHA : " + contas[1][i] + "=====");
            driver.get("https://www.instagram.com");
            WebElement user =   new WebDriverWait(driver, Duration.ofSeconds(100))
                    .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginForm > div > div:nth-child(1) > div > label > input")));
            user.sendKeys(contas[0][i]);
            WebElement pwd = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginForm > div > div:nth-child(2) > div > label > input")));
            pwd.sendKeys(contas[1][i]);
            WebElement botaoLogin = driver.findElement(By.cssSelector("#loginForm > div > div:nth-child(3)"));
            botaoLogin.click();
            for (int j = 0; j < contas[0].length; j++) {

                if(contas[0][i].equals(contas[0][j])){

                } else if (j > i) {
                    break;
                } else {
                    driver.get("https://www.instagram.com");
                    user = new WebDriverWait(driver, Duration.ofSeconds(100))
                            .until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginForm > div > div:nth-child(1) > div > label > input")));
                    user.sendKeys(contas[0][j]);
                    pwd = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#loginForm > div > div:nth-child(2) > div > label > input")));
                    pwd.sendKeys(contas[1][j]);
                    botaoLogin = driver.findElement(By.cssSelector("#loginForm > div > div:nth-child(3)"));
                    botaoLogin.click();
                }
            }
        }
    }

}
