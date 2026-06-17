/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.ferramentas.model;

/**
 *
 * @author Aluno
 */
public class FerramentasDTO {
    private int id;
    private String nome;
    private int horasDeUso;
    private Long vidaUtilMaxima;

    public FerramentasDTO() {
    }

    public FerramentasDTO(int id, String nome, int horasDeUso, Long vidaUtilMaxima) {
        this.id = id;
        this.nome = nome;
        this.horasDeUso = horasDeUso;
        this.vidaUtilMaxima = vidaUtilMaxima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasDeUso() {
        return horasDeUso;
    }

    public void setHorasDeUso(int horasDeUso) {
        this.horasDeUso = horasDeUso;
    }

    public Long getVidaUtilMaxima() {
        return vidaUtilMaxima;
    }

    public void setVidaUtilMaxima(Long vidaUtilMaxima) {
        this.vidaUtilMaxima = vidaUtilMaxima;
    }
    public double getPercentualDesgaste() {
    if (vidaUtilMaxima == null || vidaUtilMaxima == 0) {
        return 0;
    }

    return ((double) horasDeUso / vidaUtilMaxima) * 100;
}
}
