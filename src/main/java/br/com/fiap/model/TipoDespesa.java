package br.com.fiap.model;

public class TipoDespesa {

    private int cd_tipo_despesa;
    private String tipo_despesa;


    public TipoDespesa(int cd_tipo_despesa, String tipo_despesa) {
        this.cd_tipo_despesa = cd_tipo_despesa;
        this.tipo_despesa = tipo_despesa;
    }

    public TipoDespesa(String tipo_despesa) {
        this.tipo_despesa = tipo_despesa;
    }

    public TipoDespesa(){}

    public int getCd_tipo_despesa() {
        return cd_tipo_despesa;
    }

    public void setCd_tipo_despesa(int cd_tipo_despesa) {
        this.cd_tipo_despesa = cd_tipo_despesa;
    }

    public String getTipo_despesa() {
        return tipo_despesa;
    }

    public void setTipo_despesa(String tipo_despesa) {
        this.tipo_despesa = tipo_despesa;
    }
}
