package Conta;

import java.util.ArrayList;

public class ListaPix {
    private ArrayList<Corrente> alPix;

    public ListaPix(){
        super();
        this.alPix = new ArrayList<Corrente>();
    }

    public int addPix (String nomecorrentista, int cpf){
        int numero = alPix.size() + 1;
        Corrente corrente = new Corrente(numero, nomecorrentista, cpf);
        alPix.add(corrente);
        return numero;
    }

    public int getListaPixSize(){return alPix.size();}

    public Corrente getPix(int i){return alPix.get(i);}

}
