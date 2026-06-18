/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.ferramentas.repository;

import com.sistema.ferramentas.model.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class UsuarioRepository {
        public UsuarioDTO login(String login, String senha) {
        UsuarioDTO user = new UsuarioDTO();
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("select * from tb_usuario where login = ? and senha = ?");
            stmt.setString(1, login);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setlogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                user.setPerfil(rs.getString("perfil"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
