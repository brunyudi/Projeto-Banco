package Conta;


public abstract class Conta {
    private int numero;
    private String nomecorrentista;
    private int cpf;
    private float saldo;
    private float deposito;
    private float saque;

    public Conta(int numero, String nomecorrentista, int cpf){
        super();
        this.numero = numero;
        this.nomecorrentista = nomecorrentista;
        this.cpf = cpf;
        saldo = 0;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNomecorrentista() {
        return nomecorrentista;
    }

    public void setNomecorrentista(String nomecorrentista) {
        this.nomecorrentista = nomecorrentista;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getDeposito() {
        return deposito;
    }

    public void setDeposito(float deposito) {
        this.deposito = deposito;
    }

    public float getSaque() {
        return saque;
    }

    public void setSaque(float saque) {
        this.saque = saque;
    }




    public void depositar(float deposito){
        if(deposito > 0){
            this.saldo += deposito;
        }
    }

    public void sacar(float saque){
        if(saque > 0 && saldo >= saque){
            this.saldo -= saque;
        }
        else{
            System.out.println("\n# Saldo indisponivel!!!!");
        }
    }

}