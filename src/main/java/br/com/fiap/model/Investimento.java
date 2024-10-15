package br.com.fiap.model;

public class Investimento {
    private int cd_investimento;
    private int cd_servico;
    private int cd_tipo_investimento;

    public Investimento(int cd_investimento, int cd_servico, int cd_tipo_investimento) {
        this.cd_investimento = cd_investimento;
        this.cd_servico = cd_servico;
        this.cd_tipo_investimento = cd_tipo_investimento;
    }

    public Investimento(int cd_servico, int cd_tipo_investimento) {
        this.cd_servico = cd_servico;
        this.cd_tipo_investimento = cd_tipo_investimento;
    }

    public Investimento(){}

    public int getCd_investimento() {
        return cd_investimento;
    }

    public void setCd_investimento(int cd_investimento) {
        this.cd_investimento = cd_investimento;
    }

    public int getCd_servico() {
        return cd_servico;
    }

    public void setCd_servico(int cd_servico) {
        this.cd_servico = cd_servico;
    }

    public int getCd_tipo_investimento() {
        return cd_tipo_investimento;
    }

    public void setCd_tipo_investimento(int cd_tipo_investimento) {
        this.cd_tipo_investimento = cd_tipo_investimento;
    }
}
