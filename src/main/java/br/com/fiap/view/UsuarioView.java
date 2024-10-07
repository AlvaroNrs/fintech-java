package br.com.fiap.view;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UsuarioView {
    public static List<Usuario> listaUsuarios = new ArrayList<>();
    public static void main(String[] args) {
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void testarCadastro(UsuarioDao dao) {
        Usuario usuario1 = new Usuario("Usuario1", "Sobrenome Usuario1", LocalDate.parse(new Date().toString()),
                "usuario.1@usuario.com", "usuario154321");
        Usuario usuario2 = new Usuario("Usuario2", "Sobrenome Usuario2", LocalDate.parse(new Date().toString()),
                "usuario.2@usuario.com", "usuario278945");
        Usuario usuario3 = new Usuario("Usuario3", "Sobrenome Usuario3", LocalDate.parse(new Date().toString()),
                "usuario.3@usuario.com", "usuario341575");
        Usuario usuario4 = new Usuario("Usuario4", "Sobrenome Usuario4", LocalDate.parse(new Date().toString()),
                "usuario.4@usuario.com", "usuario154321");
        Usuario usuario5 = new Usuario("Usuario5", "Sobrenome Usuario5", LocalDate.parse(new Date().toString()),
                "usuario.5@usuario.com", "usuario578923");
        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        listaUsuarios.add(usuario3);
        listaUsuarios.add(usuario4);
        listaUsuarios.add(usuario5);
        try {
            for (Usuario user : listaUsuarios){
                dao.insert(user);
                System.out.println("Usuário " + user.getNm_usuario() + " cadastrado com sucesso!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    private static void listar(UsuarioDao dao) {
        try {
            listaUsuarios = dao.getAll();
            System.out.println("Lista de usuários: ");
            for (Usuario usuario : listaUsuarios) {
                System.out.println(usuario.getCd_usuario() + " - " + usuario.getNm_usuario() + ", " +
                        usuario.getSobrenome_usuario() + ", " + usuario.getDt_nasc_usuario() + ", " +
                        usuario.getEmail_usuario() + ", " + usuario.getSenha_usuario());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar usuários: " + e.getMessage());
        }
    }

}
