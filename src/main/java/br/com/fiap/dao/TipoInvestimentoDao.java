package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.TipoInvestimento;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TipoInvestimentoDao {

    private Connection conexao;

    public TipoInvestimentoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void insert(TipoInvestimento tipoInvestimento) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO T_TIPO_INVESTIMENTO" +
                " (tipo_investimento)" +
                " VALUES (?)");
        stm.setString(1, tipoInvestimento.getTipo_investimento());
        stm.executeUpdate();
    }

    public List<TipoInvestimento> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_TIPO_INVESTIMENTO");
        ResultSet result = stm.executeQuery();
        List<TipoInvestimento> lista = new ArrayList<>();
        while (result.next()){
            lista.add(parseTipoInvestimento(result));
        }
        return lista;
    }

    private TipoInvestimento parseTipoInvestimento(ResultSet result) throws SQLException {
        int cod = result.getInt("cd_tipo_investimento");
        String tipoInvestimento = result.getString("tipo_investimento");
        return new TipoInvestimento(cod, tipoInvestimento);
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    //Ignorar, por hora, os seguintes métodos. Eles poderão ser úteis no futuro:
    /*
    public TipoInvestimento pesquisarTipoInvestimento(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_TIPO_INVESTIMENTO WHERE cd_tipo_investimento = ?");
        stm.setInt(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Tipo de Investimento não encontrado");
        return parseTipoInvestimento(result);
    }

    public void atualizarTipoInvestimento(TipoInvestimento tipoInvestimento) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE T_TIPO_INVESTIMENTO " +
                "SET tipo_investimento WHERE cd_tipo_investimento = ?");
        stm.setInt(1, tipoInvestimento.getTipo_investimento());
        stm.setInt(2, transferenciaget.getCd_Tipo_investimento());
        stm.executeUpdate();
    }

    public void removerTipoInvestimento(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE FROM T_TIPO_INVESTIMENTO WHERE cd_tipo_investimento = ?");
        stm.setInt(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEcontradaException("Tipo de Investimento não encontrado para ser removido");
    }*/
}
