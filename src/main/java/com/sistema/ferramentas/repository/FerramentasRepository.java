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
            PreparedStatement stmt =conn.prepareStatement("insert into tb_ferramenta (nome, horasDeUso, vidaUtilMaxima) values (?, ?, ?)");
            stmt.setString(1, ferramentas.getNome());
            stmt.setInt(2, ferramentas.getHorasDeUso());
            stmt.setLong(3, ferramentas.getVidaUtilMaxima());

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
            ferramenta.setId(rs.getInt("id"));
            ferramenta.setNome(rs.getString("nome"));
            ferramenta.setHorasDeUso(rs.getInt("horasDeUso"));
            ferramenta.setVidaUtilMaxima(rs.getLong("vidaUtilMaxima"));
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

        stmt.setInt(1, id);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            ferramenta = new FerramentasDTO();

            ferramenta.setId(rs.getInt("id"));
            ferramenta.setNome(rs.getString("nome"));
            ferramenta.setHorasDeUso(rs.getInt("horasDeUso"));
            ferramenta.setVidaUtilMaxima(rs.getLong("vidaUtilMaxima"));
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return ferramenta;
}
    public int deleteById(int id){
        int linhas =0;
     try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("delete from tb_ferramenta Where id=?");
            stmt.setInt(1, id);
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
            PreparedStatement stmt = conn.prepareStatement("update tb_ferramenta set nome=?, horasDeUso=?, vidaUtilMaxima=? where id=?");
            stmt.setString(1, ferramenta.getNome());
            stmt.setInt(2, ferramenta.getHorasDeUso());
            stmt.setLong(3, ferramenta.getVidaUtilMaxima());
            stmt.setInt(4, ferramenta.getId());
            linhas=stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
     return linhas;
    }
}
