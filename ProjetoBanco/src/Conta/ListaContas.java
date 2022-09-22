package Conta;

import java.util.ArrayList;

public class ListaContas {
    private ArrayList<Conta> alContas;

    public ListaContas(){
        super();
        this.alContas = new ArrayList<Conta>();
    }

    public int addCorrente(String nomecorrentista, int cpf){
        int numero = alContas.size() + 1;
        Conta conta = new Corrente(numero, nomecorrentista, cpf);
        alContas.add(conta);
        return numero;
    }
    public int addPoupanca(String nomecorrentista, int cpf){
        int numero = alContas.size() + 1;
        Conta conta = new Poupanca(numero, nomecorrentista, cpf);
        alContas.add(conta);
        return numero;
    }
    public int getListaContasSize(){
        return alContas.size();
    }
    public Conta getConta(int i) {
        return alContas.get(i);
    }
}
