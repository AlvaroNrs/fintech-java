package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.TipoConta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoContaDao {

    private Connection conexao;

    public TipoContaDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void insert(TipoConta tipoConta) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO T_TIPO_CONTA" +
                " (tipo_conta)" +
                " VALUES (?)");
        stm.setString(1, tipoConta.getTipo_conta());
        stm.executeUpdate();
    }

    public List<TipoConta> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_TIPO_CONTA");
        ResultSet result = stm.executeQuery();
        List<TipoConta> lista = new ArrayList<>();
        while (result.next()){
            lista.add(parseTipoConta(result));
        }
        return lista;
    }

    private TipoConta parseTipoConta(ResultSet result) throws SQLException {
        int cod = result.getInt("cd_tipo_conta");
        String tipoConta = result.getString("tipo_conta");
        return new TipoConta(cod, tipoConta);
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    //Ignorar, por hora, os seguintes métodos. Eles poderão ser úteis no futuro:
    /*
    public TipoConta pesquisarTipoConta(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_TIPO_CONTA WHERE cd_tipo_conta = ?");
        stm.setInt(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Tipo de Conta não encontrada");
        return parseTipoConta(result);
    }

    public void atualizarTipoConta(TipoConta tipoConta) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE T_TIPO_CONTA " +
                "SET tipo_conta = ? WHERE cd_tipo_conta = ?");
        stm.setString(1, tipoConta.getTipo_conta());
        stm.setInt(2, tipoConta.getCd_tipo_conta());
        stm.executeUpdate();
    }

    public void removerTipoConta(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE FROM T_TIPO_CONTA WHERE cd_tipo_conta = ?");
        stm.setInt(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEcontradaException("Tipo de Conta não encontrado para ser removido");
    }*/

}
