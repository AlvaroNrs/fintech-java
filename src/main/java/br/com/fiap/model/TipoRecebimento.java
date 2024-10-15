package br.com.fiap.model;

public class TipoRecebimento {
    private int cd_tipo_recebimento;
    private String tipo_recebimento;

    public TipoRecebimento(int cd_tipo_recebimento, String tipo_recebimento) {
        this.cd_tipo_recebimento = cd_tipo_recebimento;
        this.tipo_recebimento = tipo_recebimento;
    }
    public TipoRecebimento(String tipo_recebimento) {
        this.tipo_recebimento = tipo_recebimento;
    }

    public TipoRecebimento(){}

    public int getCd_tipo_recebimento() {
        return cd_tipo_recebimento;
    }

    public void setCd_tipo_recebimento(int cd_tipo_recebimento) {
        this.cd_tipo_recebimento = cd_tipo_recebimento;
    }

    public String getTipo_recebimento() {
        return tipo_recebimento;
    }

    public void setTipo_recebimento(String tipo_recebimento) {
        this.tipo_recebimento = tipo_recebimento;
    }
}
