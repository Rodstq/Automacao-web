package org.example;


public class Main extends Conta {
    public static void main(String[] args) throws InterruptedException {


        Conta conta = new Conta();

        conta.contaIG = "leticiabastos32";
        conta.senhaIG = "botnumero10";
        conta.logins();
        conta.irParaAcoes();
        conta.realizarAcoes();
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