package org.example;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import jdk.jfr.Timespan;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Conta {
    String contaIG;
    String senhaIG;

    WebDriver driver = new ChromeDriver();

    public  void logins(){
        // OBTER CONTA E SENHA DO OBJETO CRIADO
        contaIG = this.contaIG;
        senhaIG = this.senhaIG;
        // IR PRO INSTA E LOGAR
        driver.manage().window().fullscreen();
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
        senha.sendKeys("15466231");
        WebElement logar = driver.findElement(By.cssSelector("body > div.main-wrapper > div > div > div.col-lg-5.col-md-7.bg-white > div > form > div > div:nth-child(3) > button"));
        logar.click();
    }

    public void irParaAcoes(){
        // SELECIONAR BARRA LATERAL E IR PARA AREA DE ESCOLHER CONTA
        String contaig = contaIG;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
            while(true) {
                WebDriverWait disponivel = new WebDriverWait(driver, Duration.ofSeconds(100000));
                disponivel.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#tarefa")));

                WebElement acao = driver.findElement(By.cssSelector("#tarefa"));
                String acaoTexto = acao.getText();
                System.out.println(acaoTexto);

                if (acaoTexto.equals("[IG] Curtir Publicação [R$ 0,002]")) {
                    curtir();
                } else if (acaoTexto.equals("[IG] Seguir Perfil [R$ 0,005]")) {
                    seguir();
                }
            }


    }


    public void curtir(){

    WebElement curtir = driver.findElement(By.cssSelector("#btn-acessar"));
    curtir.click();

//    WebElement confirmar = driver.findElement(By.cssSelector("#btn-confirmar"));
//    confirmar.click();
    }


    public void seguir(){
        WebElement acessarSeguir = driver.findElement(By.cssSelector("#btn-acessar"));
        acessarSeguir.click();

        WebElement seguirIG = driver.findElement(By.cssSelector("#mount_0_0_xJ > div > div > div.x9f619.x1n2onr6.x1ja2u2z > div > div > div > div.x78zum5.xdt5ytf.x10cihs4.x1t2pt76.x1n2onr6.x1ja2u2z > div.x9f619.xnz67gz.x78zum5.x168nmei.x13lgxp2.x5pf9jr.xo71vjh.x1uhb9sk.x1plvlek.xryxfnj.x1c4vz4f.x2lah0s.x1q0g3np.xqjyukv.x1qjc9v5.x1oa3qoh.x1qughib > div.xh8yej3.x1gryazu.x10o80wk.x14k21rp.x1porb0y.x17snn68.x6osk4m > div:nth-child(2) > section > main > div > header > section > div.x6s0dn4.x78zum5.x1q0g3np.xs83m0k.xeuugli.x1n2onr6 > div.x9f619.xjbqb8w.x78zum5.x168nmei.x13lgxp2.x5pf9jr.xo71vjh.xmn8rco.x1n2onr6.x1plvlek.xryxfnj.x1c4vz4f.x2lah0s.x1q0g3np.xqjyukv.x1qjc9v5.x1oa3qoh.x1nhvcw1 > div > div.x9f619.xjbqb8w.x78zum5.x168nmei.x13lgxp2.x5pf9jr.xo71vjh.x1i64zmx.x1n2onr6.x1plvlek.xryxfnj.x1iyjqo2.x2lwn1j.xeuugli.xdt5ytf.xqjyukv.x1qjc9v5.x1oa3qoh.x1nhvcw1"));
        seguirIG.click();

        WebElement confirmar = driver.findElement(By.cssSelector("#btn-confirmar"));
        confirmar.click();
    }

}
