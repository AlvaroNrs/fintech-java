package br.com.fiap.model;

import java.time.LocalDate;

public class Servico {
    private int cd_servico;
    private int cd_conta;
    private String nm_servico;
    private double vl_servico;
    private LocalDate dt_servico;
    private String dsc_servico;

    public Servico(int cd_servico, int cd_conta, String nm_servico, double vl_servico, LocalDate dt_servico, String dsc_servico) {
        this.cd_servico = cd_servico;
        this.cd_conta = cd_conta;
        this.nm_servico = nm_servico;
        this.vl_servico = vl_servico;
        this.dt_servico = dt_servico;
        this.dsc_servico = dsc_servico;
    }

    public Servico(int cd_conta, String nm_servico, double vl_servico, LocalDate dt_servico, String dsc_servico) {
        this.cd_conta = cd_conta;
        this.nm_servico = nm_servico;
        this.vl_servico = vl_servico;
        this.dt_servico = dt_servico;
        this.dsc_servico = dsc_servico;
    }

    public Servico(){}

    public int getCd_servico() {
        return cd_servico;
    }

    public void setCd_servico(int cd_servico) {
        this.cd_servico = cd_servico;
    }

    public int getCd_conta() {
        return cd_conta;
    }

    public void setCd_conta(int cd_conta) {
        this.cd_conta = cd_conta;
    }

    public String getNm_servico() {
        return nm_servico;
    }

    public void setNm_servico(String nm_servico) {
        this.nm_servico = nm_servico;
    }

    public double getVl_servico() {
        return vl_servico;
    }

    public void setVl_servico(double vl_servico) {
        this.vl_servico = vl_servico;
    }

    public LocalDate getDt_servico() {
        return dt_servico;
    }

    public void setDt_servico(LocalDate dt_servico) {
        this.dt_servico = dt_servico;
    }

    public String getDsc_servico() {
        return dsc_servico;
    }

    public void setDsc_servico(String dsc_servico) {
        this.dsc_servico = dsc_servico;
    }
}
