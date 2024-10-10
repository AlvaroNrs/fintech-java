package br.com.fiap.model;

public class TipoInvestimento {
    private int cd_tipo_investimento;
    private String tipo_investimento;

    public TipoInvestimento(int cd_tipo_investimento, String tipo_investimento) {
        this.cd_tipo_investimento = cd_tipo_investimento;
        this.tipo_investimento = tipo_investimento;
    }
    public TipoInvestimento(String tipo_investimento) {
        this.tipo_investimento = tipo_investimento;
    }

    public TipoInvestimento(){}

    public int getCd_tipo_investimento() {
        return cd_tipo_investimento;
    }

    public void setCd_tipo_investimento(int cd_tipo_investimento) {
        this.cd_tipo_investimento = cd_tipo_investimento;
    }

    public String getTipo_investimento() {
        return tipo_investimento;
    }

    public void setTipo_investimento(String tipo_investimento) {
        this.tipo_investimento = tipo_investimento;
    }
}
