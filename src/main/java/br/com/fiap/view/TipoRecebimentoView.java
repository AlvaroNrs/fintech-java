package br.com.fiap.view;

import br.com.fiap.dao.TipoRecebimentoDao;
import br.com.fiap.model.TipoRecebimento;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoRecebimentoView {
    public static List<TipoRecebimento> listaTiposRecebimento = new ArrayList<>();
    public static void main(String[] args) {
        TipoRecebimentoDao dao;
        try {
            dao = new TipoRecebimentoDao();
            //testarCadastro(dao);
            listar(dao);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void testarCadastro(TipoRecebimentoDao dao) {
        TipoRecebimento tipoRecebimento1 = new TipoRecebimento("Freelance");
        TipoRecebimento tipoRecebimento2 = new TipoRecebimento("Salário");
        TipoRecebimento tipoRecebimento3 = new TipoRecebimento("Recebimento de Dívida");
        TipoRecebimento tipoRecebimento4 = new TipoRecebimento("Venda");
        TipoRecebimento tipoRecebimento5 = new TipoRecebimento("Aluguéis");
        listaTiposRecebimento.add(tipoRecebimento1);
        listaTiposRecebimento.add(tipoRecebimento2);
        listaTiposRecebimento.add(tipoRecebimento3);
        listaTiposRecebimento.add(tipoRecebimento4);
        listaTiposRecebimento.add(tipoRecebimento5);
        try {
            for (TipoRecebimento revenueType : listaTiposRecebimento){
                dao.insert(revenueType);
                System.out.println("Tipo de Recebimento " + revenueType.getTipo_recebimento() + " cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar tipo de conta: " + e.getMessage());
        }
    }

    private static void listar(TipoRecebimentoDao dao) {
        try {
            listaTiposRecebimento = dao.getAll();
            System.out.println("Lista de Tipos de Recebimento: ");
            for (TipoRecebimento investimentType : listaTiposRecebimento) {
                System.out.println(investimentType.getCd_tipo_recebimento() + " - " + investimentType.getTipo_recebimento());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar tipos de recebimento: " + e.getMessage());
        }
    }
}
