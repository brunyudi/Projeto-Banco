package Conta;

import java.time.LocalDate;

public class Operacao {
    private Tipo tipooperacao;
    private float valor;
    private LocalDate dataoperacao;
    private float saldo;
    private int numero;

    public Operacao(Tipo tipooperacao, int numero, float valor, float saldo, LocalDate dataoperacao){;
        this.tipooperacao = tipooperacao;
        this.valor = valor;
        this.dataoperacao = dataoperacao;
        this.numero = numero;
        this.saldo = saldo;
    }

    public Tipo getTipooperacao() {
        return tipooperacao;
    }

    public void setTipooperacao(Tipo tipooperacao) {
        this.tipooperacao = tipooperacao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public LocalDate getDataoperacao() {
        return dataoperacao;
    }

    public void setDataoperacao(LocalDate dataoperacao) {
        this.dataoperacao = dataoperacao;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
