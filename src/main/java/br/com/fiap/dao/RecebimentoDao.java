package br.com.fiap.dao;


import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Recebimento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecebimentoDao {

    private Connection conexao;

    public RecebimentoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();

    }

    public void insert(Recebimento recebimento) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO T_RECEBIMENTO" +
                " (cd_servico, cd_tipo_recebimento)" +
                " VALUES (?, ?)");
        stm.setInt(1, recebimento.getCd_servico());
        stm.setInt(2, recebimento.getCd_tipo_recebimento());
        stm.executeUpdate();
    }


   public List<Recebimento> getAll() throws SQLException {
       PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_RECEBIMENTO");
       ResultSet result = stm.executeQuery();
       List<Recebimento> lista = new ArrayList<>();
       while (result.next()){
           lista.add(parseRecebimento(result));
       }
       return lista;
   }


   private Recebimento parseRecebimento(ResultSet result) throws SQLException {
        int cod = result.getInt("cd_recebimento");
        int cdServico = result.getInt("cd_servico");
        int cdTipoRecebimento = result.getInt("cd_tipo_recebimento");
        return new Recebimento(cod, cdServico, cdTipoRecebimento);
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    //Recebimento ****  Ignorar, por hora, os seguintes métodos. Eles poderão ser úteis no futuro:
   /*
    public Recebimento pesquisarRecebimento(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_RECEBIMENTO WHERE cd_recebimento = ?");
        stm.setInt(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Recebimento não encontrado");
        return parseRecebimento(result);
    }

    public void atualizarRecebimento(Recebimento recebimento) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE T_RECEBIMENTO " +
                "SET cd_servico = ?, cd_tipo_recebimento = ? WHERE cd_recebimento = ?");
        stm.setInt(1, recebimento.getCd_servico());
        stm.setInt(2, recebimento.getCd_tipo_recebimento());
        stm.setInt(3, recebimento.getCd_recebimento());
        stm.executeUpdate();
    }

    public void removerRecebimento(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE FROM T_RECEBIMENTO WHERE cd_recebimento = ?");
        stm.setInt(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEcontradaException("Tipo de recebimento não encontrado para ser removido");
    }*/





}
