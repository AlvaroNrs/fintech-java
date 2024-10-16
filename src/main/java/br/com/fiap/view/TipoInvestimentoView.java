package br.com.fiap.view;

import br.com.fiap.dao.TipoInvestimentoDao;
import br.com.fiap.model.TipoInvestimento;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoInvestimentoView {

    public static List<TipoInvestimento> listaTiposInvestimentos = new ArrayList<>();

    public static void main(String[] args) {
        TipoInvestimentoDao dao;
        try {
            dao = new TipoInvestimentoDao();
            //testarCadastro(dao);
            listar(dao);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void testarCadastro(TipoInvestimentoDao dao) {
        TipoInvestimento tipoInvestimento1 = new TipoInvestimento("Poupança");
        TipoInvestimento tipoInvestimento2 = new TipoInvestimento("CDB");
        TipoInvestimento tipoInvestimento3 = new TipoInvestimento("Ações");
        TipoInvestimento tipoInvestimento4 = new TipoInvestimento("Imóveis");
        TipoInvestimento tipoInvestimento5 = new TipoInvestimento("Tesouro Direto");
        listaTiposInvestimentos.add(tipoInvestimento1);
        listaTiposInvestimentos.add(tipoInvestimento2);
        listaTiposInvestimentos.add(tipoInvestimento3);
        listaTiposInvestimentos.add(tipoInvestimento4);
        listaTiposInvestimentos.add(tipoInvestimento5);
        try {
            for (TipoInvestimento investimentType : listaTiposInvestimentos){
                dao.insert(investimentType);
                System.out.println("Tipo de Investimento " + investimentType.getTipo_investimento() + " cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar tipo de conta: " + e.getMessage());
        }
    }

    private static void listar(TipoInvestimentoDao dao) {
        try {
            listaTiposInvestimentos = dao.getAll();
            System.out.println("Lista de Tipo de Investimento: ");
            for (TipoInvestimento investimentType : listaTiposInvestimentos) {
                System.out.println(investimentType.getCd_tipo_investimento() + " - " + investimentType.getTipo_investimento());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar tipos de contas: " + e.getMessage());
        }
    }
}
