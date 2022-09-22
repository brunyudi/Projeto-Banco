package Conta;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListaOperacao {
    private ArrayList<Operacao> alOperacao;


    public ListaOperacao(){
        super();
        this.alOperacao = new ArrayList<Operacao>();
    }

    public Tipo addDeposito(int numero, float valor, float saldo, LocalDate dataoperacao){
        Tipo tipooperacao = Tipo.DEPOSITO;
        Operacao operacao = new Operacao(tipooperacao, numero, valor, saldo, dataoperacao);
        alOperacao.add(operacao);
        return tipooperacao;
    }

    public Tipo addSaque(int numero, float valor, float saldo, LocalDate dataoperacao){
        Tipo tipooperacao = Tipo.SAQUE;
        Operacao operacao = new Operacao(tipooperacao, numero, valor, saldo, dataoperacao);
        alOperacao.add(operacao);
        return tipooperacao;
    }

    public Tipo addCorrecao(int numero, float valor, float saldo, LocalDate dataoperacao){
        Tipo tipooperacao = Tipo.CORRECAO;
        Operacao operacao = new Operacao(tipooperacao, numero, valor, saldo, dataoperacao);
        alOperacao.add(operacao);
        return tipooperacao;
    }

    public Tipo addPixOut(int numero, float valor, float saldo, LocalDate dataoperacao){
        Tipo tipooperacao = Tipo.PIXOUT;
        Operacao operacao = new Operacao(tipooperacao, numero, valor, saldo, dataoperacao);
        alOperacao.add(operacao);
        return tipooperacao;
    }

    public Tipo addPixIn(int numero, float valor, float saldo, LocalDate dataoperacao){
        Tipo tipooperacao = Tipo.PIXIN;
        Operacao operacao = new Operacao(tipooperacao, numero, valor, saldo, dataoperacao);
        alOperacao.add(operacao);
        return tipooperacao;
    }



    public int getListaOperacaoSize(){
        return alOperacao.size();
    }

    public Operacao getOperacao(int i){
        return alOperacao.get(i);
    }

}
