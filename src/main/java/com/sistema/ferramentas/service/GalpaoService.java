/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sistema.ferramentas.service;

import com.sistema.ferramentas.model.GalpaoDTO;
import com.sistema.ferramentas.repository.GalpaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Aluno
 */
@Service
public class GalpaoService {
    @Autowired
    private GalpaoRepository repository;
    public List<GalpaoDTO>listarFerramentas(){
        return repository.listaFerramentas();
    }
}
