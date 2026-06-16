/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.ferramentas.service;

import com.sistema.ferramentas.model.FerramentasDTO;
import com.sistema.ferramentas.repository.FerramentasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class FerramentasService {
    @Autowired
    private FerramentasRepository repository;
    public List<FerramentasDTO>lerTodos(){
        return repository.listaFerramentas();
    }
    public void atualizar(FerramentasDTO ferramentas){
        repository.update(ferramentas);
    }
}
