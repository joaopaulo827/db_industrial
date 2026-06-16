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
    private Long id_ferramentas;
    private String nome;
    private Long horasDeUso;
    private Long vidaUtilMaxima;

    public FerramentasDTO() {
    }

    public FerramentasDTO(Long id_ferramentas, String nome, Long horasDeUso, Long vidaUtilMaxima) {
        this.id_ferramentas = id_ferramentas;
        this.nome = nome;
        this.horasDeUso = horasDeUso;
        this.vidaUtilMaxima = vidaUtilMaxima;
    }

    public Long getId_ferramentas() {
        return id_ferramentas;
    }

    public void setId_ferramentas(Long id_ferramentas) {
        this.id_ferramentas = id_ferramentas;
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
    public double getPercentualDesgaste(){
        return (horasDeUso / vidaUtilMaxima * 100);
    }
}
