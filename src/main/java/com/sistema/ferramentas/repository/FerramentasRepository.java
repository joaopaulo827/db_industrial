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
        try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("insert into tb_ferramenta (nome, horasDeUso, vidaUtilMaxima) values (?, ?, ?)");
            stmt.setString(1, ferramentas.getNome());
            stmt.setLong(2, ferramentas.getHorasDeUso());
            stmt.setLong(3, ferramentas.getVidaUtilMaxima());

            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
public List<FerramentasDTO> listaFerramentas() {
    List<FerramentasDTO> listaFerramentas = new ArrayList<>();

    try {
        Connection conn = Conexao.conectar();
        PreparedStatement stmt = conn.prepareStatement("select * from tb_ferramenta");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {

            System.out.println("DEBUG nome = " + rs.getString("nome"));

            FerramentasDTO f = new FerramentasDTO(
                rs.getLong("id"),
                rs.getString("nome"),
                rs.getLong("horasDeUso"),
                rs.getLong("vidaUtilMaxima")
            );

            System.out.println("OBJETO CRIADO = " + f.getNome());

            listaFerramentas.add(f);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return listaFerramentas;
}
    public void deleteById(Long id){
     try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("delete from tb_ferramenta Where id=?");
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }
    public void update(FerramentasDTO ferramenta){
     try {
            Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement("update tb_ferramenta set nome=?, horasDeUso=?, vidaUtilMaxima=? where id=?");
            stmt.setString(1, ferramenta.getNome());
            stmt.setLong(2, ferramenta.getHorasDeUso());
            stmt.setLong(3, ferramenta.getVidaUtilMaxima());
            stmt.setLong(4, ferramenta.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }    
    }
}
