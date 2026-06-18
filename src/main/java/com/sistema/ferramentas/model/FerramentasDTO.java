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
    private int horasDeUso;
    private int vidaUtilMaxima;
    private String status;
    private Object galpao;
    private Object responsavel;

    public FerramentasDTO() {
    }

    public FerramentasDTO(Long id, String nome, int horasDeUso, int vidaUtilMaxima, String status, Object galpao, Object responsavel) {
        this.id = id;
        this.nome = nome;
        this.horasDeUso = horasDeUso;
        this.vidaUtilMaxima = vidaUtilMaxima;
        this.status = status;
        this.galpao = galpao;
        this.responsavel = responsavel;
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

    public int getHorasDeUso() {
        return horasDeUso;
    }

    public void setHorasDeUso(int horasDeUso) {
        this.horasDeUso = horasDeUso;
    }

    public int getVidaUtilMaxima() {
        return vidaUtilMaxima;
    }

    public void setVidaUtilMaxima(int vidaUtilMaxima) {
        this.vidaUtilMaxima = vidaUtilMaxima;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getGalpao() {
        return galpao;
    }

    public void setGalpao(Object galpao) {
        this.galpao = galpao;
    }

    public Object getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Object responsavel) {
        this.responsavel = responsavel;
    }
        public double getPercentualDesgaste() {
    if (vidaUtilMaxima == 0 || vidaUtilMaxima == 0) {
        return 0;
    }

    return ((double) horasDeUso / vidaUtilMaxima) * 100;
}
}