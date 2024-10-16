package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.TipoDespesa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoDespesaDao {

    private Connection conexao;

    public TipoDespesaDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }


    public void insert(TipoDespesa tipodespesa) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO  T_TIPO_DESPESA" +
                " (cd_tipo_despesa, tipo_despesa)" +
                " VALUES (?, ?)");
        stm.setInt(1, tipodespesa.getCd_tipo_despesa ());
        stm.setString (2, tipodespesa.getTipo_despesa ());
        stm.executeUpdate();
    }

    public List<TipoDespesa> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_TIPO_DESPESA");
        ResultSet result = stm.executeQuery();
        List<TipoDespesa> lista = new ArrayList<> ();
        while (result.next()){
            lista.add(parseTipoDespesa(result));
        }
        return lista;
    }

    private TipoDespesa parseTipoDespesa(ResultSet result) throws SQLException {
        int cod = result.getInt("cd_tipo_despesa");
        String cdTipoDespesa = result.getString ("tipo_despesa");
        return new TipoDespesa(cod, cdTipoDespesa);
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }






















}
