package Banco;

import Conta.*;
import Interfaces.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Banco {

    private static ListaContas alContas = new ListaContas();
    private static ListaPix alPix = new ListaPix();
    private static ListaOperacao alOperacao = new ListaOperacao();

    static Scanner teclado = new Scanner(System.in);


    public static void main(String[] args){

        int numero;
        numero = alContas.addCorrente("Joao",111111111);
        System.out.println("Conta criada com numero " + numero);
        numero = alContas.addCorrente("Pedro",987654321);
        System.out.println("Conta criada com numero " + numero);

        numero = alContas.addPoupanca("Maria",123456789);
        System.out.printf("Conta criada com numero " + numero);

        for(int i= 0; i < alContas.getListaContasSize(); i++){
            Conta conta = alContas.getConta(i);
            System.out.println("Nome do dono da conta: " + conta.getNomecorrentista());
            System.out.println("Cpf do dono da conta: " + conta.getCpf());
            System.out.println("Numero da conta: " + conta.getNumero());
        }



        String nomecorrentista;
        int cpf;
        String confere;
        float deposito;
        float saque;
        float saldo;
        Tipo operacao;
        int cpfcadastrar;
        int cpfremetente;
        int cpfdestinatario;
        float valorpix;


        int opcao;

        do{
            System.out.println("\n# Menu principal do Banco\n");
            System.out.println("   0 - Fechar o sistema");
            System.out.println("   1 - Criar conta corrente");
            System.out.println("   2 - Criar conta poupanca");
            System.out.println("   3 - Efetuar deposito");
            System.out.println("   4 - Efetuar saque");
            System.out.println("   5 - Aplicar correcao");
            System.out.println("   6 - Cadastrar Pix");
            System.out.println("   7 - Efetuar Pix");
            System.out.println("   8 - Consultar extrato");
            System.out.println("   9 - Listar contas");         //Apenas para teste
            System.out.println("  10 - Listar cpf pix");        //Apenas para teste
            System.out.println("\n     Qual a escolha?: ");

            opcao = teclado.nextInt();
            teclado.nextLine();
            switch (opcao){
                case 1:
                    System.out.println("\n# Criar conta corrente \n");
                    System.out.print("    Qual o seu nome?");
                    nomecorrentista = teclado.nextLine();
                    System.out.print("    Qual o seu cpf? (Apenas numeros) ");
                    cpf = teclado.nextInt();
                    numero = alContas.addCorrente(nomecorrentista, cpf);
                    System.out.println("O numero da conta criada e: "+ numero);
                    break;
                case 2:
                    System.out.println("\n# Criar conta poupanca \n");
                    System.out.print("    Qual o seu nome?");
                    nomecorrentista = teclado.nextLine();
                    System.out.print("    Qual o seu cpf? (Apenas numeros) ");
                    cpf = teclado.nextInt();
                    numero = alContas.addPoupanca(nomecorrentista, cpf);
                    System.out.println("O numero da conta criada e: "+ numero);
                    break;
                case 3:
                    System.out.println("\n# Depositar dinheiro \n");
                    System.out.print("    Qual o numero da conta em que sera depositado?");
                    numero = teclado.nextInt();
                    for(int i = 0; i<alContas.getListaContasSize(); i++){
                        Conta conta = alContas.getConta(i);
                        if(conta.getNumero() == numero){
                            //System.out.println("    Dono da conta: " + conta.getNomecorrentista());
                            //System.out.println("    Confere? S/N ");
                            //confere = teclado.nextLine();
                            //if (confere.toUpperCase().charAt(0) == 'S'){
                                System.out.println("Qual o valor que quer depositar? ");
                                deposito = teclado.nextFloat();

                                conta.depositar(deposito);

                                operacao = alOperacao.addDeposito(conta.getNumero(), deposito, conta.getSaldo(), LocalDate.now());
                                System.out.println("   Operacao realizada com sucesso.");
                            //}
                        }
                    }
                    break;
                case 4:
                    System.out.println("\n# Sacar dinheiro \n");
                    System.out.println("    Qual o numero da conta da qual quer sacar? ");
                    numero = teclado.nextInt();
                    for(int i=0; i<alContas.getListaContasSize(); i++){
                        Conta conta = alContas.getConta(i);
                        if (conta.getNumero() == numero){
                            System.out.println("Qual o valor que quer sacar? ");
                            saque = teclado.nextFloat();

                            conta.sacar(saque);

                            operacao = alOperacao.addSaque(conta.getNumero(),saque, conta.getSaldo(), LocalDate.now());
                            System.out.println("   Operacao realizada com sucesso.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("\n Aplicar correcao monetaria");
                    for(int i=0; i<alContas.getListaContasSize();i++){
                        Conta conta = alContas.getConta(i);
                        if(conta instanceof Poupanca){
                            Poupanca poupanca = (Poupanca)conta;
                            poupanca.aplicarCorrecao();
                            operacao = alOperacao.addCorrecao(conta.getNumero(), poupanca.getCorrecao(), conta.getSaldo(), LocalDate.now());
                            System.out.println("   Operacao realizada com sucesso.");
                        }
                    }
                    break;
                case 6:
                    System.out.println("\n# Cadastrar Pix ");
                    System.out.println("\n Qual o seu cpf? (Apenas numeros) ");
                    cpfcadastrar = teclado.nextInt();
                    for(int i=0; i<alContas.getListaContasSize();i++){
                        Conta conta = alContas.getConta(i);
                        if(conta instanceof Corrente){
                            Corrente corrente = (Corrente)conta;
                            if(corrente.getCpf() == cpfcadastrar) {
                                numero = alPix.addPix(corrente.getNomecorrentista(), corrente.getCpf());
                                System.out.println("\n Pix cadastrado com sucesso");
                            }
                        }
                    }
                    break;
                case 7:
                    System.out.println("\n# Efetuar Pix ");
                    System.out.println("\n Qual o seu cpf? (Apenas numeros) ");
                    cpfremetente = teclado.nextInt();
                    for (int i=0; i<alPix.getListaPixSize();i++){
                        Corrente corrente = alPix.getPix(i);
                        if(corrente.getCpf() == cpfremetente){
                            System.out.println("\n Qual o cpf da conta destinataria? (Apenas numeros) ");
                            cpfdestinatario = teclado.nextInt();
                            for (int x=0; x<alPix.getListaPixSize(); x++){
                                Corrente corrente2 = alPix.getPix(x);
                                if(corrente2.getCpf() == cpfdestinatario){
                                    System.out.println("\n Qual o valor do Pix? ");
                                    valorpix = teclado.nextFloat();
                                    if (valorpix > 0 && valorpix >= corrente.getSaldo()) {

                                        corrente.fazerPix(valorpix);

                                        operacao = alOperacao.addPixOut(corrente.getNumero(),valorpix, corrente.getSaldo(), LocalDate.now());

                                        corrente2.receberPix(valorpix);

                                        operacao = alOperacao.addPixIn(corrente2.getNumero(), valorpix, corrente2.getSaldo(), LocalDate.now());

                                        System.out.println(" Pix realizado com sucesso.");
                                    }
                                }
                            }
                        }
                    }
                    break;
                case 8:
                    System.out.println("\n Consultar extrato da conta");
                    System.out.println("\n Qual o numero da conta para consultar o extrato? ");
                    numero = teclado.nextInt();
                    for(int i=0; i<alOperacao.getListaOperacaoSize();i++){
                        Operacao operacaoconta = alOperacao.getOperacao(i);
                        if(operacaoconta.getNumero() == numero){
                            System.out.println("Tipo: " + operacaoconta.getTipooperacao()+" / Valor: "+operacaoconta.getValor()+" / Saldo: "+operacaoconta.getSaldo()+" / Data: "+operacaoconta.getDataoperacao());
                        }
                    }
                    break;
                case 9:
                    System.out.println("\n Lista de contas: ");
                    for (int i=0; i<alContas.getListaContasSize();i++){
                        Conta conta = alContas.getConta(i);
                        System.out.println("Num da conta: "+conta.getNumero()+" / Titular da conta: "+conta.getNomecorrentista()+" / Cpf do titular: "+conta.getCpf());
                    }
                    break;
                case 10:
                    System.out.println("\n Lista de cpf habilitados para Pix: ");
                    for (int i=0; i<alPix.getListaPixSize();i++){
                        Corrente corrente = alPix.getPix(i);
                        System.out.println("cpf: " + corrente.getCpf());
                    }
            }
        }
        while (opcao != 0);
        teclado.close();

    }

}
