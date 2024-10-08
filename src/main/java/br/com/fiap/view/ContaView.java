package br.com.fiap.view;

import br.com.fiap.dao.ContaDao;
import br.com.fiap.model.Conta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContaView {
    public static List<Conta> listaContas = new ArrayList<>();
    public static void main(String[] args) {
        ContaDao dao;
        try {
            dao = new ContaDao();
            //testarCadastro(dao);
            listar(dao);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void testarCadastro(ContaDao dao) {
        Conta conta1 = new Conta("Nome Conta 1", 1, "Descrição da Conta 1", 1, 1000.0);
        Conta conta2= new Conta("Nome Conta 2", 2, "Descrição da Conta 2", 2, 2000.0);
        Conta conta3= new Conta("Nome Conta 3", 3, "Descrição da Conta 3", 3, 3000.0);
        Conta conta4= new Conta("Nome Conta 4", 4, "Descrição da Conta 4", 4, 4000.0);
        Conta conta5= new Conta("Nome Conta 5", 5, "Descrição da Conta 5", 5, 5000.0);
        listaContas.add(conta1);
        listaContas.add(conta2);
        listaContas.add(conta3);
        listaContas.add(conta4);
        listaContas.add(conta5);
        try {
            for (Conta account : listaContas){
                dao.insert(account);
                System.out.println("Conta " + account.getNm_conta() + " cadastrada com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar conta: " + e.getMessage());
        }
    }

    private static void listar(ContaDao dao) {
        try {
            listaContas = dao.getAll();
            System.out.println("Lista de contas: ");
            for (Conta account : listaContas) {
                System.out.println(account.getCd_conta() + " - " + account.getNm_conta() + " - " + account.getCd_usuario() +
                        " - " + account.getDsc_conta() + " - " + account.getCd_tipo_conta() + " - " + account.getSaldo_conta());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar tipos de contas: " + e.getMessage());
        }
    }
}
