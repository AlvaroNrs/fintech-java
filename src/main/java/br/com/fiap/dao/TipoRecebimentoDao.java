package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.TipoRecebimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoRecebimentoDao {
    private Connection conexao;

    public TipoRecebimentoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void insert(TipoRecebimento tipoRecebimento) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO T_TIPO_RECEBIMENTO" +
                " (tipo_recebimento)" +
                " VALUES (?)");
        stm.setString(1, tipoRecebimento.getTipo_recebimento());
        stm.executeUpdate();
    }

    public List<TipoRecebimento> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_TIPO_RECEBIMENTO");
        ResultSet result = stm.executeQuery();
        List<TipoRecebimento> lista = new ArrayList<>();
        while (result.next()){
            lista.add(parseTipoRecebimento(result));
        }
        return lista;
    }

    private TipoRecebimento parseTipoRecebimento(ResultSet result) throws SQLException {
        int cod = result.getInt("cd_tipo_recebimento");
        String tipoRecebimento = result.getString("tipo_recebimento");
        return new TipoRecebimento(cod, tipoRecebimento);
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    //Ignorar, por hora, os seguintes métodos. Eles poderão ser úteis no futuro:
    /*
    public TipoRecebimento pesquisarTipoRecebimento(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_TIPO_RECEBIMENTO WHERE cd_tipo_recebimento = ?");
        stm.setInt(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Tipo de Recebimento não encontrado");
        return parseTipoRecebimento(result);
    }

    public void atualizarTipoRecebimento(TipoRecebimento tipoRecebimento) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE T_TIPO_RECEBIMENTO " +
                "SET tipo_recebimento WHERE cd_tipo_recebimento = ?");
        stm.setInt(1, tipoRecebimento.getTipo_recebimento());
        stm.setInt(2, tipoRecebimento.getCd_Tipo_recebimento());
        stm.executeUpdate();
    }

    public void removerTipoRecebimento(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE FROM T_TIPO_RECEBIMENTO WHERE cd_tipo_recebimento = ?");
        stm.setInt(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEcontradaException("Tipo de Recebimento não encontrado para ser removido");
    }*/
}
