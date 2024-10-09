package br.com.fiap.view;

import br.com.fiap.dao.TransferenciaDao;
import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Transferencia;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransferenciaView {
    public static List<Transferencia> listaTransferencia = new ArrayList<>();
    public static void main(String[] args) {
        TransferenciaDao dao;
        try {
            dao = new TransferenciaDao();
            //testarCadastro(dao);
            listar(dao);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void testarCadastro(TransferenciaDao dao) {
        // create a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dtNasc = "10-12-1995";
        Transferencia transferencia1 = new Transferencia(1, 2, 500.0,  LocalDate.parse(dtNasc, formatter));
        Transferencia transferencia2 = new Transferencia(2, 3, 750.0,  LocalDate.parse(dtNasc, formatter));
        Transferencia transferencia3 = new Transferencia(3, 4, 1000.0,  LocalDate.parse(dtNasc, formatter));
        Transferencia transferencia4 = new Transferencia(4, 5, 1250.0,  LocalDate.parse(dtNasc, formatter));
        Transferencia transferencia5 = new Transferencia(5, 1, 1500.0,  LocalDate.parse(dtNasc, formatter));
        listaTransferencia.add(transferencia1);
        listaTransferencia.add(transferencia2);
        listaTransferencia.add(transferencia3);
        listaTransferencia.add(transferencia4);
        listaTransferencia.add(transferencia5);
        try {
            for (Transferencia transfer : listaTransferencia){
                dao.insert(transfer);
                System.out.println("Transferência da conta " + transfer.getCd_conta_beneficiaria() + " para a conta " +
                        transfer.getCd_conta_beneficiada() + " cadastrada com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    private static void listar(TransferenciaDao dao) {
        try {
            listaTransferencia = dao.getAll();
            System.out.println("Lista de transferência: ");
            for (Transferencia transferencia : listaTransferencia) {
                System.out.println(transferencia.getCd_transferencia() + " - " + transferencia.getCd_conta_beneficiaria() + ", " +
                        transferencia.getCd_conta_beneficiada() + ", " + transferencia.getVl_transferencia() + ", " +
                        transferencia.getDt_transferencia());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar transferência: " + e.getMessage());
        }
    }
}
