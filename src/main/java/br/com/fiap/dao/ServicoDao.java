package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Servico;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ServicoDao {
    private Connection conexao;

    public ServicoDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void insert(Servico servico) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO T_SERVICO" +
                " (cd_conta, nm_servico, vl_servico, dt_servico, dsc_servico)" +
                " VALUES (?, ?, ?, ?, ?)");
        stm.setInt(1, servico.getCd_conta());
        stm.setString(2, servico.getNm_servico());
        stm.setDouble(3, servico.getVl_servico());
        stm.setDate(4, Date.valueOf(servico.getDt_servico()));
        stm.setString(5, servico.getDsc_servico());

        stm.executeUpdate();
    }

    public List<Servico> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_SERVICO");
        ResultSet result = stm.executeQuery();
        List<Servico> lista = new ArrayList<>();
        while (result.next()){
            lista.add(parseServico(result));
        }
        return lista;
    }

    private Servico parseServico(ResultSet result) throws SQLException {
        int cod = result.getInt("cd_servico");
        int codConta = result.getInt("cd_conta");
        String nome = result.getString("nm_servico");
        double valor = result.getDouble("vl_servico");
        LocalDate data = LocalDate.parse(result.getDate("dt_servico").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String descricao = result.getString("dsc_servico");

        return new Servico(cod, codConta, nome, valor, data, descricao);
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    //Ignorar, por hora, os seguintes métodos. Eles poderão ser úteis no futuro:
    /*
    public Servico pesquisarServico(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_SERVICO WHERE cd_servico = ?");
        stm.setInt(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Servico não encontrada");
        return parseServico(result);
    }

    public void atualizarServico(Servico servico) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE T_SERVICO " +
                "SET cd_conta = ?, nm_servico = ?, vl_servico = ?, td_servico = ?," +
                " dsc_servico = ? WHERE cd_servico = ?");
        stm.setInt(1, servico.getCd_servico());
        stm.setInt(2, servico.getCd_conta());
        stm.setString(3, servico.getNm_servico());
        stm.setDouble(4, servico.getVl_servico);
        stm.setString(5, servico.getDsc_servico());
        stm.executeUpdate();
    }

    public void removerServico(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE FROM T_SERVICO WHERE cd_servico = ?");
        stm.setInt(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEcontradaException("Servico não encontrado para ser removido");
    }*/
}
