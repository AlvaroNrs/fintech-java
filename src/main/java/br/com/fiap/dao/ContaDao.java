package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Conta;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ContaDao {
    private Connection conexao;

    public ContaDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void insert(Conta conta) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO T_CONTA" +
                " (nm_conta, cd_usuario, dsc_conta, cd_tipo_conta, saldo_conta)" +
                " VALUES (?, ?, ?, ?, ?)");
        stm.setString(1, conta.getNm_conta());
        stm.setInt(2, conta.getCd_usuario());
        stm.setString(3, conta.getDsc_conta());
        stm.setInt(4, conta.getCd_tipo_conta());
        stm.setDouble(5, conta.getSaldo_conta());
        stm.executeUpdate();
    }

    public List<Conta> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_CONTA");
        ResultSet result = stm.executeQuery();
        List<Conta> lista = new ArrayList<>();
        while (result.next()){
            lista.add(parseConta(result));
        }
        return lista;
    }

    private Conta parseConta(ResultSet result) throws SQLException {
        int cod = result.getInt("cd_conta");
        String nome = result.getString("nm_conta");
        int codUsuario = result.getInt("cd_usuario");
        String descricao = result.getString("dsc_conta");
        int cdTipoConta = result.getInt("cd_tipo_conta");
        double saldo = result.getDouble("saldo_conta");
        return new Conta(cod, nome, codUsuario, descricao, cdTipoConta, saldo);
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    //Ignorar, por hora, os seguintes métodos. Eles poderão ser úteis no futuro:
    /*
    public Conta pesquisarConta(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_CONTA WHERE cd_conta = ?");
        stm.setInt(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Conta não encontrada");
        return parseConta(result);
    }

    public void atualizarConta(Conta usuario) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE T_CONTA " +
                "SET nm_conta = ?, cd_usuario = ?, dsc_conta = ?," +
                " cd_tipo_conta = ?, saldo_conta = ? WHERE cd_conta = ?");
        stm.setString(1, conta.getCd_conta());
        stm.setString(2, conta.getNm_conta());
        stm.setInt(3, conta.getCd_usuario());
        stm.setString(4, conta.getDsc_conta());
        stm.setInt(5, conta.getCd_tipo_conta());
        stm.setDouble(6, conta.getSaldo_conta());
        stm.executeUpdate();
    }

    public void removerConta(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE FROM T_CONTA WHERE cd_conta = ?");
        stm.setInt(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEcontradaException("Conta não encontrada para ser removida");
    }*/
}
