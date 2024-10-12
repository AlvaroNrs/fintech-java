package br.com.fiap.model;

public class TipoConta {

    private int cd_tipo_conta;

    private String tipo_conta;

    public TipoConta(int cd_tipo_conta, String tipo_conta) {
        this.cd_tipo_conta = cd_tipo_conta;
        this.tipo_conta = tipo_conta;
    }

    public TipoConta(String tipo_conta) {
        this.tipo_conta = tipo_conta;
    }

    public TipoConta(){
    }

    public int getCd_tipo_conta() {
        return cd_tipo_conta;
    }

    public void setCd_tipo_conta(int cd_tipo_conta) {
        this.cd_tipo_conta = cd_tipo_conta;
    }

    public String getTipo_conta() {
        return tipo_conta;
    }

    public void setTipo_conta(String tipo_conta) {
        this.tipo_conta = tipo_conta;
    }
}
