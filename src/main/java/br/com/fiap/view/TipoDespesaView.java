package br.com.fiap.view;

import br.com.fiap.dao.TipoDespesaDao;
import br.com.fiap.model.TipoDespesa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoDespesaView {


    public static List<TipoDespesa> listaTiposDespesas = new ArrayList<> ();

    public static void main(String[] args) {
        TipoDespesaDao dao;
        try {
            dao = new TipoDespesaDao ();
            //testarCadastro(dao);
            listar(dao);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }


    private static void testarCadastro(TipoDespesaDao dao) {
        TipoDespesa TipoDespesa1 = new TipoDespesa(1, "Aluguel");
        TipoDespesa TipoDespesa2 = new TipoDespesa(2,"Compras");
        TipoDespesa TipoDespesa3 = new TipoDespesa(3,"Conserto do Carro");
        TipoDespesa TipoDespesa4 = new TipoDespesa(4,"Viagem");
        TipoDespesa TipoDespesa5 = new TipoDespesa(5,"Reforma");
        listaTiposDespesas.add(TipoDespesa1);
        listaTiposDespesas.add(TipoDespesa2);
        listaTiposDespesas.add(TipoDespesa3);
        listaTiposDespesas.add(TipoDespesa4);
        listaTiposDespesas.add(TipoDespesa5);
        try {
            for (TipoDespesa despesas : listaTiposDespesas){
                dao.insert(despesas);
                System.out.println("Tipo de Investimento " + despesas.getTipo_despesa () + " cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar tipo de conta: " + e.getMessage());
        }
    }

    private static void listar(TipoDespesaDao dao) {
        try {
            listaTiposDespesas = dao.getAll();
            System.out.println("Lista de Tipo Despensas: ");
            for (TipoDespesa despesas : listaTiposDespesas) {
                System.out.println(despesas.getCd_tipo_despesa () + " - " + despesas.getTipo_despesa ());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar tipos despesas: " + e.getMessage());
        }
    }
}















