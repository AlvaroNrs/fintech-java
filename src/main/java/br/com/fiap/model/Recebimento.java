package br.com.fiap.model;

public class Recebimento {

    private int cd_recebimento;
    private int cd_servico;
    private int cd_tipo_recebimento;




    public Recebimento(int cd_recebimento, int cd_servico, int cd_tipo_recebimento) {
        this.cd_recebimento = cd_recebimento;
        this.cd_servico = cd_servico;
        this.cd_tipo_recebimento = cd_tipo_recebimento;
    }

    public Recebimento(int cd_servico, int cd_tipo_recebimento) {
        this.cd_servico = cd_servico;
        this.cd_tipo_recebimento = cd_tipo_recebimento;
    }


    public Recebimento(){}

    public int getCd_recebimento() {
        return cd_recebimento;
    }

    public void setCd_recebimento(int cd_recebimento) {
        this.cd_recebimento = cd_recebimento;
    }

    public int getCd_servico() {
        return cd_servico;
    }

    public void setCd_servico(int cd_servico) {
        this.cd_servico = cd_servico;
    }

    public int getCd_tipo_recebimento() {
        return cd_tipo_recebimento;
    }

    public void setCd_tipo_recebimento(int cd_tipo_recebimento) {
        this.cd_tipo_recebimento = cd_tipo_recebimento;
    }
}
