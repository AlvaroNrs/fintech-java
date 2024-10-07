package br.com.fiap.dao;

import br.com.fiap.factory.ConnectionFactory;
import br.com.fiap.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class UsuarioDao {

    private Connection conexao;

    public UsuarioDao() throws SQLException {
        conexao = ConnectionFactory.getConnection();
    }

    public void insert(Usuario usuario) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("INSERT INTO T_USUARIO" +
                " (nm_usuario, sobrenome_usuario, dt_nasc_usuario, email_usuario, senha_usuario)" +
                " VALUES (?, ?, ?, ?, ?)");
        stm.setString(1, usuario.getNm_usuario());
        stm.setString(2, usuario.getSobrenome_usuario());
        stm.setDate(3, Date.valueOf(usuario.getDt_nasc_usuario()));
        stm.setString(4, usuario.getEmail_usuario());
        stm.setString(5, usuario.getSenha_usuario());
        stm.executeUpdate();
    }

    public List<Usuario> getAll() throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_USUARIO");
        ResultSet result = stm.executeQuery();
        List<Usuario> lista = new ArrayList<>();
        while (result.next()){
            lista.add(parseUsuario(result));
        }
        return lista;
    }

    private Usuario parseUsuario(ResultSet result) throws SQLException {
        int cod = result.getInt("cd_usuario");
        String nome = result.getString("nm_usuario");
        String sobrenome = result.getString("sobrenome_usuario");
        LocalDate dataNascimento = LocalDate.parse(result.getDate("dt_nasc_usuario").toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String emailUsuario = result.getString("email_usuario");
        String senhaUsuario = result.getString("senha_usuario");
        return new Usuario(cod, nome, sobrenome, dataNascimento, emailUsuario, senhaUsuario);
    }

    public void fecharConexao() throws SQLException {
        conexao.close();
    }

    //Ignorar, por hora, os seguintes métodos. Eles poderão ser úteis no futuro:
    /*
    public Usuario pesquisarUsuario(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("SELECT * FROM T_USUARIO WHERE cd_usuario = ?");
        stm.setInt(1, codigo);
        ResultSet result = stm.executeQuery();
        if (!result.next())
            throw new EntidadeNaoEcontradaException("Usuário não encontrado");
        return parseUsuario(result);
    }

    public void atualizarUsuario(Usuario usuario) throws SQLException {
        PreparedStatement stm = conexao.prepareStatement("UPDATE T_USUARIO " +
                "SET nm_usuario = ?, sobrenome_usuario = ?, dt_nasc_usuario = ?," +
                " email_usuario = ?, senha_usuario = ? WHERE cd_usuario = ?");
        stm.setString(1, usuario.getNm_usuario());
        stm.setString(2, usuario.getSobrenome_usuario());
        stm.setDate(3, Date.valueOf(usuario.getDt_nasc_usuario()));
        stm.setString(4, usuario.getEmail_usuario());
        stm.setString(5, usuario.getSenha_usuario());
        stm.setInt(6, usuario.getCd_usuario());
        stm.executeUpdate();
    }

    public void removerUsuario(int codigo) throws SQLException, EntidadeNaoEcontradaException {
        PreparedStatement stm = conexao.prepareStatement("DELETE FROM T_USUARIO WHERE cd_usuario = ?");
        stm.setInt(1, codigo);
        int linha = stm.executeUpdate();
        if (linha == 0)
            throw new EntidadeNaoEcontradaException("Usuario não encontrado para ser removido");
    }*/

}
