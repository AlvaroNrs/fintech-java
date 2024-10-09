package br.com.fiap.model;

import java.time.LocalDate;

public class Transferencia {

    private int cd_transferencia;
    private int cd_conta_beneficiaria;
    private int cd_conta_beneficiada;
    private double vl_transferencia;
    private LocalDate dt_transferencia;

    public Transferencia(int cd_transferencia, int cd_conta_beneficiaria, int cd_conta_beneficiada, double vl_transferencia, LocalDate dt_transferencia) {
        this.cd_transferencia = cd_transferencia;
        this.cd_conta_beneficiaria = cd_conta_beneficiaria;
        this.cd_conta_beneficiada = cd_conta_beneficiada;
        this.vl_transferencia = vl_transferencia;
        this.dt_transferencia = dt_transferencia;
    }

    public Transferencia(int cd_conta_beneficiaria, int cd_conta_beneficiada, double vl_transferencia, LocalDate dt_transferencia) {
        this.cd_conta_beneficiaria = cd_conta_beneficiaria;
        this.cd_conta_beneficiada = cd_conta_beneficiada;
        this.vl_transferencia = vl_transferencia;
        this.dt_transferencia = dt_transferencia;
    }

    public Transferencia(){}

    public int getCd_transferencia() {
        return cd_transferencia;
    }

    public void setCd_transferencia(int cd_transferencia) {
        this.cd_transferencia = cd_transferencia;
    }

    public int getCd_conta_beneficiaria() {
        return cd_conta_beneficiaria;
    }

    public void setCd_conta_beneficiaria(int cd_conta_beneficiaria) {
        this.cd_conta_beneficiaria = cd_conta_beneficiaria;
    }

    public int getCd_conta_beneficiada() {
        return cd_conta_beneficiada;
    }

    public void setCd_conta_beneficiada(int cd_conta_beneficiada) {
        this.cd_conta_beneficiada = cd_conta_beneficiada;
    }

    public double getVl_transferencia() {
        return vl_transferencia;
    }

    public void setVl_transferencia(double vl_transferencia) {
        this.vl_transferencia = vl_transferencia;
    }

    public LocalDate getDt_transferencia() {
        return dt_transferencia;
    }

    public void setDt_transferencia(LocalDate dt_transferencia) {
        this.dt_transferencia = dt_transferencia;
    }
}
