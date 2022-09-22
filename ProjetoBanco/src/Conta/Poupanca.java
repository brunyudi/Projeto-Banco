package Conta;

import Interfaces.Remunerada;

public class Poupanca extends Conta implements Remunerada {

    private float porcentcorrecao;
    private float correcao;

    public Poupanca(int numero, String nomecorrentista, int cpf){super(numero, nomecorrentista, cpf);}

    @Override
    public void aplicarCorrecao() {
        if(getSaldo()>0 && getSaldo() < 1000){
            porcentcorrecao = 0.005F;}
        if(getSaldo()>=1000 && getSaldo() < 10000){
            porcentcorrecao = 0.01F;}
        if(getSaldo()>=10000){
            porcentcorrecao = 0.015F;}

        correcao = getSaldo()*porcentcorrecao;
        setSaldo(getSaldo()+correcao);

    }

    public float getPorcentcorrecao() {
        return porcentcorrecao;
    }

    public void setPorcentcorrecao(float porcentcorrecao) {
        this.porcentcorrecao = porcentcorrecao;
    }

    public float getCorrecao() {
        return correcao;
    }

    public void setCorrecao(float correcao) {
        this.correcao = correcao;
    }
}
