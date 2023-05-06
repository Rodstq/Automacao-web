package org.example;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        while(true) {

//            WebDriver driver = new ChromeDriver();
//            driver.get("https://www.google.com");
//            driver.switchTo().newWindow(WindowType.TAB);
////            driver.wait(1000);
//
//            driver.wait(100,0);
//            driver.close();

            Conta conta = new Conta();
            conta.contaIG = "rod_stqtic";
            conta.senhaIG= "15466231";
            conta.logins();
            conta.irParaAcoes();
        }

        //movimentarContas();

    }

    public static void movimentarContas(){
        String[][] contas = {
                {"conta1", "conta2", "conta3" ,"conta4" ,"conta5" ,"conta6", "conta7"},
                {"senha1","senha2","senha3","senha4","senha5","senha6", "senha 7"}
        };

        for (int i = 0; i < contas[0].length; i++) {
            System.out.println("===== CONTA A POSTAR : " + contas[0][i] + " SENHA : " + contas[1][i] + "=====");
            for (int j = 0; j < contas[0].length; j++) {
                System.out.println("CONTA A CURTIR : " + contas[0][j] + " SENHA : " + contas[1][j]);
            }
        }
    }
}