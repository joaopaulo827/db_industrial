/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.ferramentas.service;

import com.sistema.ferramentas.model.FerramentasDTO;
import com.sistema.ferramentas.repository.FerramentasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Aluno
 */
@Service
public class FerramentasService {
    @Autowired
    private FerramentasRepository repository;
    
    public List<FerramentasDTO>listarFerramentas(){
        return repository.listaFerramentas();
    }
    public void criar(FerramentasDTO ferramentas){
        if(ferramentas.getNome().equals("")){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Não tem Nome");
        }
        if(ferramentas.getVidaUtilMaxima()<= 0){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Erro no Vida Maxima");
        }
        if(ferramentas.getHorasDeUso()< 0){
            ferramentas.setHorasDeUso(1);
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Erro na Hora de Uso");
        }
        int linhas = repository.novoFerramenta(ferramentas);
        if(linhas == 0){
            throw new ResponseStatusException(HttpStatusCode.valueOf(400), "Erro ao adicionar ao Banco de dados");
        }
    }
    public FerramentasDTO buscarPorId(int id) {
    return repository.buscarPorId(id);
}
    public void atualizar(FerramentasDTO ferramentas){
        repository.update(ferramentas);
    }
}
