package br.com.fiap.view;

import br.com.fiap.dao.RecebimentoDao;
import br.com.fiap.model.Recebimento;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecebimentoView {

    public static List<Recebimento> listaRecebimentos= new ArrayList<> ();

    public static void main(String[] args) {
       RecebimentoDao dao;
        try {
            dao = new RecebimentoDao ();
            //testarCadastro(dao);
            listar(dao);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }



    private static void testarCadastro(RecebimentoDao dao) {
        Recebimento  Recebimento1 = new Recebimento (1, 1);
        Recebimento  Recebimento2 = new Recebimento (2, 2);
        Recebimento  Recebimento3 = new Recebimento (3, 3);
        Recebimento  Recebimento4 = new Recebimento (4, 4);
        Recebimento  Recebimento5 = new Recebimento (5, 5);


        listaRecebimentos.add(Recebimento1);
        listaRecebimentos.add(Recebimento2);
        listaRecebimentos.add(Recebimento3);
        listaRecebimentos.add(Recebimento4);
        listaRecebimentos.add(Recebimento5);

        try {
            for (Recebimento receber : listaRecebimentos){
                dao.insert(receber);
                System.out.println("Tipo de Recebimento " + receber.getCd_recebimento ()+ " cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar o recebimento: " + e.getMessage());
        }
    }

    private static void listar(RecebimentoDao dao) {
        try {
            listaRecebimentos = dao.getAll();
            System.out.println("Lista Recebimento: ");
            for (Recebimento recebiment : listaRecebimentos) {
                System.out.println(recebiment.getCd_tipo_recebimento() + " - " + recebiment.getCd_tipo_recebimento ());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar tipos de recebimento: " + e.getMessage());
        }
    }




}
