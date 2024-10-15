package br.com.fiap.view;

import br.com.fiap.dao.InvestimentoDao;
import br.com.fiap.model.Investimento;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoView {
    public static List<Investimento> listaInvestimentos = new ArrayList<>();
    public static void main(String[] args) {
        InvestimentoDao dao;
        try {
            dao = new InvestimentoDao();
            //testarCadastro(dao);
            listar(dao);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void testarCadastro(InvestimentoDao dao) {
        Investimento Investimento1 = new Investimento(1, 1);
        Investimento Investimento2 = new Investimento(2,2);
        Investimento Investimento3 = new Investimento(3,3);
        Investimento Investimento4 = new Investimento(4,4);
        Investimento Investimento5 = new Investimento(5,5);
        listaInvestimentos.add(Investimento1);
        listaInvestimentos.add(Investimento2);
        listaInvestimentos.add(Investimento3);
        listaInvestimentos.add(Investimento4);
        listaInvestimentos.add(Investimento5);
        try {
            for (Investimento investiment : listaInvestimentos){
                dao.insert(investiment);
                System.out.println("Investimento " + investiment.getCd_servico() + " cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar Investimento: " + e.getMessage());
        }
    }

    private static void listar(InvestimentoDao dao) {
        try {
            listaInvestimentos = dao.getAll();
            System.out.println("Lista de Investimentos: ");
            for (Investimento investiment : listaInvestimentos) {
                System.out.println(investiment.getCd_investimento() + " - " + investiment.getCd_servico() + " - " + investiment.getCd_tipo_investimento());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar investimentos: " + e.getMessage());
        }
    }
}
