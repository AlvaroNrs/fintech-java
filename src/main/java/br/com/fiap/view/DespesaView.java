package br.com.fiap.view;

import br.com.fiap.dao.DespesaDao;
import br.com.fiap.model.Despesa;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DespesaView {

    public static List<Despesa> listaDespesas= new ArrayList<> ();

    public static void main(String[] args) {
        DespesaDao dao;
        try {
            dao = new DespesaDao ();
            //testarCadastro(dao);
            listar(dao);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }



    private static void testarCadastro(DespesaDao dao) {
        Despesa  Despesa1 = new Despesa (1, 1);
        Despesa  Despesa2 = new Despesa (2, 2);
        Despesa  Despesa3 = new Despesa (3, 3);
        Despesa  Despesa4 = new Despesa (4, 4);
        Despesa  Despesa5 = new Despesa (5, 5);


        listaDespesas.add(Despesa1);
        listaDespesas.add(Despesa2);
        listaDespesas.add(Despesa3);
        listaDespesas.add(Despesa4);
        listaDespesas.add(Despesa5);

        try {
            for (Despesa receber : listaDespesas){
                dao.insert(receber);
                System.out.println("Tipo de Despesa " + receber.getCd_servico ()+ " cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar o recebimento: " + e.getMessage());
        }
    }

    private static void listar(DespesaDao dao) {
        try {
            listaDespesas = dao.getAll();
            System.out.println("Lista Despesa: ");
            for (Despesa expense : listaDespesas) {
                System.out.println(expense.getCd_despesa() + " - " + expense.getCd_servico() + " - " + expense.getCd_tipo_despesa());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar tipos de recebimento: " + e.getMessage());
        }
    }




}
