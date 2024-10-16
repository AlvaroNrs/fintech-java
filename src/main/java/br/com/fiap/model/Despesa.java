package br.com.fiap.model;

public class Despesa {
    private int cd_despesa;
    private int cd_servico;
    private int cd_tipo_despesa;

    public Despesa(int cd_despesa, int cd_servico, int cd_tipo_despesa) {
        this.cd_despesa = cd_despesa;
        this.cd_servico = cd_servico;
        this.cd_tipo_despesa = cd_tipo_despesa;
    }

    public Despesa(int cd_servico, int cd_tipo_despesa) {
        this.cd_servico = cd_servico;
        this.cd_tipo_despesa = cd_tipo_despesa;
    }

    public Despesa(){}

    public int getCd_despesa() {
        return cd_despesa;
    }

    public void setCd_despesa(int cd_despesa) {
        this.cd_despesa = cd_despesa;
    }

    public int getCd_servico() {
        return cd_servico;
    }

    public void setCd_servico(int cd_servico) {
        this.cd_servico = cd_servico;
    }

    public int getCd_tipo_despesa() {
        return cd_tipo_despesa;
    }

    public void setCd_tipo_despesa(int cd_tipo_despesa) {
        this.cd_tipo_despesa = cd_tipo_despesa;
    }
}
