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
    private Long id;
    private String nome;
    private Long horasDeUso;
    private Long vidaUtilMaxima;

    public FerramentasDTO() {
    }

    public FerramentasDTO(Long id, String nome, Long horasDeUso, Long vidaUtilMaxima) {
        this.id = id;
        this.nome = nome;
        this.horasDeUso = horasDeUso;
        this.vidaUtilMaxima = vidaUtilMaxima;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getHorasDeUso() {
        return horasDeUso;
    }

    public void setHorasDeUso(Long horasDeUso) {
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

    return (horasDeUso.doubleValue() / vidaUtilMaxima.doubleValue()) * 100;
}
}
