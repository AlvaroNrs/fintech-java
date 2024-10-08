package br.com.fiap.model;

public class Conta {
    private int cd_conta;
    private String nm_conta;
    private int cd_usuario;
    private String dsc_conta;
    private int cd_tipo_conta;
    private double saldo_conta;

    public Conta(int cd_conta, String nm_conta, int cd_usuario, String dsc_conta, int cd_tipo_conta, double saldo_conta) {
        this.cd_conta = cd_conta;
        this.nm_conta = nm_conta;
        this.cd_usuario = cd_usuario;
        this.dsc_conta = dsc_conta;
        this.cd_tipo_conta = cd_tipo_conta;
        this.saldo_conta = saldo_conta;
    }

    public Conta(String nm_conta, int cd_usuario, String dsc_conta, int cd_tipo_conta, double saldo_conta) {
        this.nm_conta = nm_conta;
        this.cd_usuario = cd_usuario;
        this.dsc_conta = dsc_conta;
        this.cd_tipo_conta = cd_tipo_conta;
        this.saldo_conta = saldo_conta;
    }

    public Conta(){}

    public int getCd_conta() {
        return cd_conta;
    }

    public void setCd_conta(int cd_conta) {
        this.cd_conta = cd_conta;
    }

    public String getNm_conta() {
        return nm_conta;
    }

    public void setNm_conta(String nm_conta) {
        this.nm_conta = nm_conta;
    }

    public int getCd_usuario() {
        return cd_usuario;
    }

    public void setCd_usuario(int cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public String getDsc_conta() {
        return dsc_conta;
    }

    public void setDsc_conta(String dsc_conta) {
        this.dsc_conta = dsc_conta;
    }

    public int getCd_tipo_conta() {
        return cd_tipo_conta;
    }

    public void setCd_tipo_conta(int cd_tipo_conta) {
        this.cd_tipo_conta = cd_tipo_conta;
    }

    public double getSaldo_conta() {
        return saldo_conta;
    }

    public void setSaldo_conta(double saldo_conta) {
        this.saldo_conta = saldo_conta;
    }
}
