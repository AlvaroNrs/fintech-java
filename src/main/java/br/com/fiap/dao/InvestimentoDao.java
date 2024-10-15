package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Investimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvestimentoDao {
    private Connection conexao;

    public InvestimentoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void insert(Investimento investimento) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO T_INVESTIMENTO" +
                " (cd_servico, cd_tipo_investimento)" +
                " VALUES (?, ?)");
        stm.setInt(1, investimento.getCd_servico());
        stm.setInt(2, investimento.getCd_tipo_investimento());
        stm.executeUpdate();
    }

    public List<Investimento> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_INVESTIMENTO");
        ResultSet result = stm.executeQuery();
        List<Investimento> lista = new ArrayList<>();
        while (result.next()){
            lista.add(parseInvestimento(result));
        }
        return lista;
    }

    private Investimento parseInvestimento(ResultSet result) throws SQLException {
        int cod = result.getInt("cd_investimento");
        int cdServico = result.getInt("cd_servico");
        int cdTipoInvestimento = result.getInt("cd_tipo_investimento");
        return new Investimento(cod, cdServico, cdTipoInvestimento);
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    //Ignorar, por hora, os seguintes métodos. Eles poderão ser úteis no futuro:
    /*
    public Investimento pesquisarInvestimento(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_INVESTIMENTO WHERE cd_investimento = ?");
        stm.setInt(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Tipo de Investimento não encontrado");
        return parseInvestimento(result);
    }

    public void atualizarInvestimento(Investimento investimento) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE T_INVESTIMENTO " +
                "SET cd_servico = ?, cd_tipo_servico = ? WHERE cd_investimento = ?");
        stm.setInt(1, investimento.getCd_servico());
        stm.setInt(2, investimento.getCd_tipo_investimento());
        stm.setInt(3, investimento.getCd_investimento());
        stm.executeUpdate();
    }

    public void removerInvestimento(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE FROM T_INVESTIMENTO WHERE cd_investimento = ?");
        stm.setInt(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEcontradaException("Tipo de Investimento não encontrado para ser removido");
    }*/
}
