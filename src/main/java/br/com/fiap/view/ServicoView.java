package br.com.fiap.view;

import br.com.fiap.dao.ServicoDao;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Servico;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ServicoView {
    public static List<Servico> listaServicos = new ArrayList<>();
    public static void main(String[] args) {
        ServicoDao dao;
        try {
            dao = new ServicoDao();
            //testarCadastro(dao);
            listar(dao);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void testarCadastro(ServicoDao dao) {
        // create a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dtServ = "04-10-2024";
        Servico servico1 = new Servico( 1,  "Servico1", 100,
                LocalDate.parse(dtServ, formatter), "Investimento no Tesouro Direto");
        Servico servico2 = new Servico( 2,  "Servico2", 200,
                LocalDate.parse(dtServ, formatter), "Despesa com curso");
        Servico servico3 = new Servico( 3,  "Servico3", 300,
                LocalDate.parse(dtServ, formatter), "Recebimento de Freelance");
        Servico servico4 = new Servico( 4,  "Servico4", 400,
                LocalDate.parse(dtServ, formatter), "Despesa com Pet");
        Servico servico5 = new Servico( 5,  "Servico5", 500,
                LocalDate.parse(dtServ, formatter), "Recebimento de Vale");
        listaServicos.add(servico1);
        listaServicos.add(servico2);
        listaServicos.add(servico3);
        listaServicos.add(servico4);
        listaServicos.add(servico5);
        try {
            for (Servico service : listaServicos){
                dao.insert(service);
                System.out.println("Serviço " + service.getNm_servico() + " cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    private static void listar(ServicoDao dao) {
        try {
            listaServicos = dao.getAll();
            System.out.println("Lista de serviços: ");
            for (Servico servico : listaServicos) {
                System.out.println(servico.getCd_servico() + " - " + servico.getNm_servico() + ", " +
                        servico.getVl_servico() + ", " + servico.getDt_servico() + ", " +
                        servico.getDsc_servico());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar serviços: " + e.getMessage());
        }
    }
}
