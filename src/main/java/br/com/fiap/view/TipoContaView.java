package br.com.fiap.view;

import br.com.fiap.dao.TipoContaDao;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.TipoConta;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TipoContaView {
    public static List<TipoConta> listaTiposContas = new ArrayList<>();
    public static void main(String[] args) {
        TipoContaDao dao;
        try {
            dao = new TipoContaDao();
            //testarCadastro(dao);
            listar(dao);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void testarCadastro(TipoContaDao dao) {
        TipoConta tipoConta1 = new TipoConta("Corrente");
        TipoConta tipoConta2= new TipoConta("Poupança");
        TipoConta tipoConta3= new TipoConta("Depósito");
        TipoConta tipoConta4= new TipoConta("Salário");
        TipoConta tipoConta5= new TipoConta("Pagamentos");
        listaTiposContas.add(tipoConta1);
        listaTiposContas.add(tipoConta2);
        listaTiposContas.add(tipoConta3);
        listaTiposContas.add(tipoConta4);
        listaTiposContas.add(tipoConta5);
        try {
            for (TipoConta accountType : listaTiposContas){
                dao.insert(accountType);
                System.out.println("Tipo de Conta " + accountType.getTipo_conta() + " cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar tipo de conta: " + e.getMessage());
        }
    }

    private static void listar(TipoContaDao dao) {
        try {
            listaTiposContas = dao.getAll();
            System.out.println("Lista de contas: ");
            for (TipoConta accoutType : listaTiposContas) {
                System.out.println(accoutType.getCd_tipo_conta() + " - " + accoutType.getTipo_conta());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar tipos de contas: " + e.getMessage());
        }
    }

}
