package br.com.fiap.view;

import br.com.fiap.dao.UsuarioDao;
import br.com.fiap.model.Usuario;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UsuarioView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UsuarioDao dao;
        try {
            dao = new UsuarioDao();
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    private static void testarCadastro(Scanner scanner, UsuarioDao dao) {
        Usuario usuario1 = new Usuario("Usuario", "Sobrenome Usuario", LocalDate.parse(new Date().toString()),
                "usuario.1@usuario.com", "usuario154321");
        try {
            dao.insert(usuario1);
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    private static void listar(UsuarioDao dao) {
        try {
            List<Usuario> usuarios = dao.getAll();
            System.out.println("Lista de usuários:");
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.getCd_usuario() + " - " + usuario.getNm_usuario() + ", " +
                        usuario.getSobrenome_usuario() + ", " + usuario.getDt_nasc_usuario() + ", " +
                        usuario.getEmail_usuario() + ", " + usuario.getSenha_usuario());
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar produtos: " + e.getMessage());
        }
    }

}
