package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Despesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DespesaDao {
    private Connection conexao;

    public DespesaDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void insert(Despesa despesa) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO T_DESPESA" +
                " (cd_servico, cd_tipo_despesa)" +
                " VALUES (?, ?)");
        stm.setInt(1, despesa.getCd_servico());
        stm.setInt(2, despesa.getCd_tipo_despesa());
        stm.executeUpdate();
    }

    public List<Despesa> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_DESPESA");
        ResultSet result = stm.executeQuery();
        List<Despesa> lista = new ArrayList<>();
        while (result.next()){
            lista.add(parseDespesa(result));
        }
        return lista;
    }

    private Despesa parseDespesa(ResultSet result) throws SQLException {
        int cod = result.getInt("cd_despesa");
        int cdServico = result.getInt("cd_servico");
        int cdTipoDespesa = result.getInt("cd_tipo_despesa");
        return new Despesa(cod, cdServico, cdTipoDespesa);
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    //Ignorar, por hora, os seguintes métodos. Eles poderão ser úteis no futuro:
    /*
    public Despesa pesquisarDespesa(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_DESPESA WHERE cd_despesa = ?");
        stm.setInt(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Tipo de Despesa não encontrado");
        return parseDespesa(result);
    }

    public void atualizarDespesa(Despesa despesa) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE T_DESPESA " +
                "SET cd_servico = ?, cd_tipo_servico = ? WHERE cd_despesa = ?");
        stm.setInt(1, despesa.getCd_servico());
        stm.setInt(2, despesa.getCd_tipo_despesa());
        stm.setInt(3, despesa.getCd_despesa());
        stm.executeUpdate();
    }

    public void removerDespesa(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE FROM T_DESPESA WHERE cd_despesa = ?");
        stm.setInt(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEcontradaException("Tipo de Despesa não encontrado para ser removido");
    }*/
}
