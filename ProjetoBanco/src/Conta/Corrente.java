package Conta;

import Interfaces.Pix;
import java.util.*;

public class Corrente extends Conta implements Pix {

    static Scanner teclado = new Scanner(System.in);
    private float valorpix;
    private int cpfdestinatario;
    private int cpfremetente;
    private float saldopix;

    public Corrente(int numero, String nomecorrentista, int cpf){super(numero, nomecorrentista, cpf);}

    @Override
    public void fazerPix(float valorpix) {
        saldopix = getSaldo()-valorpix;
        setSaldo(saldopix);
    }

    @Override
    public void receberPix(float valorpix) {
        setSaldo(getSaldo()+valorpix);
    }

    @Override
    public void cadastrarPix() {
    }

}
