/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.ferramentas.repository;

import com.sistema.ferramentas.model.FerramentasDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Aluno
 */
@Repository
public class FerramentasRepository {
    public int novoFerramenta(FerramentasDTO ferramentas) {
        int linhas=0;
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt =conn.prepareStatement("insert into tb_ferramenta (nome, horas_uso, vida_util_maxima, status, id_galpao, id_usuario_responsavel) values (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, ferramentas.getNome());
            stmt.setInt(2, ferramentas.getHorasDeUso());
            stmt.setInt(3, ferramentas.getVidaUtilMaxima());
            stmt.setString(4, ferramentas.getStatus());
            stmt.setObject(5, ferramentas.getGalpao());
            stmt.setObject(6, ferramentas.getResponsavel());
            linhas = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return linhas;
    }
    
public List<FerramentasDTO> listaFerramentas() {
    List<FerramentasDTO> listaFerramentas = new ArrayList<>();

    try {
        Connection conn = Conexao.conectar();
        PreparedStatement stmt =null;
        ResultSet rs = null;
        stmt= conn.prepareStatement("select * from tb_ferramenta");
        rs= stmt.executeQuery();
        while (rs.next()) {
            FerramentasDTO ferramenta = new FerramentasDTO();
            ferramenta.setId(rs.getLong("id"));
            ferramenta.setNome(rs.getString("nome"));
            ferramenta.setHorasDeUso(rs.getInt("horas_uso"));
            ferramenta.setVidaUtilMaxima(rs.getInt("vida_util_maxima"));
            ferramenta.setStatus(rs.getString("status"));
            ferramenta.setGalpao(rs.getObject("id_galpao"));
            ferramenta.setResponsavel(rs.getObject("id_usuario_responsavel"));
            listaFerramentas.add(ferramenta);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return listaFerramentas;
}
public FerramentasDTO buscarPorId(int id) {

    FerramentasDTO ferramenta = null;

    try {
        Connection conn = Conexao.conectar();

        PreparedStatement stmt =
            conn.prepareStatement("select * from tb_ferramenta where id = ?");

        stmt.setLong(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            ferramenta = new FerramentasDTO();

            ferramenta.setId(rs.getLong("id"));
            ferramenta.setNome(rs.getString("nome"));
            ferramenta.setHorasDeUso(rs.getInt("horas_uso"));
            ferramenta.setVidaUtilMaxima(rs.getInt("vida_util_maxima"));
            ferramenta.setStatus(rs.getString("status"));
            ferramenta.setGalpao(rs.getObject("id_galpao"));
            ferramenta.setResponsavel(rs.getObject("id_usuario_responsavel"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return ferramenta;
}
    public int deleteById(long id){
        int linhas =0;
     try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("delete from tb_ferramenta Where id=?");
            stmt.setLong(1, id);
            linhas=stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }   
     return linhas;
    }
    public int update(FerramentasDTO ferramenta){
        int linhas =0;
     try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("update tb_ferramenta set nome=?, horas_uso=?, vida_util_maxima=?,status=?, id_galpao=?, id_usuario_responsavel=? where id=?");
            stmt.setString(1, ferramenta.getNome());
            stmt.setInt(2, ferramenta.getHorasDeUso());
            stmt.setInt(3, ferramenta.getVidaUtilMaxima());
            stmt.setString(4, ferramenta.getStatus());
            stmt.setObject(5, ferramenta.getGalpao());
            stmt.setObject(6, ferramenta.getResponsavel());
            stmt.setLong(7, ferramenta.getId());
            linhas=stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
     return linhas;
    }
}
