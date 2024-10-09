package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Transferencia;
import br.com.fiap.model.Usuario;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransferenciaDao {

    private Connection conexao;

    public TransferenciaDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void insert(Transferencia transferencia) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO T_TRANSFERENCIA" +
                " (cd_conta_beneficiaria, cd_conta_beneficiada, vl_transferencia, dt_transferencia)" +
                " VALUES (?, ?, ?, ?)");
        stm.setInt(1, transferencia.getCd_conta_beneficiaria());
        stm.setInt(2, transferencia.getCd_conta_beneficiada());
        stm.setDouble(3, transferencia.getVl_transferencia());
        stm.setDate(4, Date.valueOf(transferencia.getDt_transferencia()));
        stm.executeUpdate();
    }

    public List<Transferencia> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_TRANSFERENCIA");
        ResultSet result = stm.executeQuery();
        List<Transferencia> lista = new ArrayList<>();
        while (result.next()){
            lista.add(parseTransferencia(result));
        }
        return lista;
    }

    private Transferencia parseTransferencia(ResultSet result) throws SQLException {
        int cod = result.getInt("cd_transferencia");
        int cdContaBeneficiaria = result.getInt("cd_conta_beneficiaria");
        int cdContaBeneficiada = result.getInt("cd_conta_beneficiada");
        double valor = result.getDouble("vl_transferencia");
        LocalDate data = LocalDate.parse(result.getDate("dt_transferencia").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return new Transferencia(cod, cdContaBeneficiaria, cdContaBeneficiada, valor, data);
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    //Ignorar, por hora, os seguintes métodos. Eles poderão ser úteis no futuro:
    /*
    public Transferencia pesquisarTransferencia(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_TRANSFERENCIA WHERE cd_transferencia = ?");
        stm.setInt(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Transferência não encontrada");
        return parseTransferencia(result);
    }

    public void atualizarTransferencia(Transferencia transferencia) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE T_TRANSFERENCIA " +
                "SET cd_conta_beneficiaria = ?, cd_conta_beneficiada = ?, vl_transferencia = ?," +
                " dt_transferencia = ? WHERE cd_transferencia = ?");
        stm.setInt(1, transferenciaget.getCd_transferencia());
        stm.setInt(2, transferencia.getCd_conta_beneficiaria());
        stm.setInt(3, transferencia.getCd_conta_beneficiada());
        stm.setDouble(4, transferencia.getVl_transferencia());
        stm.setDate(5, Date.valueOf(transferencia.getDt_transferencia()));
        stm.executeUpdate();
    }

    public void removerTransferencia(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE FROM T_TRANSFERENCIA WHERE cd_transferencia = ?");
        stm.setInt(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEcontradaException("Transferencia não encontrada para ser removida");
    }*/

}
