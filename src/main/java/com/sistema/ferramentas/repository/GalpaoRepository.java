package com.sistema.ferramentas.repository;


import com.sistema.ferramentas.model.GalpaoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Aluno
 */
@Repository
public class GalpaoRepository {
    public List<GalpaoDTO> listaFerramentas() {
    List<GalpaoDTO> listaGalpao = new ArrayList<>();

    try {
        Connection conn = Conexao.conectar();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        stmt= conn.prepareStatement("select * from tb_galpao");
        rs= stmt.executeQuery();
        while (rs.next()) {
            GalpaoDTO lista = new GalpaoDTO();
            lista.setId(rs.getLong("id"));
            lista.setNome(rs.getString("nome"));
            lista.setAtivo(rs.getBoolean("ativo"));
            listaGalpao.add(lista);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return listaGalpao;
}
public GalpaoDTO listarAtivos(boolean ativo) {

    GalpaoDTO ativo1 = null;

    try {
        Connection conn = Conexao.conectar();

        PreparedStatement stmt =
            conn.prepareStatement("select * from tb_galpao where ativo = 1");

        stmt.setBoolean(1, ativo);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            ativo1 = new GalpaoDTO();
            ativo1.setId(rs.getLong("id"));
            ativo1.setNome(rs.getString("nome"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return ativo1;
}    
}
